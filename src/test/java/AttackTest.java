import com.googlecode.lanterna.graphics.TextGraphics;
import elements.*;
import level.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class AttackTest {
    private Player player_;
    private List<Enemy> enemys_;
    private TextGraphics graphics_;
    private Level level_;

    @BeforeEach
    void helper() throws IOException {
        enemys_ = new ArrayList<>();
        List<Char> l = new ArrayList<>();
        l.add(new Char('*', "#FFFFFF", new Position(25, 25)));
        player_ = new Player(l);
        List<Char> l2 = new ArrayList<>();
        l2.add(new Char('+', "#FFFFFF", new Position(27, 22)));
        Enemy enemy_ = new Enemy(l2);
        enemys_.add(enemy_);
        graphics_ = Mockito.mock(TextGraphics.class);
        level_ = new Level("Test", 100, 35, graphics_);
        level_.setPlayer(player_);
        level_.setEnemys(enemys_);
    }

    @Test
    void checkFired() {
        player_.attack();
        Assertions.assertEquals(1, player_.getBullets().size());
    }

    @Test
    void checkBulletPosition() { //check if bullet spawned in the correct position
        player_.attack();
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(27, 23));
    }

    @Test
    void bulletMovement() {
        player_.attack(); //current bullet position here is 27/23
        player_.bulletMove(graphics_); //bullet has moved to 27/22
        player_.bulletMove(graphics_); //bullet has moved to 27/21
        player_.bulletMove(graphics_); //bullet has moved to 27/20
        Assertions.assertEquals(player_.getBullets().get(0).getPosition(), new Position(27, 20));
    }

    @Test
    void enemyKilled() {
        player_.attack(); //current bullet position here is 27/23
        player_.bulletMove(graphics_); //bullet has moved to 27/22 and is now colliding with enemy
        Assertions.assertEquals(enemys_.size(), 1);
        level_.checkColisionsEnemys(); //method is going to verify that bullet collided with enemy and will kill the enemy
        Assertions.assertEquals(enemys_.size(), 0);
    }
}
