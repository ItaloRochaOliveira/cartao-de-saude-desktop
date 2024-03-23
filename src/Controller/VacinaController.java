package Controller;

import Models.Vacina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

import Database.VacinaDatabaseMock;

public class VacinaController {
    private static VacinaDatabaseMock vacinasdatabaseMock = new VacinaDatabaseMock();

    
    @FXML
    public GridPane showItems;

    @FXML
    public TextField pesquisa;

    @FXML
    public void initialize() {
        adicionarLinhasDinamicamente();
    }
    

    public void adicionarLinhasDinamicamente() {
        if(showItems != null){
            ArrayList vacinasArray = vacinasdatabaseMock.searchAllVacinas();
            // ColumnConstraints columnConstraints = new ColumnConstraints();
            // columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
            // columnConstraints.setMinWidth(10.0);
            // columnConstraints.setPrefWidth(100.0);
            // showItems.getColumnConstraints().add(columnConstraints);

            showItems.prefHeight((vacinasArray.size() + 1) * 34);

            for (Vacina vacina : vacinasdatabaseMock.searchAllVacinas()) {
                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setMaxHeight(76.0);
                rowConstraints.setMinHeight(10.0);
                rowConstraints.setPrefHeight(34.0);
                rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

                showItems.getRowConstraints().add(rowConstraints);
            }

            for (int i = 0; i < vacinasArray.size(); i++){
                Vacina item = (Vacina) vacinasArray.get(i);
                Label label = new Label(item.getNome());
                label.setPrefHeight(34.0);
                label.setPrefWidth(471.0);
                label.setStyle("-fx-border-style: solid;");
                GridPane.setRowIndex(label, i);
        
                showItems.getChildren().add(label);
            }
        }
    }

    public void pesquisarItem(ActionEvent event){
        System.out.println(pesquisa.getText());;
    }
}
