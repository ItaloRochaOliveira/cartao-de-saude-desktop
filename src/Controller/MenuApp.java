package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuApp {
    // @FXML
    // private BorderPane bp;

    @FXML
    private AnchorPane ap;

    @FXML
    public Menu opcoes;

    // @FXML
    // private void home(MouseEvent event){
    //     bp.setCenter(ap);
    // }

    @FXML
    public void handleMenuVacinaClick() {
        loadPage(opcoes.getId());
    }

    public void loadPage(String page){
        // Border root = null;

        try {
            // System.out.println(getClass().getResource("/View/"+page + ".fxml"));
            // System.out.println(ap.getId());

           FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/"+page + ".fxml"));
           AnchorPane layout = loader.load();

            // Definir o novo layout carregado como o conteúdo do AnchorPane
           ap.getChildren().clear();
           ap.getChildren().add(layout);

        } catch (IOException e) {
            System.out.println(e);
        }


    }

    private void alert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALerta");
        alert.setHeaderText("Menu ");
        alert.setContentText("Texto principal");
        alert.show();
    }
}
