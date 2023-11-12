package item.armor;

import item.Item;

public abstract class Armor extends Item {

  private final int armorPoints;
  private int durability;

  public Armor(String name, int value, double weight, int armorPoints) {
    super(name, value, weight);
    this.armorPoints = armorPoints;
    this.durability = MAX_DURABILITY;
  }

  @Override
  public String getInfo() {
    return super.getInfo() + "\narmor: " + getArmorPoints();
  }

  public int getArmorPoints() {
    return armorPoints;
  }

  public int getDurability() {
    return durability;
  }
}
