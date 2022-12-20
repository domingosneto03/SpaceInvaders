import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovementTest {
    private Char char_;

    @BeforeEach
    void helper() {
        char_ = new Char('*', "#FFFFFF", new Position(25, 25));
    }
    @Test
    void moveUp() {
        char_.moveUp();
        Assertions.assertEquals(char_.getPosition(), new Position(25, 24));
    }

    @Test
    void moveDown() {
        char_.moveDown();
        Assertions.assertEquals(char_.getPosition(), new Position(25, 26));
    }

    @Test
    void moveLeft() {
        char_.moveLeft();
        Assertions.assertEquals(char_.getPosition(), new Position(24, 25));
    }

    @Test
    void moveRight() {
        char_.moveRight();
        Assertions.assertEquals(char_.getPosition(), new Position(26, 25));
    }
}