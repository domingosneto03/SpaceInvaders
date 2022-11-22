import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player = new Player(new ArrayList<>(), null); //tem de se meter na arena/nivel depois
    private Screen screen;

    public Game() {
        try {
            player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(30, 29)));
            player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(30, 28)));  //que xaxada de nave XD
            player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(29, 29)));
            player.getChars().add(new PlayerChar((char)'\u2660', 0, new Position(31, 29)));
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
    private void draw(Player player) throws IOException {
        screen.clear();
        player.Draw(screen);
        screen.refresh();
    }
    public void run() throws IOException{
        draw(player);
    }
}
