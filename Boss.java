public class Boss extends Enemy{
    private String name="Ogre Chieftan";
    private int hp=100;
    private int damage=100;
    private int protection=20;
    public Boss(String name, int row, int col, int hp, int damage, int protection) {
        super(name, row, col, hp, damage, protection);
    }

}
