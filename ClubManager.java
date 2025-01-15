import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ClubManager {
    List<Club> clubs;

    public ClubManager() {
        this.clubs = new ArrayList<>();
    }

    public void addClub(Club club) {
        clubs.add(club);
    }

    public void updateClub(int id, String newName, String newCity) {
        for (Club club : clubs) {
            if (club.getId() == id) {
                club = new Club(id, newName, newCity); // Replace the club
                break;
            }
        }
    }

    public void removeClub(int id) {
        clubs.removeIf(club -> club.getId() == id);
    }

    public void displayClubs() {
        for (Club club : clubs) {
            System.out.println(club);
        }
    }

    public void displayPlayersByClubName(String clubName) {
        for (Club club : clubs) {
            if (club.getName().equals(clubName)) {
                for (Player player : club.getPlayers()) {
                    System.out.println(player);
                }
                return;
            }
        }
        System.out.println("Club not found.");
    }

    public void displayClubsByCity(String city) {
        clubs.stream()
                .filter(club -> club.getCity().equalsIgnoreCase(city))
                .forEach(System.out::println);
    }

    public void sortPlayersByMarketValue(String clubName, boolean ascending) {
        for (Club club : clubs) {
            if (club.getName().equals(clubName)) {
                List<Player> sortedPlayers = club.getPlayers().stream()
                        .sorted(Comparator.comparingDouble(Player::getMarketValue))
                        .collect(Collectors.toList());
                if (!ascending) {
                    Collections.reverse(sortedPlayers);
                }
                sortedPlayers.forEach(System.out::println);
                return;
            }
        }
        System.out.println("Club not found.");
    }
}