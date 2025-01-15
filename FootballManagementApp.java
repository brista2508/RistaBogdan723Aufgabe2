import java.util.Scanner;

public class FootballManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClubManager manager = new ClubManager();

        while (true) {
            System.out.println("""
                    1. Add Club
                    2. Display Clubs
                    3. Update Club
                    4. Remove Club
                    5. Add Player to Club
                    6. Display Players by Club
                    7. Filter Clubs by City
                    8. Sort Players by Market Value
                    0. Exit""");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Club ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Club Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Club City: ");
                    String city = sc.nextLine();
                    manager.addClub(new Club(id, name, city));
                }
                case 2 -> manager.displayClubs();
                case 3 -> {
                    System.out.print("Enter Club ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = sc.nextLine();
                    manager.updateClub(id, newName, newCity);
                }
                case 4 -> {
                    System.out.print("Enter Club ID to Remove: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    manager.removeClub(id);
                }
                case 5 -> {
                    System.out.print("Enter Club Name: ");
                    String clubName = sc.nextLine();
                    System.out.print("Enter Player Name: ");
                    String playerName = sc.nextLine();
                    System.out.print("Enter Player Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Player Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Player Market Value: ");
                    double marketValue = sc.nextDouble();
                    sc.nextLine();
                    for (Club club : manager.clubs) {
                        if (club.getName().equals(clubName)) {
                            club.addPlayer(new Player(playerName, age, position, marketValue));
                            break;
                        }
                    }
                }
                case 6 -> {
                    System.out.print("Enter Club Name: ");
                    String clubName = sc.nextLine();
                    manager.displayPlayersByClubName(clubName);
                }
                case 7 -> {
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    manager.displayClubsByCity(city);
                }
                case 8 -> {
                    System.out.print("Enter Club Name: ");
                    String clubName = sc.nextLine();
                    System.out.print("Sort Ascending (true/false): ");
                    boolean ascending = sc.nextBoolean();
                    sc.nextLine();
                    manager.sortPlayersByMarketValue(clubName, ascending);
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Option.");
            }
        }
    }
}