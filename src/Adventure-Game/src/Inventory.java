import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, String> items;

    public Inventory() {
        this.items= new HashMap<>();
    }

    public void addItem(String item, String description){
        items.put(item, description);
    }

    public void removeItem(String item){
        items.remove(item);
    }

    public Map<String, String> getItems() {
        return items;
    }

    public boolean containsItem(String item){
        for(String s : items.keySet()){
            if(item.equalsIgnoreCase(s)){
                return true;
            }
        }

        return false;
    }
}
