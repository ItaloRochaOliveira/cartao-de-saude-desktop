package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuApp {
    @FXML
    public Menu menuVacina;

    @FXML
    public void handleMenuVacinaClick(ActionEvent event) {
        alert();
    }

    private void alert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALerta");
        alert.setHeaderText("Menu ");
        alert.setContentText("Texto principal");
        alert.show();
    }
}
