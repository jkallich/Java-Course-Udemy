import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final boolean hasClosedExits;
    private final Map<String, Integer> closedExits;
    private final Map<String, Integer> exits;
//    private ArrayList<Item> items;
    private final boolean hasItems;
    private final Map<String, Item> items;

    public Location(int locationID, String description, boolean hasItems, boolean hasClosedExits) {
        this.locationID = locationID;
        this.description = description;
        this.hasClosedExits= hasClosedExits;
        this.closedExits= new HashMap<>();
        closedExits.put("quit", 0);
        closedExits.put("inventory", -1);
        this.exits= new HashMap<>();
        this.exits.put("quit", 0);
        this.exits.put("inventory", -1);
//        this.items= new ArrayList<>();
        this.hasItems= hasItems;
        this.items= new HashMap<>();
    }

    public void addClosedExit(String itemNeeded, int location){
        closedExits.put(itemNeeded, location);
    }

    public void addExit(String direction, int location){
        exits.put(direction, location);
    }

    public void addItem(String name, String description, boolean takeable){
//        items.add(new Item(name, description, takeable));
        items.put(name, new Item(name, description, takeable));
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public boolean getHasClosedExits(){
        return hasClosedExits;
    }

    public Map<String, Integer> getClosedExits(){
        return new HashMap<String, Integer>(closedExits);
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    public boolean getHasItems() {
        return hasItems;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
