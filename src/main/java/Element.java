import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Element implements GenericChar {
    protected List<Char> Chars;
    protected List<Char> bullets;

    Element(List<Char> Chars){
        this.Chars = Chars;
        bullets = new ArrayList<>();
    }

    @Override
    public void moveUp() {
        for(GenericChar c : Chars){
            c.moveUp();
        }
    }

    @Override
    public void moveDown() {
        for(GenericChar c : Chars){
            c.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        for(GenericChar c : Chars){
            c.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for(GenericChar c : Chars){
            c.moveRight();
        }
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
        Char bullet = new Char('.', "#FFFFFF", new Position(Chars.get(0).getPosition().getX(),Chars.get(0).getPosition().getY()-2));
        bullets.add(bullet);
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
