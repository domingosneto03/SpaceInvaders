import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    protected volatile GameStatus status;
    private Level level;
    private Screen screen;

    private Player player = new Player(new ArrayList<>());
    private Enemy enemy = new Enemy(new ArrayList<>());

    public Game() {
        status = GameStatus.RUNNING;
        try {
            level = new Level(player, enemy, "Tutorial",60,30);
            TerminalSize terminalSize = new TerminalSize(60, 30);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw(Level level) throws IOException {
        screen.clear();
        level.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void stop() {
        status = GameStatus.STOPPED;
    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }


    private ACTION processInput(){
        KeyStroke keyStroke = null;
        try {
            keyStroke = screen.pollInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }
    public void run() throws IOException{
        while(isGameRunning()) {
            draw(level);
            try {
                var lag = new Random().nextInt(200) + 50;
                Thread.sleep(lag);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ACTION action = processInput();
            if(action != ACTION.QUIT) {
                level.movePlayer(action);
            }
            if (action == ACTION.QUIT) {
                stop();
            }
            level.moveEnemy();
        }
        screen.close();
    }
}
