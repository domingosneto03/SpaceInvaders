import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoaderTest {
    private LevelLoader loader;
    private Player p1;
    private Enemy e1;

    @BeforeEach
    void helper() throws IOException {
        loader = new LevelLoader();
        p1 = new Player(loader.getPlayerChars(50, 20));
        e1 = new Enemy(loader.getEnemy1Chars(10,5));
    }

    @Test
    void PlayerBuilt() {
        Assertions.assertTrue(p1.getChars().size()>0);
    }

    @Test
    void EnemyBuilt() {
        Assertions.assertTrue(e1.getChars().size()>0);
    }
}
