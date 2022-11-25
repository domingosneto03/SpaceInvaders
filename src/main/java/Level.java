import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Level implements GenericLevel{

    private String name;
    private int width;
    private int height;

    private Player player;
    private Enemy enemy;

    public Level(Player player, Enemy enemy, String name,int width, int height) {
        this.player = player;
        this.enemy = enemy;
        this.name = name;
        this.width = width;
        this.height = height;
        player.getChars().add(new Char((char)'\u2660', 0, new Position(30, 29)));
        player.getChars().add(new Char((char)'\u2660', 0, new Position(30, 28)));
        player.getChars().add(new Char((char)'\u2660', 0, new Position(29, 29)));
        player.getChars().add(new Char((char)'\u2660', 0, new Position(31, 29)));

        //enemy1
        enemy.getChars().add(new Char('\u2665', 0, new Position (1,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (2,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (3,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (4,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (5,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (2,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (3,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (4,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (3,3)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (1,1)));

        //enemy2
        enemy.getChars().add(new Char('\u2665', 0, new Position (26,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (27,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (28,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (29,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (30,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (27,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (28,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (29,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (28,3)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (26,1)));

        //enemy3
        enemy.getChars().add(new Char('\u2665', 0, new Position (51,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (52,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (53,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (54,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (55,1)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (52,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (53,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (54,2)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (53,3)));
        enemy.getChars().add(new Char('\u2665', 0, new Position (51,1)));


    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0c164f"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(graphics);
        player.bulletMove(graphics);
        enemy.draw(graphics);

    }
}
