import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AttackTest {
    private Player player_;
    private TextGraphics graphics_;
    private LevelLoader loader_;

    @BeforeEach
    void helper() throws IOException {
        TerminalSize terminalSize = new TerminalSize(100, 50);
        SwingTerminalFontConfiguration fontConfiguration = SwingTerminalFontConfiguration.getDefaultOfSize(20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize).setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();
        Screen screen_ = new TerminalScreen(terminal);
        screen_.setCursorPosition(null);
        screen_.startScreen();
        screen_.doResizeIfNecessary();
        loader_ = new LevelLoader();
        player_ = new Player(loader_.getPlayerChars(25,25));
        graphics_ = screen_.newTextGraphics();
    }

    @Test
    void checkFired() {
        player_.attack();
        Assertions.assertEquals(1, player_.getBullets().size());
    }

    @Test
    void checkBulletPosition() { //check if bullet spawned in the correct position
        player_.attack();
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(25, 23));
    }

    @Test
    void bulletMovement() {
        player_.attack(); //current bullet position here is 25/23
        player_.bulletMove(graphics_); //bullet has moved to 25/22
        player_.bulletMove(graphics_); //bullet has moved to 25/21
        player_.bulletMove(graphics_); //bullet has moved to 25/20
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(25, 20));
    }
}
