package Models;

import java.time.LocalDate;

public class Paciente {
    private int id;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String idade;
    private String endereco;
    private String nacionalidade;
    private String telefone;
    private String sexoBiologico;
    private String etnia;
    private String estadoCivil;

    public Paciente(int id, String cpf, String nome, LocalDate dataNascimento, String cep, String idade, String endereco, String nacionalidade, String telefone, String sexoBiologico, String etnia, String estadoCivil) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.idade = idade;
        this.endereco = endereco;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.sexoBiologico = sexoBiologico;
        this.etnia = etnia;
        this.estadoCivil = estadoCivil;
    }
 
    public Paciente(int id, String cpf, String nome, LocalDate dataNascimento, String cep, String nacionalidade, String sexoBiologico) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.idade = null;
        this.endereco = null;
        this.nacionalidade = nacionalidade;
        this.telefone = null;
        this.sexoBiologico = sexoBiologico;
        this.etnia = null;
        this.estadoCivil = null;
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }


    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public String getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSexoBiologico() {
        return sexoBiologico;
    }

    public String getEtnia() {
        return etnia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n { id= " + id + ", \n cpf=" + cpf + ", \n nome=" + nome + ", \n dataNascimento=" + dataNascimento + ", \n cep="
        + cep + ", \n idade=" + idade + ", \n endereco=" + endereco + ", \n nacionalidade=" + nacionalidade + ", \n telefone=" 
        + telefone + ", \n sexoBiologico=" + sexoBiologico + ", \n etnia=" + etnia + " }";
    }

}
