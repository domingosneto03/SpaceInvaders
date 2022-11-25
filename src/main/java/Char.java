import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public interface Char {
    void move();

    void Draw(TextGraphics graphics); //mudei tudo para graphics
}
