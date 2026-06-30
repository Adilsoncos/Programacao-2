import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> produtos;

    public Estoque() {

        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {

        produtos.add(produto);
    }

    public void listarProdutos() {

        if (produtos.isEmpty()) {

            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        System.out.println("\n========== ESTOQUE ==========");

        for (Produto p : produtos) {

            System.out.println(p.exibirDetalhes());
        }
    }

    public void adicionarExemplos() {

        produtos.add(new ProdutoPerecivel(
                "Leite",10,"20/06/2026"));

        produtos.add(new ProdutoPerecivel(
                "Iogurte",5,"18/06/2026"));

        produtos.add(new ProdutoPerecivel(
                "Queijo",8,"25/06/2026"));
    }
}