import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level implements GenericLevel{

    private String name;
    private int width;
    private int height;

    private Player player;
    private Enemy enemy;

    private TextGraphics graphics;

    public Level(String name,int width, int height,TextGraphics graphics) {
        this.graphics = graphics;
        this.player = new Player(new ArrayList<>());
        this.enemy = new Enemy(new ArrayList<>());
        this.name = name;
        this.width = width;
        this.height = height;

        //player
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
    public void draw() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0c164f"));
        graphics.fillRectangle(new TerminalPosition(0, 0),graphics.getSize(), ' ');
        player.draw(graphics);
        player.bulletMove(graphics);
        enemy.draw(graphics);

    }

    public void movePlayer(ACTION action) {
        switch (action) {
            case UP:
                player.moveUp();
                break;
            case RIGHT:
                player.moveRight();
                break;
            case DOWN:
                player.moveDown();
                break;
            case LEFT:
                player.moveLeft();
                break;
            case SELECT:
                player.attack();
                break;
        }
    }


    public void moveEnemy() {
        Random random = new Random();
        int n = random.nextInt(7);
        switch(n) {
            case 1,3,5,6,7 -> enemy.moveDown();
            case 2,4 -> enemy.moveUp();
        }
    }
}
