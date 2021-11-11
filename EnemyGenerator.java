// EnemyGenerator.java
// this class contains a static method for creating enemies randomly

import java.util.Random;

public class EnemyGenerator {
    public static Enemy generate(int row, int col) {
        // TODO: replace this with your own code!
        Enemy genEnemy= new Enemy("Goblin", row, col, 20, 5, 3);
        return genEnemy;
    }
}

