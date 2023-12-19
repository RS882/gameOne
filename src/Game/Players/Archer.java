package Game.Players;

import Game.Attackanble.Attackable;
import Game.Player;

import java.util.Random;

public class Archer extends Player implements Attackable {
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }


    private boolean eventShouldOccur(double chance) {
        return new Random().nextInt(100) < chance;}

    @Override
    public int getAttackPower() {
        return eventShouldOccur(20)? super.getAttackPower()*2: super.getAttackPower();
    }

    @Override
    public String toString() {
        return "Archer{ " + super.toString() +"}";
    }


}
