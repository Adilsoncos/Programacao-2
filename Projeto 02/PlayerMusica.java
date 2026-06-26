import java.awt.Desktop;
import java.net.URI;

public class PlayerMusica {
    public static void tocar(Musica musica) {
        try {
            if (musica.getLinkStreaming() != null && !musica.getLinkStreaming().trim().isEmpty()) {
                Desktop.getDesktop().browse(new URI(musica.getLinkStreaming()));
            } else {
                System.out.println("Nenhum link associado a esta música.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao abrir o link da música.");
        }
    }
}