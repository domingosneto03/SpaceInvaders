import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelLoader {


    private final List<Char> playerChars;

    public List<Char> getPlayerChars() {
        return playerChars;
    }

    private final List<Char> enemy1Chars;

    public List<Char> getEnemy1Chars() {
        return enemy1Chars;
    }

    private final List<Char> enemy2Chars;

    public List<Char> getEnemy2Chars() {
        return enemy2Chars;
    }

    public LevelLoader() throws IOException {
        URL player = LevelLoader.class.getResource("/elements/player.txt");
        BufferedReader br_player = new BufferedReader(new FileReader(player.getFile()));
        URL enemy1 = LevelLoader.class.getResource("/elements/enemy1.txt");
        BufferedReader br_enemy1 = new BufferedReader(new FileReader(enemy1.getFile()));
        URL enemy2 = LevelLoader.class.getResource("/elements/enemy2.txt");
        BufferedReader br_enemy2 = new BufferedReader(new FileReader(enemy2.getFile()));
        URL enemy3 = LevelLoader.class.getResource("/elements/enemy3.txt");
        BufferedReader br_enemy3 = new BufferedReader(new FileReader(enemy3.getFile()));
        URL enemy4 = LevelLoader.class.getResource("/elements/enemy4.txt");
        BufferedReader br_enemy4 = new BufferedReader(new FileReader(enemy4.getFile()));
        URL enemy5 = LevelLoader.class.getResource("/elements/enemy5.txt");
        BufferedReader br_enemy5 = new BufferedReader(new FileReader(enemy5.getFile()));

        playerChars = createElement(readLines(br_player),21,21);
        enemy1Chars = createElement(readLines(br_enemy1),0,0);
        enemy2Chars = createElement(readLines(br_enemy2),12,0);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }


    protected List<Char> createElement(List<String> lines,int n_x,int n_y) {
        List<Char> chars = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if(Character.isSpaceChar(line.charAt(x))) {
                    continue;
                }
                chars.add(new Char(line.charAt(x),"#27EA19", new Position(x+n_x, y+n_y)));
            }
        }
        return chars;
    }
}
