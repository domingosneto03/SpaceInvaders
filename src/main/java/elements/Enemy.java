package elements;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Enemy extends Element {
    public Enemy(List<Char> genericChars) {
        super(genericChars);
    }

    public void  attack(){
        Char bullet = new Char('.', "#FFFFFF", new Position(Chars.get(0).getPosition().getX()+2,Chars.get(Chars.size()-1).getPosition().getY()+1));
        bullets.add(bullet);
    }
    @Override
    public void bulletMove(TextGraphics graphics){
        for (int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).getPosition().getY()<35) {
                bullets.get(i).draw(graphics);
                bullets.get(i).moveDown();
            }
            else {
                bullets.remove(i);
                i--;
            }
        }
    }
}
