import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    boolean isGameRunning = true;
    private Level level;
    private Screen screen;

    private Player player = new Player(new ArrayList<>());

    public Game() {
        try {
            level = new Level(player,"Tutorial",60,30);
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

    private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> player.moveUp();
            case ArrowDown  -> player.moveDown();
            case ArrowLeft  -> player.moveLeft();
            case ArrowRight -> player.moveRight();
            //case Backspace -> player.attack();
        }
    }
    public void run() throws IOException{
        while(isGameRunning) {
            draw(level);
            KeyStroke key = screen.readInput();
            KeyType keyType = key.getKeyType();
            processKey(key);
            if(keyType == KeyType.EOF)
                isGameRunning = false;
            else if(keyType == keyType.Character) {
                if(key.getCharacter() == 'q')
                    screen.close();
                    isGameRunning = false;
            }
        }
    }
}
