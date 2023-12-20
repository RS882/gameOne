package Game.Players;

import Game.Attackanble.Attackable;
import Game.Entity.Player;

import java.util.Random;

public class Archer extends Player implements Attackable {
    public Archer(String name) {
        super(name, 10, 5);
    }


    private boolean eventShouldOccur(double chance) {
        return new Random().nextInt(100) < chance;
    }

    @Override
    public int getAttackPower() {
        int attack = super.getAttackPower();
        if (eventShouldOccur(20)) {
            attack = super.getAttackPower() * 2;
            System.out.printf("Archer (%s) made a critical attack!%n",this.getName());
        }

        return attack;
    }

    @Override
    public void takeDamage(Attackable source) {
        if (!eventShouldOccur(25)) super.takeDamage(source);
        else {
            System.out.printf("Archer (%s) dodged the attack!%n", this.getName());
        }
    }

    @Override
    public String toString() {
        return "Archer{ " + super.toString() + "}";
    }


}
