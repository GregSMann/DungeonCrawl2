/** World.java
 * Holds information and methods necessary for managing the overall world-state of the game.
 * @author 240Group GMJ
 * @version 1.0
 */

public class World {

    String[] map1=

            {"##################                ######################    ",
            "##              ##                ##      i           ##    ",
            "##  @           ###########       ##        *         ##    ",
            "##                       ##       ##                  ##    ",
            "##              #######  ##       ##################  ##    ",
            "##              ##   ##  ##                       ##  ##    ",
            "##################   ##  ##################       ##  ##    ",
            "                     ##                  ##       ##  ##    ",
            "                     ##   *  i           ##       ##  ##    ",
            "                     ##                  ##       ##  ##    ",
            "                     ##############  ######       ##  ##    ",
            "                                 ##  ##           ##  ##    ",
            "                                 ##  ##           ##  ##    ",
            "                       ############  ###############  ######",
            "                       ##                                 ##",
            "                       ##                                 ##",
            "    #####################                  *              ##",
            "    ##                                                  0 ##",
            "    ##  #################                                 ##",
            "    ##  ##             ##                                 ##",
            "    ##  ##             #################  ##################",
            "    ##  ##                            ##  ##                ",
            "    ##  ##                            ##  ##                ",
            "    ##  ##                       #######  #######           ",
            "    ##  ##                       ##            ##           ",
            "######  ####                     ##  i  *      ##           ",
            "##        ##                     ##            ##           ",
            "## i  *   ##                     ################           ",
            "##        ##                                                ",
            "############                                                "
    };
    String[] map2= {
            "##################                ######################    ",
            "##              ##                ##      i           ##    ",
            "##  @           ####################        *         ##    ",
            "##                                                    ##    ",
            "##              ####################################  ##    ",
            "##              ##                                ##  ##    ",
            "##################   ######################       ##  ##    ",
            "    ###################                  ##       ##  ##    ",
            "    ##                    *  i           ##       ##  ##    ",
            "    ##    i       #####                  ##       ##  ##    ",
            "    ##            ## ##############  ######       ##  ##    ",
            "    ##            ##             ##  ##           ##  ##    ",
            "    ##            ##             ##  ##           ##  ##    ",
            "    ##        *   ##   ############  ###############  ######",
            "    #######  #######   ##                                 ##",
            "         ##  ##        ##                                 ##",
            "    #######  ############                  *              ##",
            "    ##                                                    ##",
            "    ##  #################                                 ##",
            "    ##  ##             ##                                 ##",
            "    ##  ##             #################  ##################",
            "    ##  ##                            ##  ##                ",
            "    ##  ##                            ##  ##                ",
            "    ##  ##                       #######  #######           ",
            "    ##  ##                       ##            ##           ",
            "######  ####                     ##  i  *      ##           ",
            "##        ##                     ##            ##           ",
            "## i  *   ##                     ################           ",
            "##   O    ##                                                ",
            "############                                                "
    };
    String[] map3= {
            "               ####################                         ",
            "               ##                ##                         ",
            "               ##                ##                         ",
            "               ##        B       ##                         ",
            "               ##                ##                         ",
            "               ##                ##                         ",
            "               #########  #########                         ",
            "                      ##  ##                                ",
            "                      ##  ##                                ",
            "                      ##  ##                                ",
            "                   #####  ###########                       ",
            "                   ##         i    ##                       ",
            "                   ##     *        ##                       ",
            "                   ##  ##############                       ",
            "                   ##  ##                                   ",
            "                   ##  ##                                   ",
            "    #################  ##                                   ",
            "    ##     *           ##                                   ",
            "    ##  #################                                   ",
            "    ##  ##                                                  ",
            "    ##  ##                                                  ",
            "    ##  ##                                                  ",
            "    ##  ##                                                  ",
            "    ##  ##                                                  ",
            "    ##  ##                                                  ",
            "######  ####                                                ",
            "##        ##                                                ",
            "##    @   ##                                                ",
            "##        ##                                                ",
            "############                                                "
    };
    Room currentRoom=new Room(map1, worldDifficulty.Easy);

    Room finalRoom = new Room(map3, worldDifficulty.Hard);
    Room secondRoom= new Room(map2, worldDifficulty.Normal);


    /** setCurrentRoom method
     * Sets the designated room as the current room for the purpose of difficulty assignment
     * @param room The room the player is currently inside.
     */
    public void setCurrentRoom(Room room){
        this.currentRoom=room;
    }

    /**
     * Returns the current room to be used in decision making elsewhere
     * @return Returns the current room variable.
     */
    public Room getCurrentRoom(){ return this.currentRoom; }


    public Room createNewRoom(String difficulty) {
	    if (difficulty.equals("Easy")) {
		    Room newRoom = new Room(map1, worldDifficulty.Easy);
		    return newRoom;
	    } else if (difficulty.equals("Normal")) {
		    Room newRoom = new Room(map2, worldDifficulty.Normal);
		    return newRoom;
	    } else if (difficulty.equals("Hard")) {
		    Room newRoom = new Room(map3, worldDifficulty.Hard);
		    return newRoom;
	    } else {
		    return null;
	    }
    }
    }
