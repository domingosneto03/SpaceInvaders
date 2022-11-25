import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class PlayerChar implements Char{
    private  int colour;
    private char symbol;
    private Position position;

    @Override
    public void move() {

    }

    @Override
    public void Draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter(symbol)[0]);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0c164f")); //tentei remover o fundo preto, mas até parece uma nave
    }

    public PlayerChar(char symbol, int colour, Position position){
        this.symbol = symbol;
        this.colour = colour;
        this.position = position;
    }
}
