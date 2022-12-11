import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {
    private Char chars;
    @BeforeEach
    void helper() {
        chars = new Char('\u2660', "#FFFFFF", new Position(25, 25));
    }
    @Test
    void moveUp() {
        chars.moveUp();
        Assertions.assertEquals(24, chars.getPosition().getY());
    }

    @Test
    void moveDown() {
        chars.moveDown();
        Assertions.assertEquals(26, chars.getPosition().getY());
    }

    @Test
    void moveLeft() {
        chars.moveLeft();
        Assertions.assertEquals(24, chars.getPosition().getX());
    }

    @Test
    void moveRight() {
        chars.moveRight();
        Assertions.assertEquals(26, chars.getPosition().getX());
    }
}