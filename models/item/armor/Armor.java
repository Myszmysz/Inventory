package models.item.armor;

import models.item.Item;

public abstract class   Armor extends Item {

    private int protectionPoints;

    public Armor(String name, int value, double weight, int protectionPoints) {
        super(name, value, weight);
        this.setProtectionPoints(protectionPoints);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nPP: " + getProtectionPoints();
    }

    public int getProtectionPoints() {
        return protectionPoints;
    }

    public void setProtectionPoints(int protectionPoints) {
        this.protectionPoints = protectionPoints;
    }
}
