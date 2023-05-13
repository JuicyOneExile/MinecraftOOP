import java.awt.*;

public class Entity {

    private int id;
    private String name;
    private int x;
    private int z;
    private int health;
    private int damage;

    public Entity(int id, int x, int z) {
        this.id = id;
        this.x = x;
        this.z = z;
    }

    public Entity(int id, String name, int health, int damage){
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
    }


    public void update() {

    }

    public void render(Graphics g) {

    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Health: " + health + ", Damage: " + damage;
    }
}
