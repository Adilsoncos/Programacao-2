import java.time.LocalDate;

public class Emprestimo {
    private Musica musica;
    private String pessoa;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    public Emprestimo(Musica musica, String pessoa, LocalDate dataPrevistaDevolucao) {
        this.musica = musica;
        this.pessoa = pessoa;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = null;
        musica.setEmprestada(true);
    }

    public Musica getMusica() { return musica; }
    public String getPessoa() { return pessoa; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    public void devolver(LocalDate data) {
        this.dataDevolucao = data;
        this.musica.setEmprestada(false);
    }
}