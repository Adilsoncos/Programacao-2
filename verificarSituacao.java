public class verificarSituacao {

    static class Aluno {
        private String nome;
        private String matricula;
        private double nota1;
        private double nota2;
        private double notaTrabalho;

        public Aluno(String nome, String matricula, double nota1, double nota2, double notaTrabalho) {
            this.nome = nome;
            this.matricula = matricula;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.notaTrabalho = notaTrabalho;
        }

        public double calcularMedia() {
            return (nota1 + nota2 + notaTrabalho) / 3.0;
        }

        public void verificarSituacao() {
            double media = calcularMedia();

            if (media >= 7.0) {
                System.out.println("APROVADO");
            } else {
                System.out.println("REPROVADO");
            }
        }

        public void exibirDados() {
            System.out.println("Nome: " + nome);
            System.out.println("Matrícula: " + matricula);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota do Trabalho: " + notaTrabalho);
            System.out.printf("Média: %.2f%n", calcularMedia());
            System.out.print("Situação: ");
            verificarSituacao();
        }
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Adilson Costa", "2026001", 8.0, 7.5, 9.0);

        System.out.println("=== DADOS DO ALUNO ===");
        aluno.exibirDados();
    }
}
