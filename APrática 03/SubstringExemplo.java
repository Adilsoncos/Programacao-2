public class SubstringExemplo {
    public static void main(String[] args) {
        String texto = "Programação";
        
        String programa = texto.substring(0, 7);
        String acao = texto.substring(7);
        
        System.out.println("Programa: " + programa);
        System.out.println("ação: " + acao);
    }
}