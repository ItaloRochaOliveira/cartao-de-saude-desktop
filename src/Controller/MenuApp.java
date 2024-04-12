package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuItem;


public class MenuApp {
   
    @FXML
    private AnchorPane ap;

    @FXML
    private AnchorPane optionPane;

    @FXML
    public void handleMenuVacinaClick(ActionEvent event) {
        MenuItem menu = (MenuItem) event.getTarget();

        System.out.println("/View/vacinaLayout" + menu.getId() + ".fxml");

        if (menu.getText().equals("Open Vacina")) {
            loadPage("/View/vacinaLayout/" + menu.getId() + ".fxml");
        } else if(menu.getText().equals("Open Paciente")){
            loadPage("/View/pacienteLayout/" + menu.getId() + ".fxml");
        } else if(menu.getId() == "opcoesCartao"){
            loadPage("/View/cartaoLayout/" + menu.getId() + ".fxml");
        }

    }

    public void loadPage(String page){
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
           VBox layout = loader.load();

            // Definir o novo layout carregado como o conteúdo do AnchorPane
           ap.getChildren().clear();
           ap.getChildren().add(layout);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
