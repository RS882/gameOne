package Game.Players;

import Game.Attackanble.Attackable;
import Game.Entity.Entity;
import Game.Entity.Player;

import java.util.Objects;

public class Warrior extends Player implements Attackable {
    private int armor;

    public Warrior(String name) {
        super(name, 20, 5);
        setArmor(10);
    }

    protected int getArmor() {
        return armor;
    }

    private void setArmor(int armor) {
        this.armor = armor < 0 ? 1 : armor;
    }

    @Override
    public void takeDamage(Attackable source) {
        int attackSource = ((Entity) source).getAttackPower();

        int att = attackSource - this.armor / 2;
        att = att < 0 ? 0 : att;
        this.attackInfo(source,attackSource);
        int res = this.getHealth() - att;
        setHealth(res);
        damageInfo(source,att);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Warrior warrior = (Warrior) o;
        return armor == warrior.armor && super.equals(o);
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


