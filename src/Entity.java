import java.security.PublicKey;
import java.util.Objects;

abstract class Entity {
    private String name;
    private int health;
    private int attackPower;

    public Entity(String name, int health, int attackPower) {
        this.name = name;
        this.health = (health<0) ? 1 : health;
        this.attackPower = (attackPower < 0)? 0: attackPower ;
    }

    public boolean  isAlive(){
        return health !=0 ? true: false;
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
        return "Entity{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                '}';
    }
}
