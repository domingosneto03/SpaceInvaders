import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class AttackTest {
    private Player player_;
    private TextGraphics graphics_;

    @BeforeEach
    void helper() {
        List<Char> l = new ArrayList<>();
        l.add(new Char('*', "#FFFFFF", new Position(25, 25)));
        player_ = new Player(l);
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
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(27, 23));
    }

    @Test
    void bulletMovement() {
        player_.attack(); //current bullet position here is 27/23
        player_.bulletMove(graphics_); //bullet has moved to 27/22
        player_.bulletMove(graphics_); //bullet has moved to 27/21
        player_.bulletMove(graphics_); //bullet has moved to 27/20
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(27, 20));
    }
}
