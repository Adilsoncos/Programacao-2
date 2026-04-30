public class Produto2 {
    static class Produto {
        String nome; double preco; int estoque;
        Produto(String n,double p,int e){nome=n;preco=p;estoque=e;}
        void exibirInfo(){System.out.println(nome+" - R$"+preco+" - Estoque: "+estoque);}
    }
    public static void main(String[] args){
        new Produto("Caneta",2.0,200).exibirInfo();
    }
}
