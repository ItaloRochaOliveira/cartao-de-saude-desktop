package Database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import Models.Paciente;

public class PacienteDatabaseMock {
    private static ArrayList<Paciente> pacientes = new ArrayList<>(Arrays.asList(
        new Paciente(1, "47872011239", "Lucas Assis", LocalDate.of(1989, 1, 19), "74491245", "35", "Rua dos Crisântemos", "Brasileiro", "6239013455", "Masculino", "Branco", "Solteiro"),
        new Paciente(2, "40999937103", "Luiz Porto", LocalDate.of(2005, 3, 17), "74705270", "19", "Rua Georgia", "Brasileiro", "6239761449", "Masculino", "Pardo", "Solteiro"),
        new Paciente(3, "81521404143", "Felipe Ramos", LocalDate.of(1962, 3, 23), "74477041", "62", "Rua A 5", "Brasileiro", "6226944765", "Masculino", "Negro", "Casado"),
        new Paciente(5, "94267504105", "Yuri Aragão", LocalDate.of(1975, 1, 24), "74583765", "49", "Rua JGO 10", "Brasileiro", "6237052133", "Masculino", "Branco", "Casado"),
        new Paciente(6, "10074561162", "Louise Assunção", LocalDate.of(1970, 1, 10), "74350420", "54", "Rua F 49", "Brasileira", "6227717621", "Feminino", "Parda", "Divorciada"),
        new Paciente(7, "17747403119", "Danilo Freitas", LocalDate.of(1955, 1, 4), "74885515", "69", "Rua A 7", "Brasileiro", "6239991712", "Masculino", "Negro", "Divorciado"),
        new Paciente(8, "27017650131", "Lavínia Souza", LocalDate.of(1988, 3, 11), "74484400", "36", "Rua GV 1", "Brasileira", "6229163908", "Feminino", "Branca", "Solteira"),
        new Paciente(10, "09672791194", "Heloise de Paula", LocalDate.of(1946, 1, 2), "74491460", "78", "Rua Boa Ventura", "Brasileira", "6225581876", "Feminino", "Parda", "Viúva")));


    public ArrayList<Paciente> searchAllPacientes(){
        return pacientes;
    }

    public Paciente searchPaciente(String pacienteForSeach){
        for(Paciente paciente : pacientes){
            if(paciente.getNome().toLowerCase().contains(pacienteForSeach)){
                return paciente;
            }
        }
       
        return null;
    }
    

    public boolean addNewPaciente(String cpf, String nome, LocalDate dataNascimento, String cep, String idade, String nacionalidade, String sexoBiologico){
        Paciente paciente = new Paciente(newId() , cpf, nome, dataNascimento, cep,nacionalidade, sexoBiologico);

        pacientes.add(paciente);

        return paciente.getNome().length() != 0;
    }

    private int newId(){
        return pacientes.get(pacientes.size() - 1).getId() + 1;
    }
}
