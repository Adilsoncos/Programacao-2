public class Main {
    static class Produto {
        String nome; double preco; int estoque;
        Produto(String n,double p,int e){nome=n;preco=p;estoque=e;}
        void exibirInfo(){System.out.println(nome+" - R$"+preco+" - Estoque: "+estoque);}
        double calcularValorTotalEmEstoque(){return preco*estoque;}
        void adicionarEstoque(int q){estoque+=q;}
    }
    public static void main(String[] args){
        Produto p1=new Produto("Caneta",2.0,200), p2=new Produto("Caderno",15,50);
        p1.exibirInfo(); p2.exibirInfo();
        System.out.println("Total Canetas: R$"+p1.calcularValorTotalEmEstoque());
        p1.adicionarEstoque(50);
        p1.exibirInfo();
    }
}
