import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MovementTest {
    private Player p1, p2, p3, p4;

    @BeforeEach
    void helper() {
        List<Char> l1 = new ArrayList<>();
        List<Char> l2 = new ArrayList<>();
        List<Char> l3 = new ArrayList<>();
        List<Char> l4 = new ArrayList<>();
        l1.add(new Char('*', "#FFFFFF", new Position(25, 25)));
        l2.add(new Char('*', "#FFFFFF", new Position(50, 32)));
        l3.add(new Char('*', "#FFFFFF", new Position(2, 25)));
        l4.add(new Char('*', "#FFFFFF", new Position(93, 25)));
        p1 = new Player(l1);
        p2 = new Player(l2);
        p3 = new Player(l3);
        p4 = new Player(l4);
    }

    @Test
    void moveUp() {
        p1.moveUp();
        Assertions.assertEquals(p1.getChars().get(0).getPosition(), new Position(25, 24));
    }

    @Test
    void moveDown() {
        p1.moveDown();
        Assertions.assertEquals(p1.getChars().get(0).getPosition(), new Position(25, 26));
    }

    @Test
    void moveLeft() {
        p1.moveLeft();
        Assertions.assertEquals(p1.getChars().get(0).getPosition(), new Position(24, 25));
    }

    @Test
    void moveRight() {
        p1.moveRight();
        Assertions.assertEquals(p1.getChars().get(0).getPosition(), new Position(26, 25));
    }

    @Test
    void moveDownTrapped() {
        p2.moveDown();
        Assertions.assertEquals(p2.getChars().get(0).getPosition(), new Position(50, 32));
    }

    @Test
    void moveLeftTrapped() {
        p3.moveLeft();
        Assertions.assertEquals(p3.getChars().get(0).getPosition(), new Position(1, 25));
    }

    @Test
    void moveRightTrapped() {
        p4.moveRight();
        Assertions.assertEquals(p4.getChars().get(0).getPosition(), new Position(94, 25));
    }
}