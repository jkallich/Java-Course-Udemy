public class Item {

    private final String name;
    private final String description;
    private final boolean takeable;

    public Item(String name, String description, boolean takeable) {
        this.name = name;
        this.description = description;
        this.takeable = takeable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getTakeable() { return takeable; }
}
