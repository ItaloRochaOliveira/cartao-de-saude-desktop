package Database;

import java.util.ArrayList;
import java.util.Arrays;

import Models.CartaoDeVacina;

public class CartaoDeVacinaDatabaseMock {
    private static ArrayList<CartaoDeVacina> cartoesDeVacina = new ArrayList<>(Arrays.asList(
        new CartaoDeVacina("Lucas Assis"),
        new CartaoDeVacina("Luiz Porto"),
        new CartaoDeVacina("Felipe Ramos"),
        new CartaoDeVacina("Yuri Aragão"),
        new CartaoDeVacina("Louise Assunção"),
        new CartaoDeVacina("Danilo Freitas"),
        new CartaoDeVacina("Lavínia Souza"),
        new CartaoDeVacina("Heloise de Paula")));

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

    public CartaoDeVacina searchCartaoDeVacina(String nomePaciente) {
        for (CartaoDeVacina cartao : cartoesDeVacina) {
            if (cartao.getNomePaciente().equalsIgnoreCase(nomePaciente)) {
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

    public boolean adicionarVacinaAoCartao(String nomePaciente, String vacina) {
        CartaoDeVacina cartaoDeVacina = searchCartaoDeVacina(nomePaciente);
        if (cartaoDeVacina != null) {
            cartaoDeVacina.adicionarVacina(vacina);
            return true;
        }
        return false;
    }
}
