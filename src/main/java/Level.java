import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level implements GenericLevel {

    private String name;
    private int width;
    private int height;

    private boolean borderLeft;
    private Player player;
    private Enemy enemy1;

    private Enemy enemy2;

    private List<Enemy> enemys;

    private LevelLoader loader;

    private TextGraphics graphics;

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemys() {
        return enemys;
    }

    public Level(String name, int width, int height, TextGraphics graphics) throws IOException {
        this.graphics = graphics;
        this.loader = new LevelLoader();
        this.player = new Player(loader.getPlayerChars(49,32));
        this.enemy1 = new Enemy(loader.getEnemy1Chars(0,0));
        this.enemy2 = new Enemy(loader.getEnemy2Chars(12,0));
        this.enemys = new ArrayList<>();
        enemys.add(enemy1);
        enemys.add(enemy2);
        this.name = name;
        this.width = width;
        this.height = height;
        this.borderLeft = true;
    }
    public void draw(){
        graphics.fillRectangle(new TerminalPosition(0, 0), graphics.getSize(), ' ');
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
        if(enemy1.getChars().get(0).getPosition().getX()==3){
            borderLeft = true;
            enemy1.moveDown();
            enemy2.moveDown();
            enemy2.moveRight();
            enemy1.moveRight();
        }
        if(enemy2.getChars().get(enemy2.getChars().size()-1).getPosition().getX()==width-1){
            borderLeft = false;
            enemy1.moveDown();
            enemy2.moveDown();
            enemy1.moveLeft();
            enemy2.moveLeft();
        }
        if(borderLeft == true){
            enemy1.moveRight();
            enemy2.moveRight();
        }
        else {
            enemy1.moveLeft();
            enemy2.moveLeft();
        }
    }
}
