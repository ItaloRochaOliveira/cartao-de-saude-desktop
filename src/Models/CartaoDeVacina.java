package Models;
import java.util.ArrayList;
import java.util.List;

public class CartaoDeVacina {
    private int id;
    private String cpfPaciente;
    private List<String> vacinasTomadas;

    public CartaoDeVacina(int id, String cpfPaciente) {
        this.id = id;
        this.cpfPaciente = cpfPaciente;
        this.vacinasTomadas = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
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

}