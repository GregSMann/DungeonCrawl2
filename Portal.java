import ansi_terminal.Color;

public class Portal extends Entity{
    Room destinationRoom;
    Position pos;

    public Portal(int r, int c, Room destinationRoom){
        super(r, c, '0', Color.BLUE);
        destinationRoom=destinationRoom;

    }

}
