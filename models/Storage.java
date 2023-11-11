package models;

import models.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static final List<Item> items = new ArrayList<>();
    private int money;

    //TODO: in new object money should always be 0;

    public Storage() {

    }

    // TODO: change type to boolean
    public static boolean removeItem(Item item) {
        boolean result = getItems().remove(item);

        System.out.println(result
                ? item.getName() + " removed from storage."
                : "Failed to remove" + item.getName() + " from storage.");

        return result;
    }

    public static List<Item> getItems() {
        return items;
    }

    public String addItem(Item item) {
        getItems().add(item);
        return item.getName() + " added to inventory.";
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
        int i = 1;

        listOfItems.append("\nStorage:\n");
        for (Item item : getItems()) {
            listOfItems.append(i).append(". ").append(item.getName());
            listOfItems.append("\n");
            i++;
        }
        return listOfItems.toString();
    }

    public String getInfo() {
        return getInfo(1);
    }

    /**
     * 1 - basic info
     * 2 - basic info with list of items
     * 3 - basic info with extended list of item
     */
    public String getInfo(int range) {
        StringBuilder info = new StringBuilder();

        switch (range) {
            case 1 -> info.append(String.format("""
                                        
                    Number of items: %s
                    Money: %s coins
                    Total weight: %s
                    """, getNumberOfItems(), money, getTotalWeight()));
            case 2 -> {
                info.append(getInfo(1));
                info.append(getListOfItems());
            }
            case 3 -> {
                info.append(getInfo(1));
                info.append("items:\n\n");

                for (Item item : getItems()) {
                    info.append(item.getInfo());
                    info.append("\n\n");
                }
            }
        }

        return info.toString();
    }

    public void addMoney(int money) {
        this.money += money;
    }
}
