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
    private String playerName1;
    private int playerAge1;
    private String saveExt;
    private String loadExt;

    public Game() {
	world = new World();
	Scanner input = new Scanner(System.in);
        
	// Gets name and age of player
	Terminal.cookedMode(); 
        System.out.println("You have been transported into the world of Fantasia. This world is not like the world you are accustomed to, as this world has creatures that do not exist in the world you come from. There are goblins, orksm and Ogres that lurk here. They terrorize the innocent people that live here. You need to defeat these creatures that live in this dungeon to help the people of Fantasia. You are the hero that they have been waiting for! Beat the Ogre boss and aid the people of Fantasia!\nWhat is your name Good Hero?: ");
        playerName1 = input.nextLine();

        System.out.println("What is your age?");
        playerAge1 = input.nextInt();
	Terminal.rawMode();
        room = world.currentRoom;
        player = new Player(room.getPlayerStart());
        boxes = room.getBoxes(world.currentRoom);
        enemies = room.getEnemies(world.currentRoom);
        portals = room.getPortals();
    }
    
    //Game Constructor to load a saved game
    public Game(Scanner in){
    	playerName1 = in.nextLine();
	playerAge1 = in.nextInt();

    }  
 
    // prints a help menu to the left of the map
    private void showHelp() {
        String[] cmds = {"Commands:",
                         "---------",
                         "Move: Arrow Keys",
                         "Pickup an item: p",
                         "Drop an item: d",
                         "List items: i",
                         "Equip weapon: w",
                         "Equip armor: a",
                         "Use Item: u",
                         "Quit: q",
                         "Enter Portal: e",
                         "Save: s",
			 "Load a Game: l"
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

    /**
     * Checks the position under you for a portal, if there is a portal, it sets the current room to the destination room, then reinitilizes the room, checking boxes, enemies, and portals, before removing the old portal and redrawing the map.
     */
    private void enter(){
        Portal door = checkForPortal();
        if (door == null){
            setStatus("There isn't a portal here!");
        }else{
            portals.remove(door);
            world.setCurrentRoom(door.destinationRoom);
            room=world.currentRoom;
            enemies= room.getEnemies(world.currentRoom);
            boxes=room.getBoxes(world.currentRoom);
            portals=room.getPortals();
            redrawMapAndHelp();

        }
    }
    //method to save the game info into a file
    /**
     *Method to save the game's informtaion
     @param PrintWriter
     @return void
     */
    public void save(PrintWriter pw){
    	pw.println(playerName1);
	pw.println(playerAge1);
	pw.println(player.getHealth());
	pw.println(player.getRow());
	pw.println(player.getCol());
	pw.println(room.getWorldDifficulty());
	
          for (Enemy i : enemies){
                  pw.println(i.getName());
                  pw.println(i.getHealth());
                  pw.println(i.getRow());
                  pw.println(i.getCol());
        
          }
        //pw.println();
        pw.println(player.getInventory().printItems());
	

    
   }
   /**
    *Method to load in a previously saved game. Uses a saved text file with saved speceific information to generate a game
   @return void 
    *
    */
   //Method code to load a saved game
   public void load(){
   	
   
   
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
    /**
     *Method to handle pressed key inputs
     @param Key
     @return boolean
     */
    private boolean handleKey(Key key) {
        switch (key) {
//need to place the save method into case s
   	    //case s:
          //      try{
			//PrintWriter pw = new PrintWriter(new File("save.txt"));
              //      Game.save(pw);
			//pw.close();
		//}catch (FileNotFountException e){
		//	System.out.print("Ay Yo That Aint Saved Ya Dig!");
	//	}
            case e:
                enter();
            break;
            case p:
                pickup();
                break;

            case i:
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
            //save key
	    case s:
		Scanner sc = new Scanner(System.in);
		Terminal.cookedMode();
		System.out.print("Enter a name for this save file: ");
		saveExt = sc.nextLine();
		try{
			PrintWriter pw = new PrintWriter(new File("saves/save" + saveExt + ".txt"));
			save(pw);
			pw.close();
			
			Terminal.rawMode();
			System.out.println("Press any Key to Return");

		}catch (FileNotFoundException e) {
			System.out.println("Failed to save file!");
			Terminal.rawMode();
		}
	    //key to load a game " not completed"
	    case l:
	       Scanner scanner = new Scanner(System.in);
	       Terminal.cookedMode();
	       System.out.print("Enter the name of the save file you want to load: ");
	       loadExt = scanner.nextLine();
	       try {
		       Scanner in = new Scanner(new File("saves/save" + loadExt + ".txt"));
		       Game loadedGame = new Game(in);
		       Terminal.rawMode();
	       
	       }catch (FileNotFoundException d){
		       System.out.println("Failed to load");
		       Terminal.rawMode();
		       
	       }

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

    /**
     * Checks the current position for a portal, if there is a portal there it returns it, if not it returns a null value.
     * @return Portal or Null depending on player position.
     */
    private Portal checkForPortal() {
        Position playerLocation = player.getPosition();

        for (Portal portal : portals) {
            if (playerLocation.equals(portal.getPosition())) {
                return portal;
            }
        }

        return null;
    }
    /**
     *Method to run the game
     @param void
     */
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
            for (Portal portal : portals) {
                portal.draw();
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

