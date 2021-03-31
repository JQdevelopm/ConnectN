import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    private BufferedReader in;
    private final View view = new CLView();  // creates an object view to use method display and print messages.

    public HumanPlayer(char counter) {
        super(counter);
        in = new BufferedReader(new InputStreamReader(System.in));

        }
        public int getMove () {
            while (true) {
                try {
                    int num = Integer.parseInt(in.readLine());
                    if(num >= 1 && num <= 8) { // checks if number is valid within our board columns in this case up to 8.
                        return num;
                    }
                    view.display("Please enter a number between 1 and 8");
                } catch (IllegalArgumentException e) {
                    view.display("Incorrect number selected to play, please try again");
                } catch (IOException e) {
                    view.display("Error while reading your input, please restart!");
                    System.exit(1);
                }
            }
        }

}