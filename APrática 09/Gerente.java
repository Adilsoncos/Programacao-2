public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, double salario, String dataNascimento) {
        super(nome, cpf, salario, dataNascimento);
    }

    @Override
    public double getSalario() {
        return salario + 2000;
    }
}