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
    Room currentRoom=new Room(map1, worldDifficulty.Easy);

    Room finalRoom = new Room(map3, worldDifficulty.Hard);
    Room secondRoom= new Room(map2, worldDifficulty.Normal);

    public void setCurrentRoom(Room room){
        this.currentRoom=room;
    }

    public Room getCurrentRoom(){ return this.currentRoom; }
    }


