import java.util.Scanner;

public class Exercici2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        
        if (idade >= 16) {
            System.out.println("Pode votar");
        } else {
            System.out.println("Não pode votar");
        }
        
        scanner.close();
    }
}