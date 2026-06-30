public class ProdutoPerecivel extends Produto {

    private String validade;

    public ProdutoPerecivel(String nome,
                            int quantidade,
                            String validade) {

        super(nome, quantidade);
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }

    @Override
    public String exibirDetalhes() {

        return "Nome: " + nome +
               " | Quantidade: " + quantidade +
               " | Validade: " + validade;
    }
}