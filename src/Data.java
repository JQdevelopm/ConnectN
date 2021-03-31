import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

class Data {
    private final List<Player> players;

    //constructor for data class creating players
    public Data() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    //method to get player counters and add them tp players

    public List<Character> getPlayerCounters() {
        List<Character> counters = new ArrayList<>();

        //goes for all list of Players and add the counters calling getCounter method.
        for (Player player : players) {
            counters.add(player.getCounter());
        }
        return counters;
    }

}
