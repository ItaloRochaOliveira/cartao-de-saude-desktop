import java.util.Scanner;

import Database.VacinaDatabaseMock;
import Models.Vacina;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static VacinaDatabaseMock vacina = new VacinaDatabaseMock();

    public static void main(String[] args) throws Exception {
        System.out.println("Pesquise dentre as vacinas a desejada");

        System.out.println(vacina.searchAllVacinas());

        System.out.println("Informe qual vacina deseje pesquisar");

        System.out.println(vacina.searchVacina(scanner.nextLine()));
    }
}
