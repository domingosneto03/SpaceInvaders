import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollisionTest {
    private Player p1;
    private Enemy e1;

    @BeforeEach
    void helper() {
        List<Char> l1 = new ArrayList<>();
        List<Char> l2 = new ArrayList<>();

        l1.add(new Char('+', "#123456", new Position(5, 5)));   // player
        l1.add(new Char('+', "#123456", new Position(5, 6)));   // ++
        l1.add(new Char('+', "#123456", new Position(6, 5)));   // ++**
        l1.add(new Char('+', "#123456", new Position(6, 6)));   //   ** enemy

        l2.add(new Char('*', "#123456", new Position(7, 6)));
        l2.add(new Char('*', "#123456", new Position(7, 7)));
        l2.add(new Char('*', "#123456", new Position(8, 6)));
        l2.add(new Char('*', "#123456", new Position(8, 7)));

        p1 = new Player(l1);
        e1 = new Enemy(l2);
    }

    @Test
    void notColliding() {
        boolean hasCollided = false;
        for (Char c : e1.getChars()) {
            if (p1.checkColision(c)) {
                hasCollided = true;
                break;
            }
        }
        Assertions.assertFalse(hasCollided);
    }

    @Test
    void colliding() {
        boolean hasCollided = false;
        p1.moveRight(); //player moved right and is now colliding with enemy
        for (Char c : e1.getChars()) {
            if (p1.checkColision(c)) {
                hasCollided = true;
                break;
            }
        }
        Assertions.assertTrue(hasCollided);
    }
}
