/**Item generator.java
 * Generates and returns an item for use in the playable component of the game.
 * @author 240Group GMJ
 * @version 1.0
 */
// ItemGenerator.java
// this class contains a static method for creating items randomly


import java.util.Random;

public class ItemGenerator {
    /**
     * Generates a new item based on the room difficulty allowing for an increase in power in each room.
     * @param room The room the player is currently in
     * @return An Item suitable for the power level of that room.
     */
    public static Item generate(Room room) {
        // TODO: replace this with your own code
        Item genItem=new Item(ItemType.Other, "Dull Vase", 1,1,0);
        // TODO: replace this with your own code!
        if (room.getWorldDifficulty() == worldDifficulty.Easy) {


            int b = (int) (Math.random() * (4 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genItem=new Item(ItemType.Weapon, "Enchanted sword", 5, 10, 10);
                    break;
                case 2:
                    genItem=new Item(ItemType.Armor, "Mythril Plate", 10, 10, 5);
                    break;
                case 3:
                    genItem=new Item(ItemType.Other, "Golden coin", 1, 20, 0);
                    break;

                case 4:
                    genItem=new Item(ItemType.Healing, "Weak Potion", 1, 30, 10);
                    break;
            }
        }
        if (room.getWorldDifficulty()==worldDifficulty.Normal) {

            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genItem=new Item(ItemType.Weapon, "Divine Sword", 5, 40, 15);
                    break;
                case 2:
                    genItem=new Item(ItemType.Other, "Mystic Medallion", 1, 80, 0);
                    break;
                case 3:
                    genItem=new Item(ItemType.Armor, "Mage Armor", 2, 60, 9);

                    break;
                case 4:
                    genItem=new Item(ItemType.Healing, "Health Potion", 2, 70, 20);
                    break;
            }

        }if (room.getWorldDifficulty()==worldDifficulty.Hard) {

            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genItem=new Item(ItemType.Other, "Golden Idol", 5, 200, 0);

                    break;
                case 2:
                    genItem=new Item(ItemType.Weapon, "Master Sword", 1, 20, 30);

                    break;
                case 3:
                    genItem=new Item(ItemType.Other, "Mjolnir Armor", 1, 20, 15);

                    break;
                case 4:
                    genItem=new Item(ItemType.Healing, "Hyper Potion", 1, 20, 150);
                    break;
            }

        }
        return genItem;
    }

    }


