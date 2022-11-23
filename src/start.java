import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class start {

    static Scanner linhas;

    public static void main(String[] args) {

        String[] testes = new String[4];
        String arquivoTeste;
        testes[0] = "TATATAAGAAAAAAG";
        testes[1] = "AGACTCTG";
        testes[2] = "GAGAGCGG";
        testes[3] = "TCCTCCCAC";

        System.out.println("======================");
        System.out.println("Testando ocorrencias");
        System.out.println("======================");
        System.out.println();

        arquivoTeste = importArquivo();

        Processamento processa = new Processamento();
        for (int i = 0; i < testes.length; i++) {

            System.out.println(" A palavra testada é: " + testes[i]);
            System.out.println("-------------------");

            System.out.println();
            System.out.println("    Força Bruta    ");
            System.out.println("-------------------");
            System.out.println();
            processa.forcaBruta(arquivoTeste, testes[i]);

            System.out.println();

            System.out.println("    KMP    ");
            System.out.println("-------------------");
            System.out.println();
            processa.KMP(arquivoTeste, testes[i]);

        }

    }

    // importar arquivo para texte
    static String importArquivo() {
        String arquivoSalvo = "";

        File file = new File("src/testes.txt");
        try {
            linhas = new Scanner(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while (linhas.hasNextLine()) {
            arquivoSalvo += linhas.nextLine();
        }

        return arquivoSalvo;
    }

}