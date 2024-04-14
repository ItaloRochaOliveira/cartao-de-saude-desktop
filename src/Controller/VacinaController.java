package Controller;

import Models.Vacina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;
import java.util.ArrayList;

import Database.VacinaDatabaseMock;

public class VacinaController {
    private static VacinaDatabaseMock vacinasdatabaseMock = new VacinaDatabaseMock();

    @FXML
    public GridPane showItems;

    @FXML
    public TextField pesquisa;

    //Valores para imprimir
    @FXML
    public Label nomeValue;
    @FXML
    public Label descricaoValue;
    @FXML
    public Label loteValue;
    @FXML
    public Label fabricanteValue;

    // valores para receber dados
    @FXML
    public TextField nomeInput;
    @FXML
    public TextField descricaoInput;
    @FXML
    public TextField loteInput;
    @FXML
    public TextField fabricanteInput;

    @FXML
    public void initialize() {
        if(showItems != null){
            adicionarLinhasDinamicamente();
        }

    }
    

    public void adicionarLinhasDinamicamente() {
        
            ArrayList<Vacina> vacinasArray = vacinasdatabaseMock.searchAllVacinas();

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(javafx.scene.layout.Priority.ALWAYS);
            columnConstraints.setMinWidth(10.0);
            // columnConstraints.setPrefWidth((vacinasArray.size() + 1) * 34);
            showItems.getColumnConstraints().add(columnConstraints);

            showItems.prefHeight((vacinasArray.size() + 1) * 34);

            for (int i = 0; i < vacinasArray.size(); i++){

                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setMaxHeight(76.0);
                rowConstraints.setMinHeight(10.0);
                rowConstraints.setPrefHeight(34.0);
                rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

                showItems.getRowConstraints().add(rowConstraints);

                Vacina item = (Vacina) vacinasArray.get(i);
                Label label = new Label(item.getNome());
                label.setPrefHeight(34.0);
                label.setPrefWidth(471.0);
                label.setStyle("-fx-border-style: solid;");
                GridPane.setRowIndex(label, i);
        
                showItems.getChildren().add(label);
            }
    }

    public void pesquisarItem(ActionEvent event) throws IOException{
        Vacina vacinaPesquisada = vacinasdatabaseMock.searchVacina(pesquisa.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/vacinaLayout/vacinaPesquisaLayout.fxml"));
        AnchorPane layout = loader.load();
        
        showItems.getChildren().clear();
        showItems.getChildren().add(layout);

        VacinaController controller = loader.getController();
        controller.setVacinaValues(vacinaPesquisada.getNome(), vacinaPesquisada.getDescricao(), vacinaPesquisada.getLote(), vacinaPesquisada.getFabricante());

    }

    public void setVacinaValues(String nome, String descricao, String lote, String fabricante) {
        nomeValue.setText(nome);
        descricaoValue.setText(descricao);
        loteValue.setText(lote);
        fabricanteValue.setText(fabricante);
    }

    public void salvarVacina(ActionEvent event){
        Boolean result = vacinasdatabaseMock.addNewVacina(nomeInput.getText(), descricaoInput.getText(), loteInput.getText(), fabricanteInput.getText());

        if (result) {
            alert(vacinasdatabaseMock.searchVacina(nomeInput.getText()));
            adicionarLinhasDinamicamente();
        } else{
            System.out.println("Erro");
        }
    }

    private void alert(Vacina vacina){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vacina criada");
        alert.setHeaderText("Nova vacina " + vacina.getNome() + " criada");
        alert.setContentText(vacina.getDescricao());
        alert.show();
    }
}
