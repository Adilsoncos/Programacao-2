public class CaracteresString {
    public static void main(String[] args) {
        
        String palavra = "Computação";
        
        // Primeiro caractere (índice 0)
        char primeiro = palavra.charAt(0);
        
        // Terceiro caractere (índice 2)
        char terceiro = palavra.charAt(2);
        
        // Último caractere (tamanho - 1)
        char ultimo = palavra.charAt(palavra.length() - 1);
        
        System.out.println("Primeiro caractere: " + primeiro);
        System.out.println("Terceiro caractere: " + terceiro);
        System.out.println("Último caractere: " + ultimo);
    }
}