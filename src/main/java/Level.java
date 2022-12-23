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

    private List<Enemy> enemys;
    private Element winner, loser;

    private LevelLoader loader;

    private TextGraphics graphics;

    public Player getPlayer() {
        return player;
    }

    @Override
    public List<Enemy> getEnemys() {
        return enemys;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemys(List<Enemy> enemys) {
        this.enemys = enemys;
    }

    public Level(String name, int width, int height, TextGraphics graphics) throws IOException {
        this.graphics = graphics;
        this.loader = new LevelLoader();
        List<Char> l = new ArrayList<>();
        List<Char> l2 = new ArrayList<>();
        l.add(new Char('W', "#FFFFFF", new Position(48, 15)));
        l.add(new Char('I', "#FFFFFF", new Position(49, 15)));
        l.add(new Char('N', "#FFFFFF", new Position(50, 15)));
        l.add(new Char('N', "#FFFFFF", new Position(51, 15)));
        l.add(new Char('E', "#FFFFFF", new Position(52, 15)));
        l.add(new Char('R', "#FFFFFF", new Position(53, 15)));
        l2.add(new Char('L', "#FFFFFF", new Position(49, 5)));
        l2.add(new Char('O', "#FFFFFF", new Position(50, 5)));
        l2.add(new Char('S', "#FFFFFF", new Position(51, 5)));
        l2.add(new Char('E', "#FFFFFF", new Position(52, 5)));
        l2.add(new Char('R', "#FFFFFF", new Position(53, 5)));
        winner = new Element(l);
        loser = new Element(l2);
        this.player = new Player(loader.getPlayerChars(49,32));
        this.enemys = new ArrayList<>();
        Enemy enemy1 = new Enemy(loader.getEnemy1Chars(0,0)); enemys.add(enemy1);
        Enemy enemy2 = new Enemy(loader.getEnemy2Chars(9,0)); enemys.add(enemy2);
        Enemy enemy3 = new Enemy(loader.getEnemy3Chars(18, 0)); enemys.add(enemy3);
        Enemy enemy4 = new Enemy(loader.getEnemy4Chars(27,0)); enemys.add(enemy4);
        Enemy enemy5 = new Enemy(loader.getEnemy5Chars(36,0)); enemys.add(enemy5);
        Enemy enemy6 = new Enemy(loader.getEnemy6Chars(45, 0)); enemys.add(enemy6);
        Enemy enemy7 = new Enemy(loader.getEnemy7Chars(54, 0)); enemys.add(enemy7);
        Enemy enemy8 = new Enemy(loader.getEnemy8Chars(63,0)); enemys.add(enemy8);
        Enemy enemy9 = new Enemy(loader.getEnemy9Chars(72,0)); enemys.add(enemy9);
        Enemy enemy10 = new Enemy(loader.getEnemy10Chars(0,3)); enemys.add(enemy10);
        Enemy enemy11 = new Enemy(loader.getEnemy11Chars(9,3)); enemys.add(enemy11);
        Enemy enemy12 = new Enemy(loader.getEnemy12Chars(18,3)); enemys.add(enemy12);
        Enemy enemy13 = new Enemy(loader.getEnemy13Chars(27, 3)); enemys.add(enemy13);
        Enemy enemy14 = new Enemy(loader.getEnemy14Chars(36,3)); enemys.add(enemy14);
        Enemy enemy15 = new Enemy(loader.getEnemy15Chars(45,3)); enemys.add(enemy15);
        Enemy enemy16 = new Enemy(loader.getEnemy16Chars(54, 3)); enemys.add(enemy16);
        Enemy enemy17 = new Enemy(loader.getEnemy17Chars(63, 3)); enemys.add(enemy17);
        Enemy enemy18 = new Enemy(loader.getEnemy18Chars(72,3)); enemys.add(enemy18);
        Enemy enemy19 = new Enemy(loader.getEnemy19Chars(0,6)); enemys.add(enemy19);
        Enemy enemy20 = new Enemy(loader.getEnemy20Chars(9,6)); enemys.add(enemy20);
        Enemy enemy21 = new Enemy(loader.getEnemy21Chars(18,6)); enemys.add(enemy21);
        Enemy enemy22 = new Enemy(loader.getEnemy22Chars(27,6)); enemys.add(enemy22);
        Enemy enemy23 = new Enemy(loader.getEnemy23Chars(36, 6)); enemys.add(enemy23);
        Enemy enemy24 = new Enemy(loader.getEnemy24Chars(45,6)); enemys.add(enemy24);
        Enemy enemy25 = new Enemy(loader.getEnemy25Chars(54,6)); enemys.add(enemy25);
        Enemy enemy26 = new Enemy(loader.getEnemy26Chars(63, 6)); enemys.add(enemy26);
        Enemy enemy27 = new Enemy(loader.getEnemy27Chars(72, 6)); enemys.add(enemy27);
        this.name = name;
        this.width = width;
        this.height = height;
        this.borderLeft = true;
    }
    public void draw(){
        graphics.fillRectangle(new TerminalPosition(0, 0), graphics.getSize(), ' ');
        player.draw(graphics);
        player.bulletMove(graphics);
        for(Enemy e : enemys){
            e.draw(graphics);
            if (e.getChars().get(enemys.get(enemys.size() - 1).getChars().size() - 1).getPosition().getY() > 30) {
                loser.draw(graphics);
            }
        }
        if (enemys.size() == 0) {
            winner.draw(graphics);
        }
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
                if (playerShootTimer()) {player.attack();}
                break;
        }
    }
    public void checkColisionsEnemys(){
        for (int i = 0; i<enemys.size();i++){
            var e = enemys.get(i);
            for (Char b : player.getBullets()){
                if(e.checkColision(b)==true){
                    i++;
                    enemys.remove(e);
                    b.lock();
                    e.sortElementChars();
                }
            }
        }
    }
    public int getRightEnemyBorder() {
        int x = 0;
        for (Enemy e : enemys) {
            if (e.f.getX() > x) {x = e.f.getX();}
        }
        return x;
    }

    public int getLeftEnemyBorder() {
        int x = 150;
        for (Enemy e : enemys) {
            if (e.i.getX() < x) {x = e.i.getX();}
        }
        return x;
    }
    public void moveEnemy() {
        checkColisionsEnemys();
        if (enemyMoveTimer()) {
            if (enemys.size() > 0) {
                int left = getLeftEnemyBorder();
                int right = getRightEnemyBorder();
                if (left == 1) {
                    borderLeft = true;
                    for (Enemy e : enemys) {
                        e.moveDown();
                        e.moveRight();
                    }
                }
                if (right == 98) {
                    borderLeft = false;
                    for (Enemy e : enemys) {
                        e.moveDown();
                        e.moveLeft();
                    }
                }
                if (borderLeft == true) {
                    for (Enemy e : enemys) {
                        e.moveRight();
                    }
                } else {
                    for (Enemy e : enemys) {
                        e.moveLeft();
                    }
                }
            }
        }
    }

    private long lastEnemyMove = 0;
    public boolean enemyMoveTimer() {
        // check if enough time has passed (75 milisegundos podes ajustar)
        if (System.currentTimeMillis() - lastEnemyMove < 75) {
            return false;
        }
        // if we waited long enough, move the enemys
        lastEnemyMove = System.currentTimeMillis();
        return true;
    }

    private long lastPlayerShot = 0;
    public boolean playerShootTimer() {
        // check if enough time has passed (400 milisegundos podes ajustar)
        if (System.currentTimeMillis() - lastPlayerShot < 400) {
            return false;
        }
        // if we waited long enough, allow the shot
        lastPlayerShot = System.currentTimeMillis();
        return true;
    }
}
