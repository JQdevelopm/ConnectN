import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private char counter;

    //super Class Player used to creat a player with a counter.
    public Player(char counter) {
        this.counter = counter;
    }

    public char getCounter() {
        return counter;
    }

    abstract int getMove();
}
