package models;

import java.util.EnumSet;

public class Armor extends Item {

    EnumSet<Purpose> armorPurpose = EnumSet.of(Purpose.HELMET, Purpose.CHEST, Purpose.LEGS, Purpose.BOOTS);
    private int protection;
    private Purpose purpose;

    public Armor(String name, int value, double weight, int protection, Purpose purpose) {
        super(name, value, weight);
        this.setProtection(protection);
        this.setPurpose(purpose);
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    @Override
    public String getInfo() {
        return "name: " + super.getName() + " (" + purpose.getValue() + ")\nvalue: " + super.getValue() + "\nweight: " + super.getWeight() + "\nPP: " + protection;
    }
}
