import java.util.Scanner;

public class Exercicio2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Taxa de serviço
        System.out.print("Porcentagem da taxa de serviço: ");
        double taxa = scanner.nextDouble();
        
        // 2. Produto 1
        System.out.print("Código do produto 1: ");
        int cod1 = scanner.nextInt();
        System.out.print("Valor unitário produto 1 (R$): ");
        double v1 = scanner.nextDouble();
        System.out.print("Quantidade produto 1: ");
        int q1 = scanner.nextInt();
        
        // 3. Produto 2
        System.out.print("Código do produto 2: ");
        int cod2 = scanner.nextInt();
        System.out.print("Valor unitário produto 2 (R$): ");
        double v2 = scanner.nextDouble();
        System.out.print("Quantidade produto 2: ");
        int q2 = scanner.nextInt();
        
        // Cálculo
        double subtotal = (v1 * q1) + (v2 * q2);
        double total = subtotal * (taxa / 100.0 + 1.0);
        
        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        System.out.printf("Valor total com taxa (%.1f%%): R$ %.2f%n", taxa, total);
        
        scanner.close();
    }
}