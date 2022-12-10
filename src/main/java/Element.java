import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Element implements GenericChar {
    protected List<Char> Chars;

    protected List<Bullet> bullets;

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

    public void attack(){
        Bullet bullet = new Bullet((char)'\u2660', "#FFFFFF",new Position(Chars.get(1).getPosition().getX(),Chars.get(1).getPosition().getY()-1));
        bullets.add(bullet);
    }

    public void bulletMove(TextGraphics graphics){
        for(Bullet b : bullets){
            b.draw(graphics);
            b.moveUp();
        }
    }
}
