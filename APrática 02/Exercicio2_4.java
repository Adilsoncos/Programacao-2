import java.util.Scanner;

public class Exercicio2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Preço por litro (R$): ");
        double precoLitro = scanner.nextDouble();
        
        System.out.print("Valor disponível (R$): ");
        double valor = scanner.nextDouble();
        
        double litros = valor / precoLitro;
        System.out.printf("Litros que pode comprar: %.2f Litros5,00%n", litros);
        
        scanner.close();
    }
}