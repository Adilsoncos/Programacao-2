public class notasDiferentes {

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

            System.out.println("Aluno: " + nome);
            System.out.println("Matrícula: " + matricula);
            System.out.printf("Média: %.2f%n", media);

            if (media >= 7.0) {
                System.out.println("Situação: APROVADO");
            } else {
                System.out.println("Situação: REPROVADO");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Carlos", "2026001", 8.0, 7.5, 9.0);
        Aluno aluno2 = new Aluno("Marina", "2026002", 5.0, 6.0, 4.5);

        aluno1.verificarSituacao();
        aluno2.verificarSituacao();
    }
}