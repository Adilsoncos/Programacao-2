import java.util.Scanner;

public class PostoCombustivel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tipo de combustível (A - Álcool / G - Gasolina): ");
        char tipo = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite a quantidade de litros: ");
        double litros = scanner.nextDouble();

        double precoLitro = 0;
        double desconto = 0;

        if (tipo == 'A') {
            precoLitro = 4.50;
            if (litros <= 20) {
                desconto = 0.03;
            } else {
                desconto = 0.05;
            }
        } else if (tipo == 'G') {
            precoLitro = 6.00;
            if (litros <= 20) {
                desconto = 0.04;
            } else {
                desconto = 0.06;
            }
        } else {
            System.out.println("Tipo de combustível inválido!");
            scanner.close();
            return;
        }

        double valorSemDesconto = litros * precoLitro;
        double valorDesconto = valorSemDesconto * desconto;
        double valorFinal = valorSemDesconto - valorDesconto;

        System.out.println("Valor a pagar: R$ " + valorFinal);

        scanner.close();
    }
}