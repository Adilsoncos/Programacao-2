import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 10 notas de 10 a 90:");

        int quantidade = 10;
        int[] f = new int[91]; // índice = nota

        // Entrada e contagem
        for (int i = 0; i < quantidade; i++) {
            int x = sc.nextInt();
            f[x]++;
        }

        int r = 0;           // nota resultado
        int maiorFreq = 0;   // maior frequência

        // Descobrir a mais frequente
        for (int i = 10; i <= 90; i++) {
            if (f[i] > maiorFreq || (f[i] == maiorFreq && i > r)) {
                maiorFreq = f[i];
                r = i;                
            }

        }

        System.out.println();
        System.out.println("A nota mais frequente (e maior em caso de empate) é: " + r);

         sc.close();
    }
}