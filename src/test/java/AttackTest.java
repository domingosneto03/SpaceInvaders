import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class AttackTest {
    private Player player_;
    private TextGraphics graphics_;

    @BeforeEach
    void helper() throws IOException {
        LevelLoader loader_ = new LevelLoader();
        player_ = new Player(loader_.getPlayerChars(25,25));
        graphics_ = Mockito.mock(TextGraphics.class);
    }

    @Test
    void checkFired() {
        player_.attack();
        Assertions.assertEquals(1, player_.getBullets().size());
    }

    @Test
    void checkBulletPosition() { //check if bullet spawned in the correct position
        player_.attack();
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(25, 23));
    }

    @Test
    void bulletMovement() {
        player_.attack(); //current bullet position here is 25/23
        player_.bulletMove(graphics_); //bullet has moved to 25/22
        player_.bulletMove(graphics_); //bullet has moved to 25/21
        player_.bulletMove(graphics_); //bullet has moved to 25/20
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(25, 20));
    }
}
