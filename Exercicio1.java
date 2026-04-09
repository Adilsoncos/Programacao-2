import java.util.Scanner;

public class Exercicio1 {

            public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();

            System.out.println("Digite seu sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.println("Nome completo: " + nome + " " + sobrenome);

            sc.close();
            }
}
