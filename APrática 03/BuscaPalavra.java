import java.util.Scanner;

public class BuscaPalavra {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();
        
        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();
        
        // Busca da palavra na frase
        int posicao = frase.indexOf(palavra);
        
        if (posicao != -1) {
            System.out.println("A palavra foi encontrada na posição: " + posicao);
        } else {
            System.out.println("A palavra não foi encontrada (retorno = -1).");
        }
        
        sc.close();
    }
}