// ItemGenerator.java
// this class contains a static method for creating items randomly


import java.util.Random;

public class ItemGenerator {
    public static Item generate(Room room) {
        // TODO: replace this with your own code
        Item genItem=new Item(ItemType.Other, "Vase", 1,1,0);
        // TODO: replace this with your own code!
        if (room.getWorldDifficulty() == worldDifficulty.Easy) {


            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genItem=new Item(ItemType.Weapon, "Enchanted sword", 5, 10, 5);
                    break;
                case 2:
                    genItem=new Item(ItemType.Armor, "Mythril Steel Plate", 10, 10, 5);
                    break;
                case 3:
                    genItem=new Item(ItemType.Other, "Golden coin", 1, 20, 0);
                    break;


            }
        }
        if (room.getWorldDifficulty()==worldDifficulty.Normal) {

            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genItem=new Item(ItemType.Weapon, "Sword of Epic Monster Slaying", 5, 40, 10);
                    break;
                case 2:
                    genItem=new Item(ItemType.Other, "Mystic Medallion", 1, 80, 0);
                    break;
                case 3:
                    genItem=new Item(ItemType.Armor, "Mage Armor Marker", 2, 60, 9);

                    break;

            }

        }if (room.getWorldDifficulty()==worldDifficulty.Hard) {

            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genItem=new Item(ItemType.Other, "Golden Idol", 5, 200, 0);

                    break;
                case 2:
                    genItem=new Item(ItemType.Weapon, "Sword of One Thousand Truths", 1, 20, 30);

                    break;
                case 3:
                    genItem=new Item(ItemType.Other, "Armor of the Last Bastion", 1, 20, 15);

                    break;
            }

        }
        return genItem;
    }

    }


