// Game.java
// contains logic for running the Game
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import ansi_terminal.*;

public class Game {
    private World world;
    private Room room;
    private Player player;
    private ArrayList<Box> boxes;
    private ArrayList<Enemy> enemies;
    private ArrayList<Portal> portals;

    public Game() {
	world = new World();
	Scanner input = new Scanner(System.in);
        
	// Gets name and age of player
	Terminal.cookedMode(); 
        System.out.println("You have been transported into the world of Fantasia. This world is not like the world you are accustomed to, as this world has creatures that do not exist in the world you come from. There are goblins, orksm and Ogres that lurk here. They terrorize the innocent people that live here. You need to defeat these creatures that live in this dungeon to help the people of Fantasia. You are the hero that they have been waiting for! Beat the Ogre boss and aid the people of Fantasia!\nWhat is your name Good Hero?: ");
        String playerName1 = input.nextLine();

        System.out.println("What is your age?");
        int playerAge1 = input.nextInt();
	Terminal.rawMode();
        room = world.currentRoom;
        player = new Player(room.getPlayerStart());
        boxes = room.getBoxes(world.currentRoom);
        enemies = room.getEnemies(world.currentRoom);
        portals = room.getPortals();
    }
    
 
    // prints a help menu to the left of the map
    private void showHelp() {
        String[] cmds = {"Commands:",
                         "---------",
                         "Move: Arrow Keys",
                         "Pickup an item: p",
                         "Drop an item: d",
                         "List items: l",
                         "Equip weapon: w",
                         "Equip armor: a",
                         "Use Item: u",
                         "Quit: q",
                         "Enter Portal: e",
                         "Save: s"
        };
        Terminal.setForeground(Color.GREEN);
        for (int row = 0; row < cmds.length; row++) {
            Terminal.warpCursor(row + 1, room.getCols());
            System.out.print(cmds[row]);
        }
        Terminal.reset();
    }

    // right under the map we keep a line for status messages
    private void setStatus(String mesg) {
        // clear anything old first
        Terminal.warpCursor(room.getRows(), 0);
        for (int i = 0; i < 100; i++) {
            System.out.print(" ");
        }

        // then print the message
        Terminal.warpCursor(room.getRows(), 0);
        System.out.print(mesg);
    }

    // code for when the player tries to pickup an item
    private void pickup() {
        Box thing = checkForBox();
        if (thing == null) {
            setStatus("There is nothing here to pick up...");
            Terminal.pause(1.25);
        } else {
            if (player.getInventory().add(thing.getItem())) {
                setStatus("You added the " + thing.getItem().getName() + " to your inventory.");
                boxes.remove(thing);
            } else {
                setStatus("This is too large for you to add!");
            }
            Terminal.pause(1.25);
        }
    }
    private void enter(){
        Portal door = checkForPortal();
        if (door == null){
            setStatus("There isn't a portal here!");
        }else{
            world.setCurrentRoom(door.destinationRoom);
            redrawMapAndHelp();

        }
    }
    //method to save the game info into a file
    public void save(PrintWriter pw){
    	//pw.println(playerName1);
	//pw.println(playerAge1);
	pw.println(player.getHealth());
	pw.println(player.getRow());
	pw.println(player.getCol());
	//pw.println(World.getRoom());
	

    
    }
    // code for when the player tries to drop an item
    private void drop() {
        if (checkForBox() == null) {
            Item dropped = player.getInventory().drop();
            if (dropped != null) {
                boxes.add(new Box(player.getRow(), player.getCol(), dropped));
            }
            redrawMapAndHelp();
        } else {
            setStatus("You cannot drop something on an existing item...");
            Terminal.pause(1.25);
        }
    }

    // handle the key which was read - return false if we quit the game
    private boolean handleKey(Key key) {
        switch (key) {
//need to place the save method into case s
   	   // case s:
               // try{
		//	PrintWriter pw = new PrintWriter(new File("save.txt"));
		//	Game.save(pw);
		//	pw.close();
		//}catch (FileNotFountException e){
		//	System.out.print("Ay Yo That Aint Saved Ya Dig!");
		//}
		
            case p:
                pickup();
                break;

            case l:
                player.getInventory().print();
                redrawMapAndHelp();
                break;

            case d:
                drop();
                break;

            case w:
                player.getInventory().equipWeapon();
                redrawMapAndHelp();
                break;

            case a:
                player.getInventory().equipArmor();
                redrawMapAndHelp();
                break;
            case u:
                player.getInventory().useItem(player);
                redrawMapAndHelp();
                break;
            // handle movement
            case LEFT: player.move(0, -1, room);
                break;
            case RIGHT: player.move(0, 1, room);
                break;
            case UP: player.move(-1, 0, room);
                break;
            case DOWN: player.move(1, 0, room);
                break;

            // and finally the quit command
            case q:
                return false;
        }

        return true;
    }

    // this is called when we need to redraw the room and help menu
    // this happens after going into a menu like for choosing items
    private void redrawMapAndHelp() {
        room.draw();
        showHelp();
    }

    // returns a Box if the player is on it -- otherwise null
    private Box checkForBox() {
        Position playerLocation = player.getPosition();

        for (Box box : boxes) {
            if (playerLocation.equals(box.getPosition())) {
                return box;
            }
        }

        return null;
    }

    // check for battles and return false if player has died
    private boolean checkBattles() {
        Position playerLocation = player.getPosition();

        // look for an enemy that is close
        Enemy opponent = null;
        for (Enemy enemy : enemies) {
            if (playerLocation.isAdjacent(enemy.getPosition())) {
                opponent = enemy;
            }
        }

        // now do the battle
        if (opponent != null) {
            opponent.setBattleActive();
            return player.fight(opponent, room, enemies);
        }

        return true;
    }
    private Portal checkForPortal() {
        Position playerLocation = player.getPosition();

        for (Portal portal : portals) {
            if (playerLocation.equals(portal.getPosition())) {
                return portal;
            }
        }

        return null;
    }

    public void run() {
        // draw these for the first time now
        redrawMapAndHelp();

        boolean playing = true;
        while (playing) {
            // draw the entities
            for (Box box : boxes) {
                box.draw();
            }
            for (Enemy enemy : enemies) {
                enemy.draw();
            }
            player.draw();

            // read a key from the user
            Terminal.warpCursor(room.getRows() + 1, 0);
            Key key = Terminal.getKey();
            playing = handleKey(key);

            // clear status by default
            setStatus("");

            // move the enemies
            for (Enemy enemy : enemies) {
                enemy.walk(room);
            }

            // check for battles
            if (checkBattles() == false) {
                setStatus("You have been killed :(\n\r");
                playing = false;
            }

            // check if we are on a box and print what's in it
            Box thingHere = checkForBox();
            if (thingHere != null) {
                setStatus("Here you find: " + thingHere.getItem().getName());
            }
            Portal checkPortal=checkForPortal();
            if (checkPortal != null){
                setStatus("There is a portal here! Go through it if you dare!");
            }

        }
    }
}

