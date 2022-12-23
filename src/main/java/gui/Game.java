package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import level.GenericLevel;
import level.Level;
import enums.ACTION;
import enums.GameStatus;

import java.io.IOException;

public class Game {

    protected volatile GameStatus status;
    private GenericLevel level;
    private Screen screen;

    private TextGraphics graphics;


    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        SwingTerminalFontConfiguration fontConfiguration = SwingTerminalFontConfiguration.getDefaultOfSize(20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize).setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public Game() throws IOException {
        status = GameStatus.RUNNING;
        Terminal terminal = createTerminal(100, 35);
        this.screen = createScreen(terminal);
        graphics = screen.newTextGraphics();
        level = new Level("Level 1",100,35, graphics);

    }
    private void draw(GenericLevel level) throws IOException {
        screen.clear();
        level.draw();
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
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q')) return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }
    public void run() throws IOException, InterruptedException {
        status = GameStatus.RUNNING;
        while(isGameRunning()) {
            draw(level);
            if (level.getEnemys().size() == 0) {
                Thread.sleep(5000);
                break;
            }
            if (level.getEnemys().get(level.getEnemys().size() - 1).getChars().get(level.getEnemys().get(level.getEnemys().size()
                    - 1).getChars().size() - 1).getPosition().getY() > 31) {
                status = GameStatus.STOPPED;
                Thread.sleep(5000);
            }
            try {
                Thread.sleep(1000/60);
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
