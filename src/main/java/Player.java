import java.util.List;

public class Player extends Element {
    Player(List<Char> Chars) {
        super(Chars);
    }

    @Override
    public void attack(){
        Char bullet = new Char('.', "#FFFFFF", new Position(Chars.get(0).getPosition().getX()+2,Chars.get(0).getPosition().getY()-2));
        bullets.add(bullet);
    }
}
