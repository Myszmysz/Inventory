package item;

public class Edible extends Item {

  private final int healthPoints;

  public Edible(String name, int value, double weight, int healthPoints) {
    super(name, value, weight);
    this.healthPoints = healthPoints;
  }

  @Override
  public String getInfo() {
    return super.getInfo() + "\nRestores " + getHealthPoints() + " points of health.";
  }

  public int getHealthPoints() {
    return healthPoints;
  }
}
