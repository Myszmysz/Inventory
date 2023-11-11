package models.item;

import models.item.Item;

public class Edible extends Item {

    private int healthPoints;

    public Edible(String name, int value, double weight, int healthPoints) {
        super(name, value, weight);
        this.setHealthPoints(healthPoints);
    }

    public void useItem() {
        //TODO:
        // add HP
        // remove from inventory
    }

    public String getInfo() {
        return super.getInfo() + "\nRestores " + getHealthPoints() + " hp";
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
