package Controller;

import java.io.IOException;

import Database.CartaoDeVacinaDatabaseMock;
import Database.PacienteDatabaseMock;
import Models.CartaoDeVacina;
import Models.Paciente;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class CartaoVacinaController {
    private static CartaoDeVacinaDatabaseMock cartaoDeVacinaDatabaseMock = new CartaoDeVacinaDatabaseMock();
    private static PacienteDatabaseMock pacienteDatabaseMock = new PacienteDatabaseMock();

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
    //  @FXML
    //  public TextField cpfInput;
    //  @FXML
    //  public TextField nomeInput;
    //  @FXML
    //  public DatePicker dataNascimentoInput;
    //  @FXML
    //  public TextField cepInput;
     // @FXML
     // public TextField idadeInput;
     // @FXML
     // public TextField enderecoInput;
    //  @FXML
    //  public TextField nacionalidadeInput;
     // @FXML
     // public TextField telefoneInput;
    //  @FXML
    //  public TextField sexoBiologicoInput;
     // @FXML
     // public TextField etniaInput;
     // @FXML
     // public TextField estadoCivilInput;
    //  @FXML
    //  private ComboBox<String> comboBox;
    //  private String selectedOption;

    @FXML
    public void initialize() {
        // if(showItems != null){
        //     adicionarLinhasDinamicamente();
        // }

        // ObservableList<String> items = FXCollections.observableArrayList(
        //     "Masculino",
        //     "Feminino",
        //     "Prefiro não informar"
        // );
       
        // if (comboBox != null) {
        //     comboBox.setItems(items);

        //     comboBox.setOnAction(e -> {
        //         selectedOption = comboBox.getValue();
        //     });
        // }

    }
    
    public void pesquisarItem(ActionEvent event) throws IOException {
        CartaoDeVacina cartaoDeVacina = cartaoDeVacinaDatabaseMock.searchCartaoDeVacina(pesquisa.getText());
        Paciente paciente = pacienteDatabaseMock.searchPacienteCpf(pesquisa.getText());

        List<String> cartaoDeVacinas = cartaoDeVacina.getVacinasTomadas();

        cpfLabel.setText(cartaoDeVacina.getCpfPaciente());
        nomeLabel.setText(paciente.getNome());

        showItems.prefHeight(cartaoDeVacinas.size() * 45.66);

        System.out.println(showItems.getChildren());

        if(cartaoDeVacinas.get(0) != null){
            vacinaLabel.setText(cartaoDeVacinas.get(0));

            for (int i = 1; i < cartaoDeVacinas.size(); i++) {
                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setMinHeight(10.0);
                rowConstraints.setPrefHeight(30.0);
                rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

                showItems.getRowConstraints().add(rowConstraints);

                Label label = new Label(cartaoDeVacinas.get(i));
                label.setPrefHeight(34.0);
                label.setPrefWidth(471.0);
                label.setStyle("-fx-border-style: solid;");
                GridPane.setRowIndex(label, i);

                showItems.add(label, 1, i + 3);         
               
            }
        }



    }

    public void salvarCartao(ActionEvent event){
        // Boolean result = vacinasdatabaseMock.addNewVacina(nomeInput.getText(), descricaoInput.getText(), loteInput.getText(), fabricanteInput.getText());

        // if (result) {
        //     alert(vacinasdatabaseMock.searchVacina(nomeInput.getText()));
        //     adicionarLinhasDinamicamente();
        // } else{
        //     System.out.println("Erro");
        // }
    }

    // private void alert(Vacina vacina){
    //     Alert alert = new Alert(Alert.AlertType.INFORMATION);
    //     alert.setTitle("Vacina criada");
    //     alert.setHeaderText("Nova vacina " + vacina.getNome() + " criada");
    //     alert.setContentText(vacina.getDescricao());
    //     alert.show();
    // }
}
