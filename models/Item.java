package models;

public class Item {

    // boolean isWearable
    private String name;
    private int value;
    private double weight;

    public Item(String name, int value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public void sellItem() {
        //TODO
    }

    ;


    public String getInfo() {
        return "name: " + name + "\nvalue: " + value + "\nweight: " + weight;
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
