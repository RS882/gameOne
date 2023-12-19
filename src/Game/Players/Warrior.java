package Game.Players;

import Game.Entity;
import Game.Player;

import java.util.Objects;

public class Warrior extends Player {
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


