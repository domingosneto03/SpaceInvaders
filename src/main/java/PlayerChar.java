import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;

public class PlayerChar implements Char{
    private  int colour;
    private char symbol;
    private Position position;

    @Override
    public void move() {

    }

    @Override
    public void Draw(Screen screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter(symbol)[0]);
    }

    public PlayerChar(char symbol, int colour, Position position){
        this.symbol = symbol;
        this.colour = colour;
        this.position = position;
    }
}
