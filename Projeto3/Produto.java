public class Produto {

    protected String nome;
    protected int quantidade;

    public Produto(String nome, int quantidade) {

        if (quantidade < 0) {
            throw new IllegalArgumentException(
                    "A quantidade não pode ser negativa.");
        }

        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String exibirDetalhes() {

        return "Nome: " + nome +
               " | Quantidade: " + quantidade;
    }
}