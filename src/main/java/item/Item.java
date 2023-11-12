package item;

public abstract class Item {

  public static final int MAX_DURABILITY = 100;

  private final String name;
  private final int value;
  private final double weight;

  public Item(String name, int value, double weight) {
    this.name = name;
    this.value = value;
    this.weight = weight;
  }

  public String getInfo() {
    return "name: " + getName() + "\nvalue: " + getValue() + "\nweight: " + getWeight();
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }

  public double getWeight() {
    return weight;
  }
}
