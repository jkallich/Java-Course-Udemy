import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_Challenge {

    private static final Map<Integer, Location> locations = new HashMap<>();
    private static Map<String, String> vocabulary = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", false, true));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", false, false));
        locations.put(2, new Location(2, "You are at the top of a hill", false, false));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", false, false));
        locations.put(4, new Location(4, "You are in a valley before a stream", false, false));
        locations.put(5, new Location(5, "You are in the forest", false, false));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);


        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);


        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

//        while (true) {
        command();
//        }
    }

    public static void command() {
        Scanner scanner = new Scanner(System.in);

        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");
        vocabulary.put("N", "N");
        vocabulary.put("S", "S");
        vocabulary.put("E", "E");
        vocabulary.put("W", "W");
        vocabulary.put("Q", "Q");


        int loc = 1;
        Location l = locations.get(loc);
        System.out.println(l.getDescription());
        System.out.println();

//        if (l.getLocationID() == 0) {
//            break;
//        }

        Map<String, Integer> exits = locations.get(loc).getExits();
        System.out.print("Available exits are ");
        for (String exitKey : exits.keySet()) {
            System.out.print(exitKey + ", ");
        }
        System.out.println();

        String direction = scanner.nextLine().toUpperCase();

        String[] userDirection = direction.split(" ");

        String directionLetter = null;
        for (String userD : userDirection) {
            if (vocabulary.containsKey(userD)) {
                loc = exits.get(vocabulary.get(userD));
                directionLetter = vocabulary.get(userD);
                break;
            }
        }

        if (exits.containsKey(directionLetter)) {
            loc = exits.get(directionLetter);
        } else {
            System.out.println("You may not go in that direction");
        }

        Location l2 = locations.get(loc);
        System.out.println(l2.getDescription());
        System.out.println();

        Map<String, Integer> exits2 = locations.get(loc).getExits();
        System.out.print("Available exits are ");
        for (String exitKey : exits2.keySet()) {
            System.out.print(exitKey + ", ");
        }
    }
}