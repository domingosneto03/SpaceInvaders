import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;

public class Arena {
    private int width;
    private int height;
    private Player player = new Player(new ArrayList<>(), null); //depois de ter movimento, definir onde pode andar

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(30, 29)));
        player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(30, 28)));  //boa xaxada
        player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(29, 29)));
        player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(31, 29)));
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0c164f"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.Draw(graphics);
    }
}
