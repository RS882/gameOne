package Game.Players;

import Game.Player;

public class Archer extends Player {
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public String toString() {
        return "Archer{ " + super.toString() +"}";
    }
}
