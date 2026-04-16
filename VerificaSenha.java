import java.util.Scanner;

public class VerificaSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String senhaCorreta = "1234";
        String senhaDigitada = "";

        // Enquanto a senha estiver incorreta
        while (!senhaDigitada.equals(senhaCorreta)) {
            System.out.print("Digite a senha: ");
            senhaDigitada = scanner.nextLine();

            if (!senhaDigitada.equals(senhaCorreta)) {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        }

        System.out.println("Acesso permitido!");

        scanner.close();
    }
}
