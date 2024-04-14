package Database;

import java.util.ArrayList;

import Models.CartaoDeVacina;
import Models.Paciente;
import java.util.Arrays;

public class CartaoDeVacinaDatabaseMock {
    private static PacienteDatabaseMock pacienteDatabaseMock = new PacienteDatabaseMock();

    private static ArrayList<CartaoDeVacina> cartoesDeVacina = new ArrayList<>(Arrays.asList(
        new CartaoDeVacina(1, "47872011239"),
        new CartaoDeVacina(2, "40999937103"),
        new CartaoDeVacina(3, "81521404143"),
        new CartaoDeVacina(4, "94267504105"),
        new CartaoDeVacina(5, "10074561162"),
        new CartaoDeVacina(6, "17747403119"),
        new CartaoDeVacina(7, "27017650131"),
        new CartaoDeVacina(8, "09672791194")));
   

    static {
        // Adicionando vacinas aos cartões de vacina
        cartoesDeVacina.get(0).adicionarVacina("COVID-19 (Pfizer-BioNTech)");
        cartoesDeVacina.get(1).adicionarVacina("COVID-19 (Moderna)");
        cartoesDeVacina.get(2).adicionarVacina("COVID-19 (AstraZeneca/Oxford)");
        cartoesDeVacina.get(3).adicionarVacina("COVID-19 (Johnson & Johnson)");
        cartoesDeVacina.get(4).adicionarVacina("Gripe (Influenza)");
        cartoesDeVacina.get(5).adicionarVacina("Hepatite B");
        cartoesDeVacina.get(6).adicionarVacina("Tríplice Viral (Sarampo, Caxumba, Rubéola)");
        cartoesDeVacina.get(7).adicionarVacina("Tetra Viral (Sarampo, Caxumba, Rubéola, Varicela)");
        cartoesDeVacina.get(7).adicionarVacina("DTP (Difteria, Tétano, Coqueluche)");
        cartoesDeVacina.get(7).adicionarVacina("Hepatite A");
        cartoesDeVacina.get(7).adicionarVacina("Pneumocócica");
        cartoesDeVacina.get(7).adicionarVacina("Rotavírus");
        cartoesDeVacina.get(7).adicionarVacina("HPV (Papilomavírus Humano)");
    }

    public ArrayList<CartaoDeVacina> searchAllCartoesDeVacina() {
        return cartoesDeVacina;
    }

    public CartaoDeVacina searchCartaoDeVacina(String cpfPaciente) {
        for (CartaoDeVacina cartao : cartoesDeVacina) {
            if (cartao.getCpfPaciente().equalsIgnoreCase(cpfPaciente)) {
                return cartao;
            }
        }
        return null;
    }

    public boolean addNewCartaoDeVacina(CartaoDeVacina cartaoDeVacina) {
        if (!cartoesDeVacina.contains(cartaoDeVacina)) {
            cartoesDeVacina.add(cartaoDeVacina);
            return true;
        }
        return false;
    }

    public boolean adicionarVacinaAoCartao(String cpfPaciente, String vacina) {
        

        CartaoDeVacina cartaoDeVacinaExist = searchCartaoDeVacina(cpfPaciente);

        if (cartaoDeVacinaExist != null) {
            cartaoDeVacinaExist.adicionarVacina(vacina);
            return true;
        } else if (cartaoDeVacinaExist == null) {
            Paciente paciente = pacienteDatabaseMock.searchPacienteCpf(cpfPaciente);

            if (paciente == null) {
                CartaoDeVacina cartaoDeVacina = new CartaoDeVacina(newId(), cpfPaciente);

                cartaoDeVacina.adicionarVacina(vacina);

                cartoesDeVacina.add(cartaoDeVacina);
            }
        }

        return false;
    }

    // public boolean adicionarVacinaAoCartaoComCpf(String cpf, String vacina) {
        

    //     return false;
    // }

    private int newId(){
        return cartoesDeVacina.get(cartoesDeVacina.size() - 1).getId() + 1;
    }
}
