import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Level implements GenericLevel{

    private String name;
    private int width;
    private int height;

    private boolean borderLeft;
    private Player player;
    private Enemy enemy1;

    private Enemy enemy2;

    private LevelLoader loader;

    private TextGraphics graphics;

    public Level(String name,int width, int height, TextGraphics graphics) throws IOException {
        this.graphics = graphics;
        this.loader = new LevelLoader();
        this.player = new Player(loader.getPlayerChars(41,41));
        this.enemy1 = new Enemy(loader.getEnemy1Chars(0,0));
        this.enemy2 = new Enemy(loader.getEnemy2Chars(12,0));
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
    public boolean checkColisions(Char bullet,Element element) throws IOException {
        LevelLoader ld = new LevelLoader();
        int bx = bullet.getPosition().getX();
        int by = bullet.getPosition().getY();
        int exi = element.getI().getX();
        int eyi = element.getI().getY();
        int exf = element.getF().getX();
        int eyf = element.getF().getY();
        if (bx > exi && bx < exf && by > eyi && by < eyf){
            element.setChars(ld.getExplosionChars(exi,eyi));
            return true;
        }
        return false;
    }

    public void moveEnemy() throws InterruptedException {
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
