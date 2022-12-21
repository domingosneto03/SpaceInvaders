import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Char implements GenericChar {
    private  TextColor color;
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
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter(symbol,color,TextColor.Factory.fromString("#000000"))[0]);
    }

    public Char(char symbol, String color, Position position){
        this.symbol = symbol;
        this.color = TextColor.Factory.fromString(color);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public char getSymbol() {return symbol;}

    public TextColor getColor() {return color; }
}
