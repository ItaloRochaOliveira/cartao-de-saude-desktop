package util;

import Models.CartaoDeVacina;
import Models.Vacina;
import javafx.scene.control.Alert;

public class Alertas {
    public static void alert(CartaoDeVacina cartao, Vacina vacina){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cartão vinculado a pessoa");
        alert.setHeaderText("Pessoa com cpf:  " + cartao.getCpfPaciente() + " vinculada a vacina: " + vacina.getNome());
        alert.setContentText(cartao.getCpfPaciente());
        alert.show();
    }

    public static void alertError(String typeError){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Não foi possível cadastrar " + typeError);
        alert.setHeaderText(typeError + " não cadastrado ");
        alert.setContentText(typeError + " inexistente no banco de dados. Cadastre um novo usuário.");
        alert.show();
    }

    public static void alertErrorNotInformated(String typeError){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Não foi possível cadastrar " + typeError);
        alert.setHeaderText(typeError + " não informado");
        alert.setContentText("Verifique os dados e tente novamente");
        alert.show();
    }
}
