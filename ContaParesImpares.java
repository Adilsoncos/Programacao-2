import java.util.Scanner;

public class ContaParesImpares {

    public static boolean elementoExiste(String[] v, String b) {
        for (String e : v)
            if (e.equals(b)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); sc.nextLine();
        String[] v = new String[n];

        for (int i = 0; i < n; i++)
            v[i] = sc.nextLine();

        String busca = sc.nextLine();

        System.out.println(elementoExiste(v, busca));

        sc.close();
    }
}