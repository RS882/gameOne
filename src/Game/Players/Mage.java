package Game.Players;

import Game.Player;

import java.util.Objects;

public class Mage extends Player {

    private double mana;

    public Mage(String name, int health, int attackPower, double mana) {
        super(name, health, attackPower);

    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = (mana < 0) ? 1 : mana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mage mage = (Mage) o;
        return Double.compare(mana, mage.mana) == 0 && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mana);
    }

    @Override
    public String toString() {
        return "Mage{ "  + super.toString() +
                " mana=" + mana +
                '}';
    }
}
