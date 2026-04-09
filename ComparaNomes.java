import java.util.*;


public class ComparaNomes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro nome: ");
        String nome1 = sc.nextLine();
        System.out.print("Digite o primeiro nome: ");
        String nome2 = sc.nextLine();
            if (nome1.equals(nome2)) {
                 System.out.print("Os nome são iguais.");
            }else {
                 System.out.print("Os nome são diferente.");
            }
            sc.close();
    }   

}