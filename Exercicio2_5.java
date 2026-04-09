import java.util.Scanner;

public class Exercicio2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Tipo de ingresso (I - Inteiro, M - Meia): ");
        char tipo = scanner.next().charAt(0);
        tipo = Character.toUpperCase(tipo); // Normaliza para maiúscula
        
        double valor;
        if (tipo == 'I') {
            valor = 40.00;
            System.out.println("Ingresso Inteiro");
        } else if (tipo == 'M') {
            valor = 20.00;
            System.out.println("Meia-Entrada");
        } else {
            System.out.println("Tipo inválido!");
            scanner.close();
            return;
        }
        
        System.out.printf("Valor a pagar: R$ %.2f%n", valor);
        
        scanner.close();
    }
}