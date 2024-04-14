package Controller;

import java.io.IOException;

import util.Alertas;

import Database.CartaoDeVacinaDatabaseMock;
import Database.PacienteDatabaseMock;
import Database.VacinaDatabaseMock;
import Models.CartaoDeVacina;
import Models.Paciente;
import Models.Vacina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public class CartaoVacinaController {
    private static CartaoDeVacinaDatabaseMock cartaoDeVacinaDatabaseMock = new CartaoDeVacinaDatabaseMock();
    private static PacienteDatabaseMock pacienteDatabaseMock = new PacienteDatabaseMock();
    private static VacinaDatabaseMock vacinaDatabaseMock = new VacinaDatabaseMock();

    @FXML
    public GridPane showItems;

    @FXML
    public TextField pesquisa;

     //valores imprimir
     @FXML
     public Label cpfLabel;
     @FXML
     public Label nomeLabel;
     @FXML
     public Label vacinaLabel;
 
     // Valores para salvar
     @FXML
     public TextField cpfText;
     @FXML
     public Text nomeLabelCriar;
     @FXML
     public ComboBox<String> comboBox;
     public String selectedOption;
     @FXML
     public Text loteText;
     @FXML
     public Text descricaoText;

     public Vacina vacina;
    
    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Vacina vacina : vacinaDatabaseMock.searchAllVacinas()) {
            items.add(vacina.getNome());
        }
       
        if (comboBox != null) {
            comboBox.setItems(items);

            comboBox.setOnAction(e -> {
                selectedOption = comboBox.getValue();

                vacina = vacinaDatabaseMock.searchVacina(selectedOption);
                loteText.setText(vacina.getLote());
                descricaoText.setText(vacina.getDescricao());
    
            });
        }

    }
    
    public void pesquisarItem(ActionEvent event) throws IOException {
        try {
            CartaoDeVacina cartaoDeVacina = cartaoDeVacinaDatabaseMock.searchCartaoDeVacina(pesquisa.getText());

            if(cartaoDeVacina == null)
                throw new Exception("usuário");

            Paciente paciente = pacienteDatabaseMock.searchPacienteCpf(pesquisa.getText());

            List<String> cartaoDeVacinas = cartaoDeVacina.getVacinasTomadas();

            cpfLabel.setText(cartaoDeVacina.getCpfPaciente());
            nomeLabel.setText(paciente.getNome());

            showItems.setPrefHeight(cartaoDeVacinas.size() * 35);

            if(cartaoDeVacinas.get(0) != null){
                vacinaLabel.setText(cartaoDeVacinas.get(0));

                for (int i = 1; i < cartaoDeVacinas.size(); i++) {
                    Label label = new Label(cartaoDeVacinas.get(i));
                    label.setPrefHeight(30.0);
                    label.setPrefWidth(471.0);
                    label.setTextFill(Color.valueOf("#757575"));
                    label.setFont(Font.font("Cambria"));
                    label.setFont(Font.font(17.0));
                    GridPane.setRowIndex(label, i + 3);

                    showItems.add(label, 1, i + 3);         
                
                }
            }

        } catch (Exception e) {
            Alertas.alertError(e.getMessage());
        }
    }

    public void pesquisarPaciente(){
        try {
            CartaoDeVacina cartaoDeVacina = cartaoDeVacinaDatabaseMock.searchCartaoDeVacina(cpfText.getText());

            if(cartaoDeVacina == null)
                throw new Exception("usuário");

            Paciente paciente = pacienteDatabaseMock.searchPacienteCpf(cpfText.getText());

            nomeLabelCriar.setText(paciente.getNome());
        } catch (Exception e) {
            Alertas.alertError(e.getMessage());
        }
    }

    public void salvarCartao(ActionEvent event){
        try {
            if (cpfText.getText().isEmpty() || selectedOption == null || selectedOption.isEmpty()) 
                throw new Exception("CPF ou Vacina");
                

            Boolean result = cartaoDeVacinaDatabaseMock.adicionarVacinaAoCartao(cpfText.getText(), vacina.getNome());

            Alertas.alert(cartaoDeVacinaDatabaseMock.searchCartaoDeVacina(cpfText.getText()), vacinaDatabaseMock.searchVacina(vacina.getNome()));
        } catch (Exception e) {
            Alertas.alertErrorNotInformated(e.getMessage());
        }
    }

    
}
