
public class ContarParesImpares {

    public static int[] contarParesImpares(int[] numeros) {
        int pares = 0, impares = 0;

        for (int n : numeros) {
            if (n % 2 == 0)
                pares++;
            else
                impares++;
        }

        return new int[]{pares, impares};
    }

    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 4, 5, 6};

        int[] resultado = contarParesImpares(valores);

        System.out.println("Pares: " + resultado[0]);
        System.out.println("Ímpares: " + resultado[1]);
    }
}

