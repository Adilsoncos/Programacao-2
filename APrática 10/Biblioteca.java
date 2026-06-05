import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Musica> musicas = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(Musica m) {musicas.add(m);
    }
    public int gerarId() {
        return proximoId++;
    }
    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public Musica buscar(int id) {
        for(Musica m : musicas) {
            if(m.getId() == id) {
                return m;
            }   
        }
        return null;
    }
    public void remover(int id) {musicas.removeIf(m -> m.getId() == id);
    }
    public void emprestar(Musica m, String pessoa, LocalDate dataPrevista) {
        emprestimos.add(new Emprestimo(m, pessoa, dataPrevista));   
    }
}