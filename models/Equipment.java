package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equipment {

    private static Armor helmet;
    private static Armor chest;
    private static Armor legs;
    private static Armor boots;
    private static Weapon weapon;

    private Map<Purpose, Item> equipmentItems = getEquipmentItems();


    public Equipment(Armor helmet, Armor armor, Armor legs, Armor boots, Weapon weapon) {
        this.setHelmet(helmet);
        this.setChest(armor);
        this.setLegs(legs);
        this.setBoots(boots);
        this.setWeapon(weapon);
    }

    public Equipment() {

    }

    public Map<Purpose, Item> getEquipmentItems() {

        Map<Purpose, Item> equipment = new HashMap<>();
        equipment.put(Purpose.HELMET, getHelmet());
        equipment.put(Purpose.CHEST, getChest());
        equipment.put(Purpose.LEGS, getLegs());
        equipment.put(Purpose.BOOTS, getBoots());
        equipment.put(Purpose.WEAPON, getWeapon());

        return equipment;
    }

    public List<Item> getItems() {

        List<Item> listOfItems = new ArrayList<>();

        listOfItems.add(helmet);
        listOfItems.add(chest);
        listOfItems.add(legs);
        listOfItems.add(boots);
        listOfItems.add(weapon);

        return listOfItems;
    }

    public String getInfo() {
        return String.format("""
                Equipment
                helmet: %s
                chest: %s
                legs: %s
                boots: %s
                weapon: %s
                """, getItemName(getEquipmentItems().get(Purpose.HELMET)), getItemName(getEquipmentItems().get(Purpose.CHEST)), getItemName(getEquipmentItems().get(Purpose.LEGS)), getItemName(getEquipmentItems().get(Purpose.BOOTS)), getItemName(getEquipmentItems().get(Purpose.WEAPON))

        );
    }

    private String getItemName(Item item) {
        if (item != null) {
            return item.getName();
        } else return "empty";
    }

    public Armor getHelmet() {
        return helmet;
    }

    private void setHelmet(Armor helmet) {
        this.helmet = helmet;
        equipmentItems.replace(Purpose.HELMET, helmet);
    }

    public Armor getChest() {
        return chest;
    }

    private void setChest(Armor chest) {
        this.chest = chest;
        equipmentItems.replace(Purpose.CHEST, chest);
    }

    public Armor getLegs() {
        return legs;
    }

    private void setLegs(Armor legs) {
        this.legs = legs;
        equipmentItems.replace(Purpose.LEGS, legs);
    }

    public Armor getBoots() {
        return boots;
    }

    private void setBoots(Armor boots) {
        this.boots = boots;
        equipmentItems.replace(Purpose.BOOTS, boots);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    private void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        equipmentItems.replace(Purpose.WEAPON, weapon);
    }


    public Item wearItem(Item item) {
        if (item.getClass().equals(Armor.class)) {
            return replaceItem(item, ((Armor) item).getPurpose());
        } else if (item.getClass().equals(Weapon.class)) {
            return replaceItem(item, ((Weapon) item).getPurpose());
        }
        System.out.println("Unable to wear: " + item.getName());
        return null;
    }

    public Item takeOffItem(Item item) {
        if (item.getClass().equals(Armor.class)) {
            return replaceItem(null, ((Armor) item).getPurpose());
        } else if (item.getClass().equals(Weapon.class)) {
            return replaceItem(null, ((Weapon) item).getPurpose());
        }
        System.out.println("Unable to wear: " + item.getName());
        return null;
    }

    private Item replaceItem(Item item, Purpose purpose) {
        switch (purpose) {
            case HELMET -> {
                setHelmet((Armor) item);
                return equipmentItems.replace(purpose, item);
            }
            case CHEST -> {
                setChest((Armor) item);
                return equipmentItems.replace(purpose, item);
            }
            case LEGS -> {
                setLegs((Armor) item);
                return equipmentItems.replace(purpose, item);
            }
            case BOOTS -> {
                setBoots((Armor) item);
                return equipmentItems.replace(purpose, item);
            }
            case WEAPON -> {
                setWeapon((Weapon) item);
                return equipmentItems.replace(purpose, item);
            }
        }
        return null;
    }

    private Item replaceItem(Armor item) {
        return replaceItem(item, item.getPurpose());
    }

    private Item replaceItem(Weapon item) {
        return replaceItem(item, item.getPurpose());
    }
}
