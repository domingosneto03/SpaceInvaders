import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class Level {

    private String name;
    private int width;
    private int height;

    private Player player;

    public Level(Player player,String name,int width, int height) {
        this.player = player;
        this.name = name;
        this.width = width;
        this.height = height;
        player.getChars().add(new Char((char)'\u2660', 0, new Position(30, 29)));
        player.getChars().add(new Char((char)'\u2660', 0, new Position(30, 28)));
        player.getChars().add(new Char((char)'\u2660', 0, new Position(29, 29)));
        player.getChars().add(new Char((char)'\u2660', 0, new Position(31, 29)));
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0c164f"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(graphics);
    }
}
