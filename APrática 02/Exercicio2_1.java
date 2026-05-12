
import java.util.Scanner;

public class Exercicio2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        
        System.out.println("Dobro: " + (numero * 2));
        System.out.println("Triplo: " + (numero * 3));
        
        scanner.close();
    }
}