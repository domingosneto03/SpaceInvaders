import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelLoader {


    BufferedReader br_player;

    public List<Char> getPlayerChars(int x,int y) throws IOException {
        return createElement(readLines(br_player),x,y);
    }

    BufferedReader br_enemy1;

    public List<Char> getEnemy1Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy1),x,y);
    }

    BufferedReader br_enemy2;

    public List<Char> getEnemy2Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy2),x,y);
    }

    BufferedReader br_enemy3;

    public List<Char> getEnemy3Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy3),x,y);
    }

    BufferedReader br_enemy4;

    public List<Char> getEnemy4Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy4),x,y);
    }

    BufferedReader br_enemy5;

    public List<Char> getEnemy5Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy5),x,y);
    }
    public LevelLoader() throws IOException {
        URL player = LevelLoader.class.getResource("/elements/player.txt");
        br_player = new BufferedReader(new FileReader(player.getFile()));
        URL enemy1 = LevelLoader.class.getResource("/elements/enemy1.txt");
        br_enemy1 = new BufferedReader(new FileReader(enemy1.getFile()));
        URL enemy2 = LevelLoader.class.getResource("/elements/enemy2.txt");
        br_enemy2 = new BufferedReader(new FileReader(enemy2.getFile()));
        URL enemy3 = LevelLoader.class.getResource("/elements/enemy3.txt");
        br_enemy3 = new BufferedReader(new FileReader(enemy3.getFile()));
        URL enemy4 = LevelLoader.class.getResource("/elements/enemy4.txt");
        br_enemy4 = new BufferedReader(new FileReader(enemy4.getFile()));
        URL enemy5 = LevelLoader.class.getResource("/elements/enemy5.txt");
        br_enemy5 = new BufferedReader(new FileReader(enemy5.getFile()));

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
