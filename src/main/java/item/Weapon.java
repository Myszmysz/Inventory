package item;

public class Weapon extends Item {

  private final int damagePoints;
  private final int durability;

  public Weapon(String name, int value, double weight, int damagePoints, int durability) {
    super(name, value, weight);
    this.damagePoints = damagePoints;
    this.durability = durability;
  }

  public int getDamagePoints() {
    return damagePoints;
  }

  public int getDurability() {
    return durability;
  }

  @Override
  public String getInfo() {
    return super.getInfo() + "\ndamage: " + damagePoints + "\ndurability: " + durability;
  }
}
