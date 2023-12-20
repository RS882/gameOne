package Game.Entity;

import Game.Attackanble.Attackable;

import java.util.Objects;

abstract public class Entity implements Attackable {
    private String name;
    private int health;
    private int attackPower;
    private int damageReceived;


    private int getDamageReceived() {
        return damageReceived;
    }

    private void setDamageReceived(int damageReceived) {
        this.damageReceived = damageReceived;
    }

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

    protected void setAttackPower(int attackPower) {
        this.attackPower = (attackPower < 0) ? 0 : attackPower;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setHealth(int health) {
        this.health = (health < 0) ? 0 : health;
    }

    public boolean isAlive() {
        return health != 0 ? true : false;
    }

    @Override
    public void attack(Attackable target) {
        int attack = this.getAttackPower();
        ((Entity) target).setDamageReceived(attack);
        if (attack != 0) this.attackInfo(target, attack);


    }

    @Override
    public void takeDamage(Attackable source) {

       this.setHealth(this.getHealth() - this.getDamageReceived());
       this.damageInfo(source, this.getDamageReceived());

    }

    protected void attackInfo(Attackable target, int attack) {

        System.out.printf("%s (%s) attacks %s (%s) with strength %d!%n",
                this.getClass().getSimpleName(),
                this.name,
                target.getClass().getSimpleName(),
                ((Entity) target).getName(),
                attack);
    }

    protected void damageInfo(Attackable source, int attack) {
        System.out.printf("%s (%s) has taken %d damage! His health is now %d!%n",
                this.getClass().getSimpleName(),
                this.getName(),
                attack,
                this.getHealth());
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
        return "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower;
    }
}
