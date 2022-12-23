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
    BufferedReader br_enemy6;

    public List<Char> getEnemy6Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy6),x,y);
    }

    BufferedReader br_enemy7;

    public List<Char> getEnemy7Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy7),x,y);
    }

    BufferedReader br_enemy8;

    public List<Char> getEnemy8Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy8),x,y);
    }

    BufferedReader br_enemy9;

    public List<Char> getEnemy9Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy9),x,y);
    }

    BufferedReader br_enemy10;

    public List<Char> getEnemy10Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy10),x,y);
    }

    BufferedReader br_enemy11;

    public List<Char> getEnemy11Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy11),x,y);
    }

    BufferedReader br_enemy12;

    public List<Char> getEnemy12Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy12),x,y);
    }

    BufferedReader br_enemy13;

    public List<Char> getEnemy13Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy13),x,y);
    }

    BufferedReader br_enemy14;

    public List<Char> getEnemy14Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy14),x,y);
    }

    BufferedReader br_enemy15;

    public List<Char> getEnemy15Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy15),x,y);
    }
    BufferedReader br_enemy16;

    public List<Char> getEnemy16Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy16),x,y);
    }

    BufferedReader br_enemy17;

    public List<Char> getEnemy17Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy17),x,y);
    }

    BufferedReader br_enemy18;

    public List<Char> getEnemy18Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy18),x,y);
    }

    BufferedReader br_enemy19;

    public List<Char> getEnemy19Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy19),x,y);
    }

    BufferedReader br_enemy20;

    public List<Char> getEnemy20Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy20),x,y);
    }

    BufferedReader br_enemy21;

    public List<Char> getEnemy21Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy21),x,y);
    }

    BufferedReader br_enemy22;

    public List<Char> getEnemy22Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy22),x,y);
    }

    BufferedReader br_enemy23;

    public List<Char> getEnemy23Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy23),x,y);
    }

    BufferedReader br_enemy24;

    public List<Char> getEnemy24Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy24),x,y);
    }

    BufferedReader br_enemy25;

    public List<Char> getEnemy25Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy25),x,y);
    }
    BufferedReader br_enemy26;

    public List<Char> getEnemy26Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy26),x,y);
    }

    BufferedReader br_enemy27;

    public List<Char> getEnemy27Chars(int x,int y) throws IOException {
        return createElement(readLines(br_enemy27),x,y);
    }

    BufferedReader br_explosion;

    public List<Char> getExplosionChars(int x,int y) throws IOException {
        return createElement(readLines(br_explosion),x,y);
    }
    public LevelLoader() throws IOException {
        URL player = LevelLoader.class.getResource("/elements/player.txt");
        br_player = new BufferedReader(new FileReader(player.getFile()));
        URL enemy1 = LevelLoader.class.getResource("/elements/enemy1.txt");
        br_enemy1 = new BufferedReader(new FileReader(enemy1.getFile()));
        URL enemy2 = LevelLoader.class.getResource("/elements/enemy2.txt");
        br_enemy2 = new BufferedReader(new FileReader(enemy2.getFile()));
        URL enemy3 = LevelLoader.class.getResource("/elements/enemy3_.txt");
        br_enemy3 = new BufferedReader(new FileReader(enemy3.getFile()));
        URL enemy4 = LevelLoader.class.getResource("/elements/enemy4_.txt");
        br_enemy4 = new BufferedReader(new FileReader(enemy4.getFile()));
        URL enemy5 = LevelLoader.class.getResource("/elements/enemy5_.txt");
        br_enemy5 = new BufferedReader(new FileReader(enemy5.getFile()));
        URL enemy6 = LevelLoader.class.getResource("/elements/enemy6_.txt");
        br_enemy6 = new BufferedReader(new FileReader(enemy6.getFile()));
        URL enemy7 = LevelLoader.class.getResource("/elements/enemy7_.txt");
        br_enemy7 = new BufferedReader(new FileReader(enemy7.getFile()));
        URL enemy8 = LevelLoader.class.getResource("/elements/enemy8_.txt");
        br_enemy8 = new BufferedReader(new FileReader(enemy8.getFile()));
        URL enemy9 = LevelLoader.class.getResource("/elements/enemy9_.txt");
        br_enemy9 = new BufferedReader(new FileReader(enemy9.getFile()));
        URL enemy10 = LevelLoader.class.getResource("/elements/enemy10_.txt");
        br_enemy10 = new BufferedReader(new FileReader(enemy10.getFile()));
        URL enemy11 = LevelLoader.class.getResource("/elements/enemy11_.txt");
        br_enemy11 = new BufferedReader(new FileReader(enemy11.getFile()));
        URL enemy12 = LevelLoader.class.getResource("/elements/enemy12_.txt");
        br_enemy12 = new BufferedReader(new FileReader(enemy12.getFile()));
        URL enemy13 = LevelLoader.class.getResource("/elements/enemy13_.txt");
        br_enemy13 = new BufferedReader(new FileReader(enemy13.getFile()));
        URL enemy14 = LevelLoader.class.getResource("/elements/enemy14_.txt");
        br_enemy14 = new BufferedReader(new FileReader(enemy14.getFile()));
        URL enemy15 = LevelLoader.class.getResource("/elements/enemy15_.txt");
        br_enemy15 = new BufferedReader(new FileReader(enemy15.getFile()));
        URL enemy16 = LevelLoader.class.getResource("/elements/enemy16_.txt");
        br_enemy16 = new BufferedReader(new FileReader(enemy16.getFile()));
        URL enemy17 = LevelLoader.class.getResource("/elements/enemy17_.txt");
        br_enemy17 = new BufferedReader(new FileReader(enemy17.getFile()));
        URL enemy18 = LevelLoader.class.getResource("/elements/enemy18_.txt");
        br_enemy18 = new BufferedReader(new FileReader(enemy18.getFile()));
        URL enemy19 = LevelLoader.class.getResource("/elements/enemy19_.txt");
        br_enemy19 = new BufferedReader(new FileReader(enemy19.getFile()));
        URL enemy20 = LevelLoader.class.getResource("/elements/enemy20_.txt");
        br_enemy20 = new BufferedReader(new FileReader(enemy20.getFile()));
        URL enemy21 = LevelLoader.class.getResource("/elements/enemy21_.txt");
        br_enemy21 = new BufferedReader(new FileReader(enemy21.getFile()));
        URL enemy22 = LevelLoader.class.getResource("/elements/enemy22_.txt");
        br_enemy22 = new BufferedReader(new FileReader(enemy22.getFile()));
        URL enemy23 = LevelLoader.class.getResource("/elements/enemy23_.txt");
        br_enemy23 = new BufferedReader(new FileReader(enemy23.getFile()));
        URL enemy24 = LevelLoader.class.getResource("/elements/enemy24_.txt");
        br_enemy24 = new BufferedReader(new FileReader(enemy24.getFile()));
        URL enemy25 = LevelLoader.class.getResource("/elements/enemy25_.txt");
        br_enemy25 = new BufferedReader(new FileReader(enemy25.getFile()));
        URL enemy26 = LevelLoader.class.getResource("/elements/enemy26_.txt");
        br_enemy26 = new BufferedReader(new FileReader(enemy26.getFile()));
        URL enemy27 = LevelLoader.class.getResource("/elements/enemy27_.txt");
        br_enemy27 = new BufferedReader(new FileReader(enemy27.getFile()));
        URL explosion = LevelLoader.class.getResource("/elements/explosion.txt");
        br_explosion = new BufferedReader(new FileReader(explosion.getFile()));
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
                chars.add(new Char(line.charAt(x),"#FFFFFF", new Position(x+n_x, y+n_y)));
            }
        }
        return chars;
    }
}
