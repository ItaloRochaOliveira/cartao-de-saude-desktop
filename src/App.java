import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Database.VacinaDatabaseMock;
import Models.Vacina;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static VacinaDatabaseMock vacinas = new VacinaDatabaseMock();

    public static void main(String[] args) throws Exception {
        //questão

        StringBuilder message = new StringBuilder();
        message.append("Pesquise dentre as vacinas a desejada \n");
        // JOptionPane.showMessageDialog(null, "Pesquise dentre as vacinas a desejada" + "\n");

        ArrayList<Vacina> vacinaList = vacinas.searchAllVacinasFor();
      

        for (int i = 0; i < vacinaList.size(); i++) {
            message.append( i + ": " + vacinaList.get(i).getNome() + "\n");
            // JOptionPane.showMessageDialog(null, vacinaList.get(i).getNome() + "\n");
        }

        String resposta = JOptionPane.showInputDialog(message.toString());

        JOptionPane.showMessageDialog(null, vacinas.searchVacina(resposta));
        

        // System.out.println(vacina.searchAllVacinas());

        // System.out.println("Informe qual vacina deseje pesquisar");

        // System.out.println(vacina.searchVacina(scanner.nextLine()));

        //resposta
        //JOptionPane.showMessageDialog(null, resposta);
    }
}
