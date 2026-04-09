import java.util.Scanner;
public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu Nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite sua Idade: ");
        String idade = sc.nextLine();

        System.out.println("Digite sua Altura: ");
        String altura = sc.nextLine();

        System.out.println("Meu nome é: " + nome + " \nMinha idade é : " + idade + " \nMinha altura é: " + altura +"");

        sc.close();
    }
}
