import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawTest {
    private TextGraphics graphics_;
    private Level level_;

    @BeforeEach
    void helper() throws IOException {
        graphics_ = Mockito.mock(TextGraphics.class);
        level_ = new Level("Test", 100, 35, graphics_);
    }

    @Test
    void drawChar() {
        Char c = new Char('*', "#FFFFFF", new Position(50, 20));

        c.draw(graphics_);

        Mockito.verify(graphics_, Mockito.times(1)).setCharacter(50, 20,
                TextCharacter.fromCharacter('*', TextColor.Factory.fromString("#FFFFFF"), TextColor.Factory.fromString("#000000"))[0]);
    }

    @Test
    void drawElement() {
        List<Char> l = new ArrayList<>();
        l.add(new Char('.', "#123456", new Position(5, 5)));
        l.add(new Char('.', "#123456", new Position(6, 5)));
        l.add(new Char('.', "#123456", new Position(7, 5)));
        Element e = new Element(l);

        e.draw(graphics_);

        Mockito.verify(graphics_, Mockito.times(1)).setCharacter(5, 5,
                TextCharacter.fromCharacter('.', TextColor.Factory.fromString("#123456"), TextColor.Factory.fromString("#000000"))[0]);
        Mockito.verify(graphics_, Mockito.times(1)).setCharacter(6, 5,
                TextCharacter.fromCharacter('.', TextColor.Factory.fromString("#123456"), TextColor.Factory.fromString("#000000"))[0]);
        Mockito.verify(graphics_, Mockito.times(1)).setCharacter(7, 5,
                TextCharacter.fromCharacter('.', TextColor.Factory.fromString("#123456"), TextColor.Factory.fromString("#000000"))[0]);
    }

    @Test
    void drawLevel() {
        level_.draw();

        Mockito.verify(graphics_, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0),
                graphics_.getSize(), ' ');
        for (Char c : level_.getPlayer().getChars()) {
            Mockito.verify(graphics_, Mockito.times(1)).setCharacter(c.getPosition().getX(), c.getPosition().getY(),
                    TextCharacter.fromCharacter(c.getSymbol(), TextColor.Factory.fromString("#FFFFFF"), TextColor.Factory.fromString("#000000"))[0]);
        }
        for (Enemy e : level_.getEnemys()) {
            for (Char c : e.getChars()) {
            Mockito.verify(graphics_, Mockito.times(1)).setCharacter(c.getPosition().getX(), c.getPosition().getY(),
                    TextCharacter.fromCharacter(c.getSymbol(), TextColor.Factory.fromString("#FFFFFF"), TextColor.Factory.fromString("#000000"))[0]);
            }
        }
    }
}
