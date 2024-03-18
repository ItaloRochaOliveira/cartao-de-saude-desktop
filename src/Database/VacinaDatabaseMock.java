package Database;

import java.util.ArrayList;
import java.util.Arrays;

import Models.Vacina;

public class VacinaDatabaseMock {
    private static ArrayList<Vacina> vacinas = new ArrayList<>(Arrays.asList(
        new Vacina("1", "COVID-19 (Pfizer-BioNTech)", "Vacina contra a COVID-19 desenvolvida pela Pfizer em parceria com a BioNTech.", "ABC123", "Pfizer"),
        new Vacina("2", "COVID-19 (Moderna)", "Vacina contra a COVID-19 desenvolvida pela Moderna.", "XYZ456", "Moderna"),
        new Vacina("3", "COVID-19 (AstraZeneca/Oxford)", "Vacina contra a COVID-19 desenvolvida pela Universidade de Oxford em parceria com a AstraZeneca.", "DEF789", "AstraZeneca"),
        new Vacina("4", "COVID-19 (Johnson & Johnson)", "Vacina contra a COVID-19 desenvolvida pela Johnson & Johnson.", "GHI101", "Johnson & Johnson"),
        new Vacina("5", "Gripe (Influenza)", "Vacina contra o vírus da gripe.", "JKL202", "Vários fabricantes"),
        new Vacina("6", "Hepatite B", "Vacina contra o vírus da hepatite B.", "MNO303", "Vários fabricantes"),
        new Vacina("7", "Tríplice Viral (Sarampo, Caxumba, Rubéola)", "Vacina combinada contra sarampo, caxumba e rubéola.", "PQR404", "Vários fabricantes"),
        new Vacina("8", "Tetra Viral (Sarampo, Caxumba, Rubéola, Varicela)", "Vacina combinada contra sarampo, caxumba, rubéola e varicela.", "STU505", "Vários fabricantes"),
        new Vacina("9", "DTP (Difteria, Tétano, Coqueluche)", "Vacina combinada contra difteria, tétano e coqueluche.", "VWX606", "Vários fabricantes"),
        new Vacina("10", "Hepatite A", "Vacina contra o vírus da hepatite A.", "YZA707", "Vários fabricantes"),
        new Vacina("11", "Pneumocócica", "Vacina contra bactérias pneumocócicas.", "BCD808", "Vários fabricantes"),
        new Vacina("12", "Rotavírus", "Vacina contra o rotavírus.", "EFG909", "Vários fabricantes"),
        new Vacina("13", "HPV (Papilomavírus Humano)", "Vacina contra o vírus do papiloma humano.", "HIJ010", "Vários fabricantes")));

    public String searchAllVacinas(){
        return vacinas.toString();
    }

    public ArrayList<Vacina> searchAllVacinasFor(){
        return vacinas;
    }

    public Vacina searchVacina(String vacinaForSeach){
        for(Vacina vacina : vacinas){
            if(vacina.getNome().toLowerCase().contains(vacinaForSeach)){
                return vacina;
            }
        }
       
        return null;
    }
    

    public boolean addNewVacina(String id, String nome, String descricao, String lote, String fabricante){
        Vacina vacina = new Vacina(id, nome, descricao, lote, fabricante);

        vacinas.add(vacina);

        return vacina.getNome().length() != 0;
    }
}
