import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Char implements GenericChar {
    private  int colour;
    private char symbol;
    private Position position;


    @Override
    public void moveUp() {
        position.setY(position.getY()-1);
    }

    @Override
    public void moveDown() {
        position.setY(position.getY()+1);
    }

    @Override
    public void moveLeft() {
        position.setX(position.getX()-1);
    }

    @Override
    public void moveRight() {
        position.setX(position.getX()+1);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter(symbol)[0]);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0c164f"));
    }

    public Char(char symbol, int colour, Position position){
        this.symbol = symbol;
        this.colour = colour;
        this.position = position;
    }
}
