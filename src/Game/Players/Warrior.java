package Game.Players;

import Game.Attackanble.Attackable;
import Game.Entity.Entity;
import Game.Entity.Player;

import java.util.Objects;

public class Warrior extends Player implements Attackable {
    private int armor;
    public Warrior(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower);
        setArmor(armor);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor <0 ? 1 : armor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Warrior warrior = (Warrior) o;
        return armor == warrior.armor && super.equals(o) ;
    }

    @Override
    public void takeDamage(Attackable source) {
        int att = ((Entity) source).getAttackPower()- this.armor/2;
        att = att<0? 0 : att;
        int res = this.getHealth() - att;
        setHealth(res );
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), armor);
    }

    @Override
    public String toString() {
        return "Warrior{ " + super.toString() +
                " armor=" + armor +
                '}';
    }


}


