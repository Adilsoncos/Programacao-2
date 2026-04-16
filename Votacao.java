import java.util.Scanner;

public class Votacao {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();

        if (idade >= 18 && idade <= 70) {
            System.out.println("Voto obrigatório.");
        } else if ((idade >= 16 && idade < 18) || idade > 70) {
            System.out.println("Voto facultativo.");
        } else {
            System.out.println("Não pode votar.");
        }

        sc.close();
    }
}