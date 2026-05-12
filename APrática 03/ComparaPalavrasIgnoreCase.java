import java.util.Scanner;

public class ComparaPalavrasIgnoreCase {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a primeira palavra: ");
        String palavra1 = sc.nextLine();
        System.out.print("Digite a segunda palavra: ");
        String palavra2 = sc.nextLine();
            if (palavra1.equalsIgnoreCase(palavra2)){
                 System.out.print("As palvras são IGUAIS.");
            }else {
                 System.out.print("As palavras são DIFERENTES.");
            }
            sc.close();
    }   

}