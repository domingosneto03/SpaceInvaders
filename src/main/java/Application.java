import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        try {
            game.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
