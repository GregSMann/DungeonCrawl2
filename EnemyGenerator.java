/**EnemyGenerator.java
*
* this class contains a static method for creating enemies semi-randomly utilizing the Room the player is in to generate enemies of different difficulties.
 * @author 240Group GMJ
 * @version 1.0
*/
import java.util.Random;

public class EnemyGenerator {
    /**
     * Generates an enemy using the current room to pick enemy strength
     * @param row Enemies starting position on the X axis.
     * @param col Enemies starting Position on the Y axis
     * @param room Current Room that determines enemy strength.
     * @return Returns a newly generated enemy with Strength, HP, and Protection based on the rooms difficulty.
     */
    public static Enemy generate(int row, int col, Room room) {
        Enemy genEnemy=new Enemy("Lost Goblin",row,col,1,1,1);
        // TODO: replace this with your own code!
        if (room.getWorldDifficulty()==worldDifficulty.Easy) {


            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genEnemy = new Enemy("Goblin", row, col, 20, 5, 3);
                    break;
                case 2:
                    genEnemy = new Enemy("Goblin Mage", row, col, 10, 10, 1);
                    break;
                case 3:
                    genEnemy = new Enemy("Goblin Warleader", row, col, 30, 7, 5);
                    break;


                }
        }
        if (room.getWorldDifficulty()==worldDifficulty.Normal) {

            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genEnemy = new Enemy("Orc scout", row, col, 40, 12, 8);
                    break;
                case 2:
                    genEnemy = new Enemy("Orc Hunter", row, col, 30, 15, 4);
                    break;
                case 3:
                    genEnemy = new Enemy("Orc Fightmaster", row, col, 50, 18, 10);
                    break;

            }

        }if (room.getWorldDifficulty()==worldDifficulty.Hard) {

            int b = (int) (Math.random() * (3 - 1 + 1) + 1);
            switch (b) {

                case 1:
                    genEnemy = new Enemy("Ogre Lordguard", row, col, 50, 20, 10);
                    break;
                case 2:
                    genEnemy = new Enemy("Ogre Beastmaster", row, col, 20, 30, 12);
                    break;
                case 3:
                    genEnemy = new Enemy("Ogre Beserker", row, col, 60, 40, 0);
                    break;
            }

        }
        return genEnemy;
}
}

