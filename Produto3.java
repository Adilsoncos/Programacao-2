public class Produto3 {
    static class Produto {
        String nome; double preco; int estoque;
        Produto(String n,double p,int e){nome=n;preco=p;estoque=e;}
        double calcularValorTotalEmEstoque(){return preco*estoque;}
    }
    public static void main(String[] args){
        System.out.println(new Produto("Apontador",1.0,50).calcularValorTotalEmEstoque());
    }
}
