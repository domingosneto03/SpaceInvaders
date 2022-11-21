import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

public class PlayerChar implements Char{
    private  int colour;
    private char symbol;
    private Position position;

    @Override
    public void move() {

    }

    @Override
    public void Draw() {
        graphics.setForegroundColor(TextColor.Factory.fromString(colour));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), symbol);
    }

    public PlayerChar(char symbol, int colour, Position position){
        this.symbol = symbol;
        this.colour = colour;
        this.position = position;
    }
}
