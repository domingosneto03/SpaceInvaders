import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.List;

public class Element implements Char{
    protected List<Char> chars;
    protected MovimentType Mtype;
    Element(List<Char> chars, MovimentType Mtype){
        this.chars = chars;
        this.Mtype = Mtype;
    }

    @Override
    public void move() {
        for(Char c : chars){
            Mtype.move(c);
        }
    }
    public void Draw(TextGraphics graphics) {
        for(Char c : chars) {
            c.Draw(graphics);
        }
    }
    public List<Char> getChars() {
        return chars;
    }
}
