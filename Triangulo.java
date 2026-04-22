import java.util.Scanner;

public class Triangulo {

    public static double calcularHipotenusa(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do primeiro cateto (a): ");
        double a = scanner.nextDouble();

        System.out.print("Digite o valor do segundo cateto (b): ");
        double b = scanner.nextDouble();

        double hipotenusa = calcularHipotenusa(a, b);

        System.out.println("A hipotenusa é: " + hipotenusa);

        scanner.close();
    }
}