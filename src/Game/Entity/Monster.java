package Game.Entity;

import java.util.Random;

public class Monster extends Entity {
    public Monster(String name) {

        super(name,
                new Random().nextInt(20) + 1,
                new Random().nextInt(20) + 1);
    }

    @Override
    public String toString() {
        return "Monster { " + super.toString() + " };";
    }
}
