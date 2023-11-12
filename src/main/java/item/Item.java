package item;

public abstract class Item {

    private String name;
    private int value;
    private double weight;

    public Item(String name, int value, double weight) {
        this.setName(name);
        this.setValue(value);
        this.setWeight(weight);
    }

    public String getInfo() {
        return "name: " + getName() + "\nvalue: " + getValue() + "\nweight: " + getWeight();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
