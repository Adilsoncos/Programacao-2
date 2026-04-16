public class MediaNotas {
    public static void main(String[] args) {
        int[] notas = {7, 8, 6, 10, 9};

        // Calcular a soma
        int soma = 0;
        for (int nota : notas) {
            soma += nota;
        }

        // Calcular a média
        double media = (double) soma / notas.length;
        System.out.println("Média: " + media);

        // Contar quantas notas estão acima da média
        int acimaDaMedia = 0;
        for (int nota : notas) {
            if (nota > media) {
                acimaDaMedia++;
            }
        }

        System.out.println("Notas acima da média: " + acimaDaMedia);
    }
}