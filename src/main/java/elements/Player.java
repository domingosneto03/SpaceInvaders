package elements;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Player extends Element {
    public Player(List<Char> Chars) {
        super(Chars);
    }

    @Override
    public void  attack(){
        Char bullet = new Char('.', "#FFFFFF", new Position(Chars.get(0).getPosition().getX()+2,Chars.get(0).getPosition().getY()-2));
        bullets.add(bullet);
    }
    @Override
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
