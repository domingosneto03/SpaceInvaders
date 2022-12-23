import java.util.List;

public interface GenericLevel{
    public void movePlayer(ACTION action);
    public void moveEnemy() throws InterruptedException;

    void draw();

    List<Enemy> getEnemys();
}
