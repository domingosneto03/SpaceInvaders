import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Element implements GenericChar {
    protected List<Char> Chars;

    protected List<Char> bullets;
    protected List<Char> removedBullets;

    protected Position i;

    protected Position f;

    public Position getI() {
        return i;
    }

    public Position getF() {
        return f;
    }

    public void setChars(List<Char> chars) {
        Chars = chars;
        sortElementChars();
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    Element(List<Char> Chars){
        this.Chars = Chars;
        sortElementChars();
        bullets = new ArrayList<>();
        removedBullets = new ArrayList<>();
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
        if (i.getY()>31) {return;}
        for(GenericChar c : Chars){
            c.moveDown();
        }
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    @Override
    public void moveLeft() {
        if (i.getX()<0) {return;}
        for(GenericChar c : Chars){
            c.moveLeft();
        }
        i = Chars.get(0).getPosition();
        f = Chars.get(Chars.size()-1).getPosition();
    }

    @Override
    public void moveRight() {
        if (i.getX()>93) {return;}
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

    public boolean checkColision(Char b) {
        int bx = b.getPosition().getX();
        int by = b.getPosition().getY();
        int exi = i.getX();
        int eyi = i.getY();
        int exf = f.getX();
        int eyf = f.getY();
        return (bx >= exi && bx <= exf) && (by >= eyi && by <= eyf);
    }

    public void sortElementChars() {
        Collections.sort(Chars, (c1, c2) -> {
            if (c1.getPosition().getX() == c2.getPosition().getX()) {
                return c1.getPosition().getY() - c2.getPosition().getY();
            }
            return c1.getPosition().getX() - c2.getPosition().getX();
        });
    }
}
