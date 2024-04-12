package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Database.PacienteDatabaseMock;
import Models.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class PacienteController {
    private static PacienteDatabaseMock pacientesdatabaseMock = new PacienteDatabaseMock();
    @FXML
    public AnchorPane anchonPaneSearchOption;

    
    @FXML
    public GridPane showItems;

    @FXML
    public TextField pesquisa;

    //valores imprimir
    @FXML
    public Label cpfValue;
    @FXML
    public Label nomeValue;
    @FXML
    public Label dataNascimentoValue;
    @FXML
    public Label cepValue;
    @FXML
    public Label idadeValue;
    @FXML
    public Label enderecoValue;
    @FXML
    public Label nacionalidadeValue;
    @FXML
    public Label telefoneValue;
    @FXML
    public Label sexoBiologicoValue;
    @FXML
    public Label etniaValue;
    @FXML
    public Label estadoCivilValue;

    // Valores para salvar
    @FXML
    public Label cpfInput;
    @FXML
    public Label nomeInput;
    @FXML
    public Label dataNascimentoInput;
    @FXML
    public Label cepInput;
    @FXML
    public Label idadeInput;
    @FXML
    public Label enderecoInput;
    @FXML
    public Label nacionalidadeInput;
    @FXML
    public Label telefoneInput;
    @FXML
    public Label sexoBiologicoInput;
    @FXML
    public Label etniaInput;
    @FXML
    public Label estadoCivilInput;
    @FXML
    private ComboBox<String> comboBox;
    private String selectedOption;


    @FXML
    public void initialize() {
        if(showItems != null){
            adicionarLinhasDinamicamente();
        }

        ObservableList<String> items = FXCollections.observableArrayList(
            "Masculino",
            "Feminino",
            "Prefiro não informar"
        );
        comboBox.setItems(items);

        comboBox.setOnAction(e -> {
            selectedOption = comboBox.getValue();
        });

    }
    

    public void adicionarLinhasDinamicamente() {
        
            ArrayList<Paciente> pacientesArray = pacientesdatabaseMock.searchAllPacientes();
            // ColumnConstraints columnConstraints = new ColumnConstraints();
            // columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
            // columnConstraints.setMinWidth(10.0);
            // columnConstraints.setPrefWidth(100.0);
            // showItems.getColumnConstraints().add(columnConstraints);

            showItems.prefHeight((pacientesArray.size() + 1) * 34);

            for (int i = 0; i < pacientesArray.size(); i++){

                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setMaxHeight(76.0);
                rowConstraints.setMinHeight(10.0);
                rowConstraints.setPrefHeight(34.0);
                rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

                showItems.getRowConstraints().add(rowConstraints);

                Paciente item = (Paciente) pacientesArray.get(i);
                Label label = new Label(item.getNome());
                label.setPrefHeight(34.0);
                label.setPrefWidth(471.0);
                label.setStyle("-fx-border-style: solid;");
                GridPane.setRowIndex(label, i);
        
                showItems.getChildren().add(label);
            }
    }

    public void pesquisarItem(ActionEvent event) throws IOException{
        Paciente pacientePesquisada = pacientesdatabaseMock.searchPaciente(pesquisa.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/pacienteLayout/pacientePesquisaLayout.fxml"));
        AnchorPane layout = loader.load();
        
        anchonPaneSearchOption.getChildren().clear();
        anchonPaneSearchOption.getChildren().add(layout);

        PacienteController controller = loader.getController();
        controller.setPacienteValues(pacientePesquisada.getCpf(), pacientePesquisada.getNome(), pacientePesquisada.getDataNascimento(), pacientePesquisada.getCep(), pacientePesquisada.getIdade(), 
        pacientePesquisada.getEndereco(), pacientePesquisada.getNacionalidade(), pacientePesquisada.getTelefone(), pacientePesquisada.getSexoBiologico(), pacientePesquisada.getEtnia(), pacientePesquisada.getEstadoCivil());

    }

    public void setPacienteValues(String cpf, String nome, String dataNascimento, String cep, String idade, String endereco, String nacionalidade, String telefone, String sexoBiologico, String etnia, String estadoCivil) {
        cpfValue.setText(cpf);
        nomeValue.setText(nome);
        dataNascimentoValue.setText(dataNascimento);
        cepValue.setText(cep);
        idadeValue.setText("" + idade);
        enderecoValue.setText(endereco);
        nacionalidadeValue.setText(nacionalidade);
        telefoneValue.setText(telefone);
        sexoBiologicoValue.setText(sexoBiologico);
        etniaValue.setText(etnia);
        estadoCivilValue.setText(estadoCivil);
    }

    public void salvarVacina(ActionEvent event){
        System.out.println("entrou");
        Boolean result = pacientesdatabaseMock.addNewPaciente(cpfValue.getText(), nomeValue.getText(), dataNascimentoValue.getText(), cepValue.getText(), "01/01/2001", nacionalidadeValue.getText(), selectedOption);

        if (result) {
            alert(pacientesdatabaseMock.searchPaciente(nomeValue.getText()));
            adicionarLinhasDinamicamente();
        } else{
            System.out.println("Erro");
        }
    }

    private void alert(Paciente paciente){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vacina criada");
        alert.setHeaderText("Nova vacina " + paciente.getNome() + " criada");
        alert.setContentText("Paciente criado com o nome: " + paciente.getNome());
        alert.show();
    }
}
