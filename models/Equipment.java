package models;

import models.item.Item;
import models.item.Weapon;
import models.item.armor.Boots;
import models.item.armor.Chest;
import models.item.armor.Helmet;
import models.item.armor.Legs;

import java.util.ArrayList;
import java.util.List;

public class Equipment {

    private static Helmet helmet;
    private static Chest chest;
    private static Legs legs;
    private static Boots boots;
    private static Weapon weapon;

    public Equipment() {

    }

    public static Helmet getHelmet() {
        return helmet;
    }

    public static void setHelmet(Helmet helmet) {
        Equipment.helmet = helmet;
    }

    public static Chest getChest() {
        return chest;
    }

    public static void setChest(Chest chest) {
        Equipment.chest = chest;
    }

    public static Legs getLegs() {
        return legs;
    }

    public static void setLegs(Legs legs) {
        Equipment.legs = legs;
    }

    public static Boots getBoots() {
        return boots;
    }

    public static void setBoots(Boots boots) {
        Equipment.boots = boots;
    }

    public static Weapon getWeapon() {
        return weapon;
    }

    public static void setWeapon(Weapon weapon) {
        Equipment.weapon = weapon;
    }

    public List<Item> getItems() {

        List<Item> listOfItems = new ArrayList<>();

        listOfItems.add(getHelmet());
        listOfItems.add(getChest());
        listOfItems.add(getLegs());
        listOfItems.add(getBoots());
        listOfItems.add(getWeapon());

        return listOfItems;
    }

    public String getInfo() {

        return "Equipment\n" +
                "helmet: " + (helmet == null ? "empty" : helmet.getName()) + '\n' +
                "chest: " + (chest == null ? "empty" : chest.getName()) + '\n' +
                "legs: " + (legs == null ? "empty" : legs.getName()) + '\n' +
                "boots: " + (boots == null ? "empty" : boots.getName()) + '\n' +
                "weapon: " + (weapon == null ? "empty" : weapon.getName()) + '\n';
    }

    public Item wearItem(Item newItem) {

        String itemClassName = newItem.getClass().getSimpleName();
        Item oldItem;

        switch (itemClassName) {
            case "Helmet" -> {
                oldItem = helmet;
                setHelmet((Helmet) newItem);
            }
            case "Chest" -> {
                oldItem = chest;
                setChest((Chest) newItem);
            }
            case "Legs" -> {
                oldItem = legs;
                setLegs((Legs) newItem);
            }
            case "Boots" -> {
                oldItem = boots;
                setBoots((Boots) newItem);
            }
            case "Weapon" -> {
                oldItem = weapon;
                setWeapon((Weapon) newItem);
            }
            default -> {
                System.out.println("Invalid item class: " + itemClassName);
                return null;
            }
        }
        System.out.println(newItem.getName() + " equipped.");
        return oldItem;
    }

    public boolean takeOffItem(Item item) {

        String itemClassName = item.getClass().getSimpleName();

        switch (itemClassName) {
            case "Helmet" -> setHelmet(null);
            case "Chest" -> setChest(null);
            case "Legs" -> setLegs(null);
            case "Boots" -> setBoots(null);
            case "Weapon" -> setWeapon(null);
            default -> {
                System.out.println("Invalid item class name: " + itemClassName);
                return false;
            }
        }
        System.out.println(item.getName() + " taken off.");
        return true;
    }

}
