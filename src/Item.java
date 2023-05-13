public class Item {
    private final int id;
    private final String name;
    private final int damage;
    private final int durability;

    public Item(int id, String name, int damage, int durability) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Damage: " + damage + ", Durability: " + durability;
    }



}
