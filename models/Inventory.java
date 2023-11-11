package models;

import models.item.Item;
import models.item.Weapon;
import models.item.armor.Armor;

public class Inventory {

    Storage storage = new Storage();
    Equipment equipment = new Equipment();

    int healthPoints;
    int protectionPoint;

    public Inventory() {
    }


    public void sellItem(Item item) {

        boolean success = false;

        if (storage.getItems().contains(item)) {
            success = storage.removeItem(item);
        } else if (equipment.getItems().contains(item)) {
            success = equipment.takeOffItem(item);
        }

        if (success) {
            storage.addMoney(item.getValue());
            System.out.println(item.getName() + " has been sold for " + item.getValue() + " coins.");
        } else
            System.out.println("Unable to sell" + item.getName());

    }

    public void wearItem(Item newItem) {

        //TODO Static member 'models.Storage.getItems()' accessed via instance reference
        if (storage.getItems().contains(newItem)) {

            // only armor and weapon can be worn
            if (newItem instanceof Armor || newItem instanceof Weapon) {
                if (storage.removeItem(newItem)) {
                    Item oldItem = equipment.wearItem(newItem);
                    if (oldItem != null) System.out.println(storage.addItem(oldItem));
                }
            } else
                System.out.println("Invalid type of item: " + newItem.getName() + " (" + newItem.getClass().getSimpleName() + ")");
        } else {
            System.out.println(newItem.getName() + " not found in storage.");
        }
    }

    public void takeOffItem(Item item) {
        if (equipment.getItems().contains(item)) {
            if (equipment.takeOffItem(item)) addToStorage(item);
        } else System.out.println(item.getName() + " not found in inventory");
    }

    public void addToStorage(Item item) {
        storage.addItem(item);
    }

}
