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
    private Enemy enemy1;

    private Enemy enemy2;

    private LevelLoader loader;

    private TextGraphics graphics;

    public Level(String name,int width, int height,TextGraphics graphics) throws IOException {
        this.graphics = graphics;
        this.loader = new LevelLoader();
        this.player = new Player(loader.getPlayerChars(21,21));
        this.enemy1 = new Enemy(loader.getEnemy1Chars(0,0));
        this.enemy2 = new Enemy(loader.getEnemy2Chars(12,0));
        this.name = name;
        this.width = width;
        this.height = height;
    }
    public void draw() {
        graphics.fillRectangle(new TerminalPosition(0, 0),graphics.getSize(), ' ');
        player.draw(graphics);
        player.bulletMove(graphics);
        enemy1.draw(graphics);
        enemy2.draw(graphics);

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
            case 1,3,5,6,7:
                enemy1.moveLeft(); enemy2.moveLeft();
            case 2,4:
                enemy1.moveRight();enemy2.moveRight();
        }
    }
}
