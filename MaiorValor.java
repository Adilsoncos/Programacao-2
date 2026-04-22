import java.util.Scanner;

public class MaiorValor {

    // Método que retorna o maior valor do array
    public static int encontrarMaior(int[] vetor) {
        int maior = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        return maior;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quantidade de elementos
        System.out.print("Quantos números você deseja digitar? ");
        int n = scanner.nextInt();

        int[] vetor = new int[n];

        // Entrada dos valores
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }

        // Cálculo do maior
        int maior = encontrarMaior(vetor);

        // Saída
        System.out.println("Maior valor: " + maior);

        scanner.close();
    }
}