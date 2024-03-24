package Models;
import java.util.ArrayList;
import java.util.List;

public class CartaoDeVacina {
    private String nomePaciente;
    private List<String> vacinasTomadas;

    public CartaoDeVacina(String nomePaciente) {
        this.nomePaciente = nomePaciente;
        this.vacinasTomadas = new ArrayList<>();
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public List<String> getVacinasTomadas() {
        return vacinasTomadas;
    }

    public void setVacinasTomadas(List<String> vacinasTomadas) {
        this.vacinasTomadas = vacinasTomadas;
    }

    public void adicionarVacina(String vacina) {
        vacinasTomadas.add(vacina);
    }

    public void imprimirCartao() {
        System.out.println("Cartão de Vacina - " + nomePaciente);
        System.out.println("Vacinas Tomadas:");
        for (String vacina : vacinasTomadas) {
            System.out.println("- " + vacina);
        }
    }

    public static void main(String[] args) {
        CartaoDeVacina cartao = new CartaoDeVacina("Fulano de Tal");
        cartao.adicionarVacina("Vacina 1");
        cartao.adicionarVacina("Vacina 2");
        cartao.imprimirCartao();
    }
}

