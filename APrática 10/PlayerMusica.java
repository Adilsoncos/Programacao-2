import java.awt.Desktop;
import java.net.URI;

public class PlayerMusica {

    public static void tocar(Musica musica) {

        try {

            Desktop.getDesktop().browse(
                new URI(musica.getLinkStreaming())
            );

        } catch (Exception e) {

            System.out.println(
                "Erro ao abrir o link da música."
            );
        }
    }
}