/** Portal.java
 * Extends the entity object adding variables that determine the room the portal will send the player to.
 * @author 240 Group GMJ
 * @version 1.0
 */

import ansi_terminal.Color;

public class Portal extends Entity{
    Room destinationRoom;
    Position pos;

    /**
     * Generates the new portal
     * @param r Contains the Row in the position value of the portal.
     * @param c Containcs the Column for the position value of the portal
     * @param destinationRoom Contains the destination room that the Player should be transported to.
     */
    public Portal(int r, int c, Room destinationRoom){
        super(r, c, '0', Color.BLUE);
        this.destinationRoom=destinationRoom;

    }

}
