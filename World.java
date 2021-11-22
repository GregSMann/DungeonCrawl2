public class World {
    String[] map1=

            {  "##################              ######################    ",
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
                "               ####################                        ",
                "               ##                ##                        ",
                "               ##                ##                        ",
                "               ##        B       ##                        ",
                "               ##                ##                        ",
                "               ##                ##                        ",
                "               #########  #########                        ",
                "                      ##  ##                               ",
                "                      ##  ##                               ",
                "                      ##  ##                               ",
                "                   #####  ###########                      ",
                "                   ##         i    ##                      ",
                "                   ##     *        ##                      ",
                "                   ##  ##############                      ",
                "                   ##  ##                                  ",
                "                   ##  ##                                  ",
                "    #################  ##                                  ",
                "    ##     *           ##                                  ",
                "    ##  #################                                  ",
                "    ##  ##                                                 ",
                "    ##  ##                                                 ",
                "    ##  ##                                                 ",
                "    ##  ##                                                 ",
                "    ##  ##                                                 ",
                "    ##  ##                                                 ",
                "######  ####                                               ",
                "##        ##                                               ",
                "##    @   ##                                               ",
                "##        ##                                                ",
                "############                                                "
    };
    Room currentRoom=null;

    Room finalRoom = new Room(map3, worldDifficulty.Hard);
    Room firstRoom= new Room(map1, worldDifficulty.Easy);
    Room secondRoom= new Room(map2, worldDifficulty.Normal);
    public void setCurrentRoom(Room room){
        currentRoom=room;
    }
    public Room getCurrentRoom(){ return this.currentRoom; }
}
