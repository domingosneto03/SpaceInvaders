import com.googlecode.lanterna.graphics.TextGraphics;

public interface GenericChar {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    void draw(TextGraphics graphics);
}
