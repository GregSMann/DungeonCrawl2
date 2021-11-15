// ItemGenerator.java
// this class contains a static method for creating items randomly

import java.util.Random;

public class ItemGenerator {
    public static Item generate() {
        // TODO: replace this with your own code!
        Item genItem = new Item(ItemType.Other, "Vase", 10, 2, 0);
        return genItem;
    }
}

