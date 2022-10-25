import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Location> locations = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static Map<String, String> vocabulary = new HashMap<>();
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {

        createLocs();
        addExits();
        createItems();
        createInventory();

        boolean gameOn = printIntro();
        if (gameOn) {
            gameLoop();
        }

        System.out.println();
        System.out.println();
        System.out.println("Thank you for playing!");
    }

    /**
     * Prints out the intro to the game
     *
     * @return
     */
    public static boolean printIntro() {
        System.out.println();
        System.out.println();
        System.out.println("You are walking down a small stone pathway, the pebbles crunching under your leather boots.");
        System.out.println("The wind is blowing gently, the sun shining down onto your shoulders.");
        System.out.println("You reach the small fence that surrounds your little cottage and grip the gate's handle.");
        System.out.println("As you step out of your cottage's land, you look back one last time at your home, and feel emotion swell in your chest.");
        System.out.println("The moment lasts for a second, and you turn away to the vast, rolling hills in front of you.");
        System.out.println("You gulp in a huge breath, and exhale slowly. Then you take your first step of your journey.");
        System.out.println();
        System.out.println();
        System.out.println("The adventure has begun.");
        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("You are an adventurer, exploring the wilds of a mystical land that has been the source of many legends and fairytales.");
        System.out.println("Travel the land and discover new places to collect valuable items and learn locked secrets!");
        System.out.println();
        System.out.println("/---------INSTRUCTIONS---------/");
        System.out.println("Use written commands to direct your character within the game.");
        System.out.println("Always write what is written in the prompts and given possibilities, or your input will be considered invalid.");
        System.out.println("Whenever you wish to quit the game after it has started, type in 'quit'.");
        System.out.println("Whenever you would like to see your inventory after it has started, type in 'inventory'.");
        System.out.println("**While you must type in the same letters to get a result, the prompts are not case sensitive.");
        System.out.println();
        System.out.println("Good luck, and may the adventure continue!");
        System.out.println("Shall we? (Yes/no)");

        while (true) {
            String begin = scanner.nextLine();
            if (begin.equalsIgnoreCase("yes")) {
                return true;
            } else if (begin.equalsIgnoreCase("no")) {
                System.out.println("Quiting...");
                return false;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    /**
     * Creates locations where the user will travel to.
     */
    public static void createLocs() {
        locations.put(-1, new Location(0, "You are checking the contents of your inventory.", false, false));
        locations.put(0, new Location(0, "You are standing in front of your cottage gate.", false, false));
        locations.put(1, new Location(1, "You are standing in some sort of abandoned village square.\nWest is an old-looking pub.\nEast is a sturdy, stone building.\nNorth is a path that weaves through the buildings and into a dense jungle-ish forest.", false, false));
        locations.put(2, new Location(2, "You are standing in a musty smelling pub.\nThere are tables scattered around the room, chairs stacked upon them and there is a counter with shelves of heavy beer mugs behind it.\nYou can also see a box next to the counter.\nEast is the exit back to the plaza.\nWest is the back door of the pub.", false, false));
        locations.put(3, new Location(3, "You are standing in a rough cobbled building.\nThere is a table on one side with papers on it, with a pile of bricks next to it. Across the room, you can see a painting hanging on the cracked white wall.\nWest is the exit back to the plaza.", false, false));
        locations.put(4, new Location(4, "You are standing in what seems like a storage room.\nWest is back through the painting into the cobbled building.\nEast is a wooden plank door that leads outside, based off of the view out the window next to it.", true, false));
        locations.put(5, new Location(5, "After walking down a path that leads you into the jungle and crunching down its gravelly surface, you are standing in front of a river.\nThe water looks like it has a strong current and you see the remains of a bridge that you unfortunately cannot cross.\nThere is no other way to cross.\nSouth is the path back to the previous place.", false, false));
        locations.put(6, new Location(6, "After walking down a path that leads you into the jungle and crunching down its gravelly surface, you are standing in front of a river.\nThe water looks like it has a strong current but there is a rickety bridge that you can use to cross.\nSouth is the path back to the storage room.", false, false));
        locations.put(7, new Location(7, "You are standing over a box full of nails.", true, false));
        locations.put(8, new Location(8, "You are standing in front of door-less cupboards. You can see some packets of mystery jerky and some filled animalskins.", true, false));
        locations.put(9, new Location(9, "You are standing before a painting. It is ls surprisingly large, with a carved frame. It portrays a detailed scene of a rushing river.\nAs you gaze at the painting, you notice a small groove in the wall above the frame. You feel it, and realize that something long and small must go in it.\n", false, true));
        locations.put(10, new Location(10, "You are standing in front of the table. You see many papers and notice scribblings on them. There is an ink pot and a simple quill on the right corner of the table.\nYou wonder if the bricks would ever come in handy, but realize they are too heavy to lug around.", true, false));
    }

    /**
     * Creates exitpoints for each location from where the user can leave a location and also establishes which location the exits leads the user to.
     */
    public static void addExits() {

        locations.get(1).addExit("west", 2);
        locations.get(1).addExit("east", 3);
        locations.get(1).addExit("north", 5);

        locations.get(2).addExit("west", 5);
        locations.get(2).addExit("east", 1);
        locations.get(2).addExit("box", 7);
        locations.get(2).addExit("counter", 8);

        locations.get(3).addExit("west", 1);
        locations.get(3).addExit("painting", 9);
        locations.get(3).addExit("table", 10);

        locations.get(4).addExit("east", 6);
        locations.get(4).addExit("west", 3);

        locations.get(5).addExit("south", 1);

        locations.get(6).addExit("south", 4);

        locations.get(7).addExit("leave", 2);

        locations.get(8).addExit("leave", 2);

        locations.get(9).addExit("leave", 3);
        locations.get(9).addClosedExit("nail", 4);

        locations.get(10).addExit("leave", 3);
    }

//    public static void initializeVocab(){
//
//        vocabulary.put("north", "N");
//        vocabulary.put("south", "S");
//        vocabulary.put("east", "E");
//        vocabulary.put("west", "W");
//        vocabulary.put("quit", "Q");
//        vocabulary.put("inventory", "I");
//
//    }

    /**
     * Creates items in the locations- provides a name, description and a bool indicating whether the player can take it along with them or not.
     */
    public static void createItems() {


//        locations.get(3).addItem("painting", "The painting is ls surprisingly large, with a carved frame. It portrays a detailed scene of a rushing river.", false);

        locations.get(7).addItem("nail", "It is small but long. It has some reddish rust creeping around its edges and is slightly crooked at the end.", true);

        locations.get(8).addItem("animalskin", "You heft the skin, judging that it is all the way full. You take a wiff of it and realize it is sweet apple wine. Your mouth waters involuntarily.", true);
        locations.get(8).addItem("jerky", "These packets have some sort of jerky in it. Your stomach roils as you realize there is no label explaining what the meat even is.", true);

        locations.get(10).addItem("first diary entry", "You pick up a folded paper and unfold it. You see that it is some sort of diary, so you read it. It says:\n\n'September 7---\nWe found the lock to the food storage house nearly ripped apart and some of our meats in the icebox gone today.\nWhile we made an announcement to the village, no one stepped forward to admit guilt.\nUs villagers have gotten suspicious of it, and some think that it was one of us who took it.\nI believe it may have been the butcher's son. He is always getting into some mischief or the other lately.'\n\nYou scrunch your eyebrows together. How could have a person destroyed a padlock like that?", false);
        locations.get(10).addItem("second diary entry", "Paper flutters as you pick up a paper. You set to reading it. It says:\n\n'September 23---\nWe still do not know who or what is taking our meats. We also found half-eaten livestock.\nThe men are thinking that it may be a wolf and agreed on keeping watch tonight to try and catch the beast.\nI do hope that this is fixed soon, because I fear we may run out of meats and cows to sustain ourselves.'\n\nYou feel a sense of foreboding reading the words of the entry and set down the paper gently.", false);
        locations.get(10).addItem("third diary entry", "You grab a paper and begin reading. It says:\n\n'September 24---\nFrederick, Godric, Henrie, and Jaqson are gone.\nThey were they ones watching the food storage house for the beast. The men found deep scratches on the cobble path to the food storage house and patches of grass uprooted.\nHenrie's knife was found broken among the bushes. As I walked to the river to wash the laundry, I saw blood along the path.\nI fear the beast behind the disappearances of my neighbors may be something our small village has never encountered before.'\n\nA chill trickles down your back and you wonder what sort of beast could have done something like this.", false);
        locations.get(10).addItem("fourth diary entry", "Fingers twitching, you reach for a crinkled paper. It says:\n\nOctober 3---\nAll of our meat and livestock is gone. Many of my neighbors have disappeared and now the village is slowly crumbling from the inside.\nWe have all decided to leave, lest we succumb to the great beast haunting our land. While I shall miss the lush forest greens, and the rolling hills, we have no other choice.\nToday is the last day we remain here.'\n\nThe paper crinkles as you grip it too tight. So that's why the village was so deserted.", false);

    }

    /**
     * Creates descriptions for the exits
     */
    public static void exitDescriptions(int loc) {

        switch (loc) {
            case -1:
                System.out.println("You take a quick moment to check your satchel and waistbelt.");
                return;
            case 0:
                System.out.println("You finally decide that you've had your fill of adventure and navigate your way back home.\nA warm tingle spreads down your back as, after weeks, you plod down the lane towards your honest, yet welcoming, cottage.");
                return;
            case 1:
                System.out.println("You hear your boots tap softly on the cobblestone of a lane.");
                return;
            case 2:
                System.out.println("A sign hanging above a building creaks as you head towards it.\nYou push the door furtively and it opens wih a rusty creak.");
                return;
            case 3:
                System.out.println("You grab the big iron handle to the building and pull it open.");
                return;
            case 4:
                System.out.println("You climb through the entrance and land on a hard stone floor.\nThe room is filled with heavy, locked crates and there is a wooden door with a horizontal open slat.");
                return;
            case 5:
            case 6:
                System.out.println("The path gets grittier and bushes now line the sides.\nAs you walk further, you hear the rush and tumble of water ahead.");
                return;
            case 7:
                System.out.println("You approach the box. As you draw closer, you can see how dirty and battered it is.");
                return;
            case 8:
                System.out.println("You stroll towards the counter.\nAfter reaching the front and taking one look at its sticky surface, you decide to walk behind it to check for materials.");
                return;
            case 9:
                System.out.println("You draw closer to the painting to inspect it. You can smell its musty scent as you near it and stroke the chipped frame.");
                return;
            case 10:
                System.out.println("The floarboards creak slightly and you feel them shift while you head to the table.");
                return;
        }
    }

    /**
     * Creates the starting inventory (the user's inventory when they begin the game)
     */
    public static void createInventory() {
        inventory.addItem("waterskin", "A worn plugged sack that you brought from home. It is halfway full of fresh streamwater.");
        inventory.addItem("notebook", "Your old notebook that you brought along with you. You're very excited to preserve your journey in its pages."/*\nTo use, type in 'use notebook*/);
        inventory.addItem("old knife", "Your kitchen knife from home may not be as sharp as it used to be, but at least it's better than nothing.");
        inventory.addItem("apples", "You plucked these juicy red apples from an old apple tree a while back and you can't wait to sink your teeth into their flesh.");
        inventory.addItem("cheese", "This cheese was hand-made from your goat's milk. It's hardy and will last for months.");
        inventory.addItem("crackers", "They're as tough as nails and you almost broke your teeth on them, but they have sustained you for a while and will never spoil.");
    }

    /**
     * Takes in the user's input, makes sure it is valid, then returns the input (if valid) in all lowercase
     *
     * @param loc
     * @return
     */
    public static String getCommand(int loc) {
        Location l = locations.get(loc);
        while (true) {
            System.out.println("Enter a command:");
            String command = scanner.nextLine();


            A:
            if (l.getHasClosedExits()) {
                Map<String, Integer> closedExits = l.getClosedExits();
                String[] parts = command.split(" ");
                if (parts.length < 2) {
                    break A;
                }
                loc = closedExits.get(parts[1]);
                for (Map.Entry mapElement : closedExits.entrySet()) {
                    String key = (String) mapElement.getKey();
                    if (parts[1].equalsIgnoreCase(key)) {
                        boolean closedExitExists = l.getClosedExits().containsKey(parts[1].toLowerCase());
                        if (parts.length < 2) {
                            closedExitExists = l.getClosedExits().containsKey(parts[0].toLowerCase());
                        }
                        if (closedExitExists && parts[0].equals("use")) {
                            return command.toLowerCase();
                        }
                    }
                }
            }

            boolean exitExists = l.getExits().containsKey(command.toLowerCase());
            if (exitExists) {
                return command.toLowerCase();
            }

            boolean itemExists = l.getItems().containsKey(command.toLowerCase());
            if (itemExists) {
                return command.toLowerCase();
            }

            System.out.println("Invalid input. Please try again.\n");
        }
    }

    /**
     * Checks to see if a valid command is an indication to an exit, or an item.
     *
     * @param command
     * @param loc
     * @return
     */
    public static String isExitOrItem(String command, int loc) {
        if (locations.get(loc).getExits().containsKey(command)) {
            return "e";
        } else if (locations.get(loc).getItems().containsKey(command)) {
            return "i";
        }

        return "ce";
    }

    /**
     * returns a location the user can exit to.
     *
     * @param loc
     * @return
     */
    public static int getExit(int loc) {
        Location l = locations.get(loc);

        if (l.getHasClosedExits()) {
            for (String s : l.getClosedExits().keySet()) {
                if (inventory.containsItem(s)) {
                    return l.getClosedExits().get(s);
                }
            }
        }

        return loc;
    }

    public static String getKey(Map<String, Integer> map, Integer value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Displays only the items in the user's inventory.
     */
    public static void showInventory() {
        for (String item : inventory.getItems().keySet()) {
            System.out.println(".\n" + item);
        }
    }

    /**
     * Checks the input of the user. If it is the name of an inventory item, returns the input as it is.
     * If the input is "remove ~item~" then returns "remove".
     * If the input is 'exit', then it returns 'exit'.
     * If the input is not an item name or 'exit', then it returns 'invalid'.
     *
     * @param command
     * @return
     */
    public static String evaluateDescription(String command) {
        for (String item : inventory.getItems().keySet()) {
            if (command.toLowerCase().equals(item.toLowerCase())) {
                return command;
            } else if (command.equalsIgnoreCase("leave")) {
                return "leave";
            } else if(command.equalsIgnoreCase("remove "+ item)){
                return "remove";
            }
        }

        return "invalid";
    }

    /**
     * Operates the inventory.
     * - Shows inventory
     * - shows item description if requested
     * - removes items if requested
     */
    public static void useInventory() {
        showInventory();

        while (true) {
            System.out.println("If you would like to see the description of any item in your inventory, then enter its name.\nIf you would like to remove an item, type 'remove ' then the item name.\n**Be careful and think twice about removing an item, because there will be no getting it back unless you go back to its source.\nIf you would like to leave the inventory, then enter 'leave'.");
            String command = scanner.nextLine();

            String command2 = evaluateDescription(command);

            if (command2.equalsIgnoreCase("invalid")) {
                System.out.println("Invalid command. Please try again.");
                System.out.println();
            } else if (command2.equalsIgnoreCase("leave")) {
                break;
            } else if (command2.equalsIgnoreCase("remove")){
                String[] parts= command.split(" ");
                inventory.removeItem(parts[1]);
                break;
            }

            System.out.println(inventory.getItems().get(command));
            System.out.println();
        }
    }

    /**
     * Operates the game from when the user types in "yes" for the intro input.
     */
    public static void gameLoop() {

        int loc = 1;
        int prevLoc = 0;
//        initializeVocab();

        while (true) {

            Location l = locations.get(loc);
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(l.getDescription());

            if (loc == 0) {
                break;
            } else if (loc == -1) {
                useInventory();
                loc = prevLoc;
                continue;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Possible exits: ");
            int count = 1;
            // loops through possible exits and prints them out for the user to read and choose
            if (l.getHasClosedExits() && count < 2) {
                Map<String, Integer> closedExits = locations.get(loc).getClosedExits();
                for (String itemNeeded : closedExits.keySet()) {
                    if (inventory.containsItem(itemNeeded)) {
                        System.out.print("use " + getKey(l.getClosedExits(), l.getClosedExits().get(itemNeeded)) + ", ");
                    }

                    break;
                }
            }
            for (String exitKey : exits.keySet()) {
                if (count >= exits.keySet().size()) {
                    System.out.print("and " + exitKey + "\n");
                } else {
                    System.out.print(exitKey + ", ");
                }

                count++;
            }

            if (l.getHasItems()) {
                Map<String, Item> items = locations.get(loc).getItems();
                System.out.print("Possible items: ");
                count = 1;
                // if the location contains items, loops through the items and prints them out fo the reader to read and use
                for (String s : items.keySet()) {
                    if (l.getHasClosedExits()) {
                        System.out.print("use " + getKey(l.getClosedExits(), l.getClosedExits().get(s)) + ", ");
                    } else if (count >= items.size()) {
                        System.out.print("and " + s + "\n");
                    } else {
                        System.out.print(s + ", ");
                    }

                    count++;
                }
            }
            System.out.println();

//            prevLoc= loc;
            String command = getCommand(loc);

            System.out.println(".");
            System.out.println(".");
            System.out.println(".");

            if (command.equals("quit")) {
//                prevLoc= loc;
                loc = 0;
            } else if (command.equals("inventory")) {
                prevLoc = loc;
                loc = -1;
            } else if (loc == 5) {
                loc = prevLoc == 2 ? 2 : 1;
            } else if (command.equals("exit")) {
                loc = prevLoc;
                continue;
            } else {
                prevLoc = loc;

                String exitOrItem = isExitOrItem(command, loc);
                if (exitOrItem.equals("e")) {
                    loc = exits.get(command);
                } else if (exitOrItem.equals("ce")) {
                    Map<String, Integer> closedExits = l.getClosedExits();
                    String[] parts = command.split(" ");
                    loc = closedExits.get(parts[1]);
                    for (Map.Entry mapElement : closedExits.entrySet()) {
                        String key = (String) mapElement.getKey();
                        if (command.equalsIgnoreCase(key)) {
                            loc = closedExits.get(key);
                        }
                    }
                } else {
                    Map<String, Item> items = l.getItems();
                    int index = 0;
                    for (String s : items.keySet()) {
                        if (command.equals(s)) {
                            if (items.get(s).getTakeable()) {
                                // check to see if the item the user wants is already in the inventory or not. if so, then tell the user and do not add it. if yes, then add it.
                                if (inventory.getItems().size() > 20) {
                                    System.out.println("Your inventory is full! You must get rid of something before adding another item.");
                                }
                                if (!(inventory.containsItem(s))) {
                                    inventory.addItem(s, items.get(s).getDescription());
                                    System.out.println("You grab " + s.toLowerCase() + " and stash it away on your person.");
                                } else {
                                    System.out.println("This item is already in your inventory.");
                                }
                            } else {
                                System.out.println(items.get(s).getDescription());
                            }
                        }

                        index++;
                    }

                    continue;
                }
            }

//                exitDescriptions(loc);
        }
    }
}