package Game;

import Game.Attackanble.Attackable;

import java.util.Objects;

abstract public class Entity implements Attackable {
    private String name;
    private int health;
    private int attackPower;

    public Entity(String name, int health, int attackPower) {
        this.name = name;
        this.setHealth(health);
        setAttackPower(attackPower);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = (attackPower < 0)? 0: attackPower ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = (health<0) ? 1 : health;
    }

    public boolean  isAlive(){
        return health !=0 ? true: false;
    }

    @Override
    public void attack(Attackable target) {

        int res = ((Entity) target).getHealth()- this.getAttackPower();
        ((Entity) target).setHealth(res);
    }


    @Override
    public void takeDamage(Attackable source) {

            int res = this.getHealth() - ((Entity) source).getAttackPower();
            setHealth(res);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return health == entity.health && attackPower == entity.attackPower && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, attackPower);
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower ;
    }
}
