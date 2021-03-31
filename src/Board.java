import java.util.List;

public class Board {

    private final char[][] board;
    private final int verticalSize = 7;
    private final int horizontalSize = 8;
    public final int winSize;
    private int count = 0;
    //Boolean hasWon = false;

    //Creates a fixed Width board and receives the winning condition
    public Board(int N) {
        board = new char[verticalSize][horizontalSize];
        winSize = N;
    }

    public String getWinMessage(char player) { // method used to display winner message.
        return "Congratulations Player " + player + " you have won!!";
    }

    public boolean canPlay(char counter) { // method used to validate if game can continue
        return (checkHorizontal(counter) || checkVertical(counter));
    }

    private boolean hasWon(int count) { // method used to validate if player won based on count from checkVertical and checkHorizontal and the win Condition.
        return count >= winSize;
    }

    //ok so these methods are used for the win, we call this after every place counter, have to admit this took me some time to create but finally is working this runs all board from top to bottom and validates if counter is in consecutive positions
    public boolean checkVertical(char counter) {
        for (int j = 0; j < horizontalSize; j++) {
            for (int i = verticalSize - 1; i >= 0; i--) {
                if (board[i][j] == counter) {
                    count++;
                    if (hasWon(count)) return true;
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }

    public boolean checkHorizontal(char counter) {
        for (int i = verticalSize - 1; i >= 0; i--) {
            for (int j = 0; j < horizontalSize; j++) {

                if (board[i][j] == counter) {
                    count++;
                    if (hasWon(count)) return true;
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }
    //places the counter in board based on position, checks if any other counter is there.
    public boolean placeCounter(char counter, int position, List<Character> counters) {
        for (int i = verticalSize - 1; i >= 0; i--) {
            if (!counters.contains(board[i][position])) { // check if that column is busy
                board[i][position] = counter;
                return true;
            }

        }
        return false;
    }

    //method to print board using the toString from Java.
    public String toString() {
        String s = "";
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (board[i][j] == 'B') {
                    System.out.print("| B ");
                } else if (board[i][j] == 'Y') {
                    System.out.print("| Y ");
                } else if (board[i][j] == 'R') {
                    System.out.print("| R ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        s += ("  1   2   3   4   5   6   7   8");
        return s;
    }


}
