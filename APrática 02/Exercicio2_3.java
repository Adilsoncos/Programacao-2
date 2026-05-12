import java.util.Scanner;

public class Exercicio2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Valor unitário (R$): ");
        double valorUnitario = scanner.nextDouble();
        
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        
        double total = valorUnitario * quantidade;
        System.out.printf("Total sem desconto: R$ %.2f%n", total);
        
        if (total > 100.00) {
            double desconto = total * 0.08;
            double valorFinal = total - desconto;
            System.out.printf("Desconto (8%%): R$ %.2f%n", desconto);
            System.out.printf("Valor final: R$ %.2f%n", valorFinal);
        } else {
            System.out.println("Sem desconto.");
        }
        
        scanner.close();
    }
}