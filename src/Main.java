import java.io.IOException;


public class Main {


    private static String argValue; //used to get arguments to other classes
    private static View view = new CLView();  // creates an object view to use method display and print messages.

    public static void main(String[] args) {
        argValue = args[0]; //
        int ConnectN = 0;
        try {
            ConnectN = Integer.parseInt(argValue); //asks for the argument to start the game
            if (ConnectN < 2 || ConnectN > 7) { //makes sure we can only play Connect 2 to 7, more or less than that makes the game no sense
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            view.display("Incorrect condition to play -> " + argValue);
            view.display("Please start this program with an argument that represents the ConnectN where N is the condition to Win, Insert numbers between (2 to 7)");
            System.exit(1);
        }

        //creates a new game and starts the game!!
        Game g = new Game(ConnectN);
        g.play();

    }

    //to pass the argvalue to Game class
    public static String getArgs() {
        return argValue;
    }

}
