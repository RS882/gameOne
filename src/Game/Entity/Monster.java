package Game.Entity;

public class Monster extends Entity  {
    public Monster(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public String toString() {
        return "Monster { "+ super.toString()+ " };";
    }
}
