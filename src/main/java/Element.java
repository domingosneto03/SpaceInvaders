import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Element implements GenericChar {
    protected List<Char> Chars;

    public void setChars(List<Char> chars) {
        Chars = chars;
    }

    protected List<Char> bullets;

    protected Position i;

    protected Position f;

    public Position getI() {
        return i;
    }

    public Position getF() {
        return f;
    }

    Element(List<Char> Chars){
        this.Chars = Chars;
        bullets = new ArrayList<>();
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    @Override
    public void moveUp() {
        for(GenericChar c : Chars){
            c.moveUp();
        }
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    @Override
    public void moveDown() {
        for(GenericChar c : Chars){
            c.moveDown();
        }
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    @Override
    public void moveLeft() {
        for(GenericChar c : Chars){
            c.moveLeft();
        }
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    @Override
    public void moveRight() {
        for(GenericChar c : Chars){
            c.moveRight();
        }
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    public void draw(TextGraphics graphics) {
        for(GenericChar c : Chars) {
            c.draw(graphics);
        }
    }
    public List<Char> getChars() {
        return Chars;
    }

    public List<Char> getBullets() {
        return bullets;
    }

    public void attack(){

    }

    public void bulletMove(TextGraphics graphics){
        for (int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).getPosition().getY()>0) {
                bullets.get(i).draw(graphics);
                bullets.get(i).moveUp();
            }
            else {
                bullets.remove(i);
                i--;
            }
        }
    }
}
