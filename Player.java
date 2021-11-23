// Player.java

import ansi_terminal.*;

public class Player extends Character {
    private Inventory items;
    Room currentRoom=null;

    public Player(Position start) {
        // our starting details
        super(start.getRow(), start.getCol(), '@', Color.CYAN, 50);

        // we can carry 100 pounds of items
        items = new Inventory(100);

       
        // TODO 
        // changed the starting gear to something different 
        items.addAndEquip(new Item(ItemType.Weapon, "Flame Sword", 5, 12, 7));
        items.addAndEquip(new Item(ItemType.Armor, "Flame Armor", 15, 20, 3));
        items.addAndEquip(new Item(ItemType.Other,"Shiny Rock", 1, 1, 1));
        //end
        
    }

    @Override
    public int getDamage() {
        Item weapon = items.getEquippedWeapon();
        if (weapon != null) {
            return weapon.getStrength();
        } else {
            // if we have no weapon, our fists are pretty weak...
            return 1;
        }
    }

    @Override
    public String getName() {
        return "Player";
    }

    @Override
    public int getProtection() {
        Item armor = items.getEquippedArmor();
        if (armor != null) {
            return armor.getStrength();
        } else {
            // without armor, we have no protection
            return 0;
        }
    }

    public Inventory getInventory() {
        return items;
    }

}

