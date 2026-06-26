public class Musica {
    private int id;
    private String titulo;
    private String album;
    private String cantor;
    private String banda;
    private int ano;
    private String linkStreaming;
    private boolean emprestada;

    public Musica(int id, String titulo, String album, String cantor, String banda, int ano, String linkStreaming) {
        this.id = id;
        this.titulo = titulo;
        this.album = album;
        this.cantor = cantor;
        this.banda = banda;
        this.ano = ano;
        this.linkStreaming = linkStreaming;
        this.emprestada = false;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAlbum() { return album; }
    public String getCantor() { return cantor; }
    public String getBanda() { return banda; }
    public int getAno() { return ano; }
    public String getLinkStreaming() { return linkStreaming; }
    public void setLinkStreaming(String linkStreaming) { this.linkStreaming = linkStreaming; }
    public boolean isEmprestada() { return emprestada; }
    public void setEmprestada(boolean emprestada) { this.emprestada = emprestada; }

    public void editar(String titulo, String album, String cantor, String banda, int ano) {                     
        this.titulo = titulo;
        this.album = album;
        this.cantor = cantor;
        this.banda = banda;
        this.ano = ano;
    }
}