import java.util.Random;

public class ComputerPlayer extends Player {
    Random rand;

    //constructor to create an object of type super type Player
    public ComputerPlayer(char counter) {
        super(counter);
        rand = new Random();
    }

    //method to get a random number from computer player
    public int getMove() {
        return rand.nextInt(8) + 1;
    }

}
