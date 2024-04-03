package Models;

public class Vacina {
    private int id;
    private String nome;
    private String descricao;
    private String lote;
    private String fabricante;

    public Vacina(int id, String nome, String descricao, String lote, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.lote = lote;
        this.fabricante = fabricante;
    }

    public Vacina(String nome, String descricao, String lote, String fabricante) {
        this.nome = nome;
        this.descricao = descricao;
        this.lote = lote;
        this.fabricante = fabricante;
    }

    public int getId() {
        return id;
    } 

    public String getNome() {
        return nome;
    } 

    public String getDescricao() {
        return descricao;
    }

    public String getLote() {
        return lote;
    }

    public String getFabricante() {
        return fabricante;
    }

    @Override
    public String toString() {
        return "\n { id= " + id + ", \n nome=" + nome + ", \n descricao=" + descricao + ", \n lote=" + lote + ", \n fabricante="
        + fabricante + " }";
    }

    

}