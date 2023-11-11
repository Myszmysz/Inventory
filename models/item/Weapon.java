package models.item;

import java.util.EnumSet;

public class Weapon extends Item {

    private int damagePoints;
    private int durability;


    public Weapon(String name, int value, double weight, int damagePoints, int durability) {
        super(name, value, weight);
        this.setDamagePoints(damagePoints);
        this.setDurability(durability);
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nDP: " + damagePoints + "\ndurability: " + durability;
    }

}
