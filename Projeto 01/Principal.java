// Versão 1.6

import java.time.LocalDate;
import java.util.Scanner;
/* import java.time.format.DateTimeFormatter;

public class FormatarData {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now(); 
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatador);
        System.out.println(dataFormatada); 
    }
}
*/

public class Principal {
    static Scanner sc = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();
    static Usuario usuario = new Usuario("admin", "123");
    public static void main(String[] args) {
        autenticar();
        int opcao;

        do {
            menu();
            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao) {
                case 1:cadastrar();
                    break;
                case 2:listar();
                    break;
                case 3:consultar();
                    break;
                case 4:editar();
                    break;
                case 5:remover();
                    break;
                case 6:emprestar();
                    break;
                case 7:devolver();
                    break;
                case 8:listarEmprestimos();
                    break;
                case 9:escutarMusica();
                    break;
                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }
        
        }while(opcao != 0);
    }
    // Métodos
    static void autenticar() {
        while(true) {
            System.out.println("\n================================");
            System.out.println("       BIBLIOTECA MUSICAL");
            System.out.println("================================");
            System.out.print("Login: ");
            String login =sc.nextLine();
            System.out.print("Senha: ");
            String senha =sc.nextLine();
           
            if(usuario.autenticar(login,senha)) {
                System.out.println("\nAcesso autorizado!");
                return;
            }

            System.out.println("\nLogin inválido.");
        }
    }

    static void menu() {
        System.out.println("\n================================");
        System.out.println("          MENU PRINCIPAL");
        System.out.println("================================");
        System.out.println("     1 - Cadastrar Música");
        System.out.println("     2 - Listar Músicas");
        System.out.println("     3 - Consultar Música");
        System.out.println("     4 - Editar Música");
        System.out.println("     5 - Remover Música");
        System.out.println("     6 - Registrar Empréstimo");
        System.out.println("     7 - Registrar Devolução");
        System.out.println("     8 - Listar Empréstimos");
        System.out.println("     9 - Escutar Música");
        System.out.println("     0 - Sair");
        System.out.print("     \nOpção: ");
    }

    static void cadastrar() {

        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Álbum: ");
        String album = sc.nextLine();
        System.out.print("Cantor: ");
        String cantor = sc.nextLine();
        System.out.print("Banda: ");
        String banda = sc.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(sc.nextLine());
        System.out.print("Link Streaming: ");
        String link = sc.nextLine();
        Musica m = new Musica(biblioteca.gerarId(), titulo, album, cantor,banda, ano, link);
            biblioteca.adicionar(m);
        System.out.println("\nMúsica cadastrada.");
    }

    static void listar() {
        System.out.println("\nID  TÍTULO               ÁLBUM                 CANTOR               BANDA                  ANO     EMP.");

        for(Musica m : biblioteca.getMusicas()) {
            System.out.println(m);
        }
    }

    static void consultar() {
                System.out.print("Cantor: ");
        String cantor = sc.nextLine();
        boolean encontrou = false;
        System.out.println("\nRESULTADO DA CONSULTA");
                System.out.println( "ID  TÍTULO               ÁLBUM                  CANTOR               BANDA                  ANO     EMP.");

        for(Musica m : biblioteca.getMusicas()) {
            if(m.getCantor() .equalsIgnoreCase(cantor)) {
                System.out.println(m);
                encontrou = true;
            }
        }

        if(!encontrou) {
            System.out.println("\nNenhuma música encontrada para o cantor: "+ cantor);
        }
    }
    static void editar() {
        // ID ou id é a identificação ou registro da música.
        System.out.print("ID da música: "); 
        int id = Integer.parseInt(sc.nextLine());
        Musica m = biblioteca.buscar(id);

        if(m == null) {
            System.out.println("\nNão encontrada.");
            return;
        }
        System.out.print("Novo título: ");
        String titulo = sc.nextLine();
        System.out.print("Novo álbum: ");
        String album = sc.nextLine();
        System.out.print("Novo cantor: ");
        String cantor = sc.nextLine();
        System.out.print("Nova banda: ");
        String banda = sc.nextLine();
        System.out.print("Novo ano: ");
        int ano = Integer.parseInt(sc.nextLine());
        m.editar(titulo, album, cantor, banda, ano);
        System.out.println("\nAtualizado.");
    }

    static void remover() {
        System.out.print("ID da música: ");
        int id = Integer.parseInt(sc.nextLine());
        biblioteca.remover(id);
        System.out.println("Removida.");
    }

    static void emprestar() {
        System.out.print("ID da música: ");
        int id = Integer.parseInt(sc.nextLine());
        Musica m = biblioteca.buscar(id);

        if(m == null) {
            System.out.println("Música não encontrada.");
            return;
        }

        if(m.isEmprestada()) {
            System.out.println("Música já emprestada.");
            return;
        }
        System.out.print("Pessoa: ");
        String pessoa = sc.nextLine();
        System.out.print("Data prevista de devolução (AAAA-MM-DD): ");
        LocalDate dataPrevista = LocalDate.parse(sc.nextLine());
        biblioteca.emprestar(m, pessoa, dataPrevista);
        System.out.println("\nEmpréstimo realizado com sucesso!");
    }

    static void devolver() {
        listarEmprestimos();
        System.out.print("Número do empréstimo: ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("Data da devolução (AAAA-MM-DD): ");
        LocalDate data = LocalDate.parse(sc.nextLine());

        biblioteca
            .getEmprestimos()
            .get(pos - 1)
            .devolver(data);

        System.out.println("Devolução registrada.");
    }
    
    static void listarEmprestimos() {
        System.out.println(
            "\nTÍTULO               PESSOA          EMPRÉSTIMO   PREVISTA     DEVOLUÇÃO");

        for(Emprestimo e : biblioteca.getEmprestimos()) {
            System.out.println(e);
        }
    }
    static void escutarMusica() {
        System.out.print("ID da música: ");
        int id = Integer.parseInt(sc.nextLine());
        Musica musica = biblioteca.buscar(id);

        if(musica == null) {
            System.out.println("Música não encontrada.");
            return;
        }
        PlayerMusica.tocar(musica);    
    }
}