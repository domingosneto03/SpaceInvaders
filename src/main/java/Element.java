import java.util.List;

public class Element implements Char{
    protected List<Char> chars;
    protected MovimentType Mtype;
    Element(List<Char> chars, MovimentType Mtype){
        this.chars = chars;
        this.Mtype = Mtype;
    }

    @Override
    public void move() {
        for(Char c : chars){
            Mtype.move(c);
        }
    }
}
