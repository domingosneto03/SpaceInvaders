import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Element implements GenericChar {
    protected List<GenericChar> genericChars;

    Element(List<GenericChar> genericChars){
        this.genericChars = genericChars;
    }

    @Override
    public void moveUp() {
        for(GenericChar c : genericChars){
            c.moveUp();
        }
    }

    @Override
    public void moveDown() {
        for(GenericChar c : genericChars){
            c.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        for(GenericChar c : genericChars){
            c.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for(GenericChar c : genericChars){
            c.moveRight();
        }
    }

    public void draw(TextGraphics graphics) {
        for(GenericChar c : genericChars) {
            c.draw(graphics);
        }
    }
    public List<GenericChar> getChars() {
        return genericChars;
    }
}
