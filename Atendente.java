public class Atendente extends Funcionario {
    private double comissao;

    public Atendente(String nome, String cpf, double salario,
                     String dataNascimento, double comissao) {
        super(nome, cpf, salario, dataNascimento);
        this.comissao = comissao;
    }

    @Override
    public double getSalario() {
        return salario + comissao;
    }
}