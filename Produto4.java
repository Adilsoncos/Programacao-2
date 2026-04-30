public class Produto4 {
    static class Produto {
        String nome; double preco; int estoque;
        Produto(String n,double p,int e){nome=n;preco=p;estoque=e;}
        void adicionarEstoque(int q){estoque+=q;}
    }
    public static void main(String[] args){
        Produto p=new Produto("Resma de papel A4",30.0,200);
        p.adicionarEstoque(40);
        System.out.println(p.estoque);
    }
}
