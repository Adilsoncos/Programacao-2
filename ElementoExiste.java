import java.util.Scanner;

public class ElementoExiste {

    // Método que verifica se o elemento existe no array
    public static boolean elementoExiste(String[] vetor, String busca) {
        if (vetor == null || busca == null) {
            return false;
        }

        for (String elemento : vetor) {
            if (elemento != null && elemento.equalsIgnoreCase(busca)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;

        // Validação da quantidade
        do {
            System.out.print("Quantas palavras você deseja digitar? ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida! Digite um número inteiro: ");
                scanner.next(); // descarta entrada inválida
            }
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("A quantidade deve ser maior que zero.");
            }
        } while (n <= 0);

        scanner.nextLine(); // limpar buffer

        String[] vetor = new String[n];

        // Entrada das palavras
        for (int i = 0; i < n; i++) {
            System.out.print("Digite a palavra " + (i + 1) + ": ");
            vetor[i] = scanner.nextLine().trim();
        }

        // Palavra de busca
        System.out.print("Digite a palavra que deseja buscar: ");
        String busca = scanner.nextLine().trim();

        // Verificação
        boolean existe = elementoExiste(vetor, busca);

        // Saída
        System.out.println(existe ? 
            "Resultado: a palavra EXISTE no array." : 
            "Resultado: a palavra NÃO existe no array."
        );

        scanner.close();
    }
}
