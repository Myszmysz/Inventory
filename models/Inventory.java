package models;

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
            equipment.takeOffItem(item);
        }

        if (success) {
            storage.setMoney(storage.getMoney() + item.getValue());
            System.out.println(item.getName() + " sold for " + item.getValue() + " coins.");
        } else
            System.out.println("Unable to sell" + item.getName());

    }

    public void wearItem(Item item) {

        if (storage.getItems().contains(item)) {
            Item itemTemp = equipment.wearItem(item);
            System.out.println(itemTemp);
            if (itemTemp != null) storage.addItem(itemTemp);
            storage.removeItem(item);
            System.out.println(item.getName() + " is put on.");

        } else {
            System.out.println(item.getName() + " not found in storage.");
        }
    }

    public void takeOffItem(Item item) {

        if (equipment.getEquipmentItems().containsValue(item)) {
            Item itemTemp = equipment.takeOffItem(item);
            if (itemTemp != null) storage.addItem(itemTemp);
            System.out.println(item.getName() + " is taken off.");
        } else {
            System.out.println("Unable to take off " + item.getName() + ". Item not found in equipment.");
        }

    }

    public void addToStorage(Item item) {
        storage.addItem(item);
    }

}
