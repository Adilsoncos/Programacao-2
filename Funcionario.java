public class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    protected String dataNascimento;

    public Funcionario(String nome, String cpf, double salario, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
               ", CPF: " + cpf +
               ", Nascimento: " + dataNascimento +
               ", Salário: R$ " + getSalario();
    }
}