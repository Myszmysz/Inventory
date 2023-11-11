package models;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static final List<Item> items = new ArrayList<>();
    private int money;

    public Storage() {

    }

    public static boolean removeItem(Item item) {
        return getItems().remove(item);
    }

    public static List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        getItems().add(item);
        System.out.println(item.getName() + " added to inventory.");
    }

    private int getNumberOfItems() {
        return getItems().size();
    }

    private double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : getItems())
            totalWeight += item.getWeight();

        return totalWeight;
    }

    public String getListOfItems() {
        StringBuilder listOfItems = new StringBuilder();
        listOfItems.append("\nStorage:\n");
        for (Item item : getItems()) {
            listOfItems.append(item.getName());
            listOfItems.append("\n");
        }
        return listOfItems.toString();
    }

    public String getInfo() {
        StringBuilder listOfItems = new StringBuilder();

        listOfItems.append(String.format("""
                Number of items: %s
                Money: %s coins
                Total weight: %s
                """, getNumberOfItems(), getMoney(), getTotalWeight()));

        listOfItems.append("items:\n");

        for (Item item : getItems()) {
            listOfItems.append(item.getInfo());
            listOfItems.append("\n\n");
        }
        return listOfItems.toString();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
