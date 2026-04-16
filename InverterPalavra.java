import java.util.Scanner;

public class InverterPalavra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        String invertida = "";

        // Percorre a palavra de trás para frente
        for (int i = palavra.length() - 1; i >= 0; i--) {
            invertida += palavra.charAt(i);
        }

        System.out.println("Palavra invertida: " + invertida);

        scanner.close();
    }
}
