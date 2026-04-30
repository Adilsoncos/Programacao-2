public class Produto1 {
    static class Produto {
        String nome; double preco; int estoque;
        Produto(String n, double p, int e){ nome=n; preco=p; estoque=e; }
    }

    public static void main(String[] args) {
        Produto p = new Produto("Lápis", 1.5, 150);
        System.out.println(p.nome+" - R$"+p.preco+" - Estoque: "+p.estoque);
    }
}