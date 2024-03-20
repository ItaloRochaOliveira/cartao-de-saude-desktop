import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Database.VacinaDatabaseMock;
import Models.Vacina;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    private static Scanner scanner = new Scanner(System.in);

    private static VacinaDatabaseMock vacinas = new VacinaDatabaseMock();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       try {
        System.out.println(getClass().getResource("/View/menu.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/View/menu.fxml"));

        Parent root = fxmlLoader.load();
    
        Scene tela = new Scene(root);

        primaryStage.setTitle("Cartão de Vacina para Todos");
        primaryStage.setScene(tela);
        primaryStage.show();
       } catch (Exception e) {
            e.printStackTrace();
       }
        
    }
}
