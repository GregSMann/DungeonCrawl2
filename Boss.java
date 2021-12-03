/**
 *Creates a Boss Enemy object 
 *
 */
public class Boss extends Enemy{
    private String name="Ogre Chieftan";
    private int hp=100;
    private int damage=100;
    private int protection=20;
    /**
     *Constructor that creates a Boss
     @param name name of the boss
     @param row row number of the boss (Location)
     @param col Column number of the boss (Location)
     @param hp Health of the boss
     @param damage The amount of damage the boss does
     @param protection The amount of armor the boss has
     */
    public Boss(String name, int row, int col, int hp, int damage, int protection) {
        super(name, row, col, hp, damage, protection);
    }

}
