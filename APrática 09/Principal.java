import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        int op;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar Gerente");
            System.out.println("2 - Adicionar Atendente");
            System.out.println("3 - Listar Funcionários");
            System.out.println("4 - Mostrar Salário por CPF");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Nome: ");
                    String nomeG = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpfG = sc.nextLine();

                    System.out.print("Salário: ");
                    double salG = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Data de nascimento: ");
                    String dataG = sc.nextLine();

                    funcionarios.add(
                        new Gerente(nomeG, cpfG, salG, dataG)
                    );

                    System.out.println("Gerente cadastrado!");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeA = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpfA = sc.nextLine();

                    System.out.print("Salário: ");
                    double salA = sc.nextDouble();

                    System.out.print("Comissão: ");
                    double comissao = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Data de nascimento: ");
                    String dataA = sc.nextLine();

                    funcionarios.add(
                        new Atendente(nomeA, cpfA, salA, dataA, comissao)
                    );

                    System.out.println("Atendente cadastrado!");
                    break;

                case 3:
                    System.out.println("\n=== FUNCIONÁRIOS ===");
                    for (Funcionario f : funcionarios) {
                        System.out.println(f);
                    }
                    break;

                case 4:
                    System.out.print("CPF: ");
                    String cpfBusca = sc.nextLine();

                    boolean encontrado = false;

                    for (Funcionario f : funcionarios) {
                        if (f.getCpf().equals(cpfBusca)) {
                            System.out.printf(
                                "Salário: R$ %.2f%n",
                                f.getSalario()
                            );
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != 5);

        sc.close();
    }
}