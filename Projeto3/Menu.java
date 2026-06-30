import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private static Estoque estoque = new Estoque();

    public static void main(String[] args) {

        int opcao;

        do {

            mostrarMenu();

            opcao = lerInteiro();

            switch (opcao) {

                case 1:

                    cadastrarProduto();
                    break;

                case 2:

                    estoque.listarProdutos();
                    break;

                case 3:

                    estoque.adicionarExemplos();

                    System.out.println(
                            "\nProdutos adicionados com sucesso!");
                    break;

                case 0:

                    System.out.println(
                            "\nPrograma encerrado.");
                    break;

                default:

                    System.out.println(
                            "\nOpção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void mostrarMenu() {

        System.out.println("\n==========================");
        System.out.println(" SISTEMA DE ESTOQUE");
        System.out.println("==========================");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Inserir Exemplos");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static int lerInteiro() {

        while (true) {

            try {

                int valor = sc.nextInt();
                sc.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.print(
                        "Digite um número inteiro: ");
                sc.nextLine();
            }
        }
    }

    private static void cadastrarProduto() {

        try {

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = lerInteiro();

            System.out.print("Validade: ");
            String validade = sc.nextLine();

            Produto produto =
                    new ProdutoPerecivel(
                            nome,
                            quantidade,
                            validade);

            estoque.adicionarProduto(produto);

            System.out.println(
                    "\nProduto cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "\nErro: " + e.getMessage());
        }
    }
}