import java.util.List;

public class Game {
    String argsFromMain = Main.getArgs(); // passing the value of the argument passed from start of game for game explanation to user.
    private int currentPlayerIndex;

    private final Data data;
    private final View view;
    private final Board board;

    //Constructor - creates a Game that receives the win condition as per argument 1 args[0] from command line.
    public Game(int N) {
        data = new Data(); // creates an object to manage all data (players and their respective counters).
        board = new Board(N);  // creates an object board passes the win condition to class Board
        view = new CLView();  // creates an object view to use method display and print messages.

        setPlayers(); // set 3 players to start the game
        play(); // starts the game
    }

    private void setPlayers() {
        // players
        Player player1 = new HumanPlayer('B');  // create a object player 1 from HumanPlayer of type Player
        Player player2 = new ComputerPlayer('R'); // create a object player 2 from ComputerPlayer of type Player
        Player player3 = new ComputerPlayer('Y'); // create a object player 2 from ComputerPlayer of type Player

        //adds each player to the array list of players
        data.addPlayer(player1);
        data.addPlayer(player2);
        data.addPlayer(player3);

    }

    private Player getCurrentPlayer() {
        if (currentPlayerIndex >= data.getNumberOfPlayers()) {
            currentPlayerIndex = 0;
        }
        return data.getPlayer(currentPlayerIndex);
    }

    public void play() {

        List<Character> counters = data.getPlayerCounters();
        Player currentPlayer;
        System.out.println("   ");
        System.out.println("You have selected to play with a condition to win of " + argsFromMain + "!");
        System.out.println("So, please enjoy your CONNECT" + argsFromMain);
        System.out.println("There are 3 players one-HUMAN and two-COMPUTER players");
        System.out.println("Player 1 is B-Blue (Human), Player 2 is R-Red (Computer), Player 3 is Y-Yellow (Computer)");
        System.out.println("To play the game type the column you want to drop your counter in");
        System.out.println("A player wins by connecting " + argsFromMain + " consecutive counters - vertically or horizontally!");
        System.out.println("");

        // prints our board to start the game
        view.display(board.toString());
        currentPlayer = getCurrentPlayer();

        //Cycle while to make sure there's no winners and keeps asking for moves from each player.
        while (!board.canPlay(currentPlayer.getCounter())) {
            currentPlayer = getCurrentPlayer();
            int x = currentPlayer.getMove();
            //place counter for each player

            if (!board.placeCounter(currentPlayer.getCounter(), x - 1, counters)) {
                view.display("Column " + x + " is full. Please try again!");
                continue;
            }

            // print board with results of each play
            view.display(board.toString());
            currentPlayerIndex++;

        }
        view.display(board.getWinMessage(currentPlayer.getCounter()));
        System.exit(1);
    }
}

