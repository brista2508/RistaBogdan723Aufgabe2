import java.util.ArrayList;
import java.util.List;

public class Club {
    private int id;
    private String name;
    private String city;
    private List<Player> players;

    public Club(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.players = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        players.removeIf(player -> player.getName().equals(playerName));
    }

    @Override
    public String toString() {
        return "Club: " + name + " (" + city + ")";
    }
}