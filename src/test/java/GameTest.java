import enums.GameStatus;
import gui.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GameTest {
    private Game game_;

    @BeforeEach
    void helper() throws IOException {
        game_ = new Game();
    }

    @Test
    void run() {
        Assertions.assertEquals(game_.isGameRunning(), true);
    }

    @Test
    void stop() {
        game_.stop();

        Assertions.assertEquals(game_.isGameRunning(), false);
    }
}
