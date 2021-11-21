// EnemyGenerator.java
// this class contains a static method for creating enemies randomly

import java.util.Random;

public class EnemyGenerator {
    public static Enemy generate(int row, int col, Room room) {
        World exampleWorld = new World();
        Enemy genEnemy=new Enemy("Lost Goblin",row,col,1,1,1);
        // TODO: replace this with your own code!
        if (room == exampleWorld.firstRoom) {


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
        if (room == exampleWorld.secondRoom) {

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

        }if (room == exampleWorld.finalRoom) {

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

