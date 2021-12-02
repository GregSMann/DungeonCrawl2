// Room.java
// provides code for the drawing of a room
// also provides starting locations for the player, boxes, and enemies

import java.util.ArrayList;
import ansi_terminal.*;

public class Room {
    private worldDifficulty worldDifficulty;
    // the grid holds the room geometry
    private String[] grid;
    // the size of the room
    private int rows;
    private int cols;

    public Room(String[] layout, worldDifficulty difficulty) {
        // this initializes the room to one specific space
        rows = 30;
        cols = 60;
        this.worldDifficulty=difficulty;
        // the actual room geometry
        // the i cells refer to where an item should be placed at
        grid  = layout;
    }


    // returns the player's strting location in this room
    public Position getPlayerStart() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == '@') {
                    return new Position(row, col);
                }
            }
        }

        return null;
    }

    // returns a set of item boxes for this map, this is here because it depends on
    // the room geometry for where the boxes make sense to be
    public ArrayList<Box> getBoxes(Room currentRoom) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == 'i') {
                    boxes.add(new Box(row, col, ItemGenerator.generate(currentRoom)));
                }
            }
        }

        return boxes;
    }

    // returns a set of enemies from this map, similarly to the boxes above
    public ArrayList<Enemy> getEnemies(Room currentRoom) {

        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == '*') {
                    enemies.add(EnemyGenerator.generate(row, col, currentRoom));
                }
            }
        }

        return enemies;
    }

    /**
     * Parses the map layout and then returns an array list of every portal present in the map, a portal contains it's position on the layout, and the room it takes you to.
     * @return Arraylist of all portals in the layout.
     */
    public ArrayList<Portal> getPortals() {
        World world=new World();
        ArrayList<Portal> portals = new ArrayList<Portal>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == '0') {
                    portals.add(new Portal(row, col, world.secondRoom));
                }else if(grid[row].charAt(col) =='O'){
                    portals.add(new Portal(row, col, world.finalRoom));

                }
            }
        }

        return portals ;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    // draws the map to the screen
    public void draw() {
        Terminal.clear();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = grid[row].charAt(col);
                if (cell == '#') {
                    // a unicode block symbol
                    System.out.print('\u2588');
                } else {
                    // whatever else, just draw a blank (we DONT draw starting items from map)
                    System.out.print(' ');
                }
            }

            System.out.print("\n\r");
        }
    }

    /**
     * Returns the Current Rooms World Difficulty
     * @return The worldDifficulty of the current room in string format.
     */
    public worldDifficulty getWorldDifficulty() {
        return this.worldDifficulty;
    }
    //Make this return a string rather than printing inside method, Otherwise Java get angry.
    public String printWorldDifficulty() {
String response="";
        if (this.worldDifficulty==worldDifficulty.Easy){
            response="Easy";
            System.out.println("Easy");

        }else if(this.worldDifficulty== worldDifficulty.Normal){
            response="Normal";
            System.out.println("Normal");
        }else if(this.worldDifficulty== worldDifficulty.Hard){
            response="Hard";
            System.out.println("Hard");

        }
     return response;
    }

    public String[] getGrid(){
        return this.grid;
    }

    // returns if a given cell in the map is walkable or not
    public boolean canGo(int row, int col) {
        return grid[row].charAt(col) != '#';
    }
    }




