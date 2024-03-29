package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.MenuItem;


public class MenuApp {
   
    @FXML
    private AnchorPane ap;

    @FXML
    private AnchorPane optionPane;

    @FXML
    public void handleMenuVacinaClick(ActionEvent event) {
        MenuItem menu = (MenuItem) event.getTarget();

        loadPage(menu.getId());
        
    }

    public void loadPage(String page){
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/"+page + ".fxml"));
           AnchorPane layout = loader.load();

            // Definir o novo layout carregado como o conteúdo do AnchorPane
           ap.getChildren().clear();
           ap.getChildren().add(layout);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // private void alert(){
    //     Alert alert = new Alert(Alert.AlertType.INFORMATION);
    //     alert.setTitle("ALerta");
    //     alert.setHeaderText("Menu ");
    //     alert.setContentText("Texto principal");
    //     alert.show();
    // }
}
