import java.util.Scanner;

public class QuantidadeCaracteres{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();
        System.out.print("A palavra possui " + palavra.length() + " casacaracteres.");
        sc.close();
    }   

}