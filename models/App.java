package models;

public class App {

    public static void main(String[] args) {

        Edible apple = new Edible("Apple", 2, 0.5, 10);
        Edible broccoli = new Edible("Broccoli", 5, 2, 20);
        Weapon sword = new Weapon("Sword", 150, 15.2, 100, 100);
        Weapon stick = new Weapon("Stick", 1, 5, 250, 100);
        Armor hat = new Armor("Hat", 50, 0.5, 10, Purpose.HELMET);
        Armor cap = new Armor("Cap", 50, 0.5, 10, Purpose.HELMET);
        Armor shirt = new Armor("Shirt", 35, 0.7, 15, Purpose.CHEST);

        Armor socks = new Armor("Socks not in inventory", 35, 0.2, 10, Purpose.BOOTS);

        Inventory inventory = new Inventory();
        inventory.addToStorage(apple);
        inventory.addToStorage(broccoli);
        inventory.addToStorage(sword);
        inventory.addToStorage(stick);
        inventory.addToStorage(hat);
        inventory.addToStorage(cap);
        inventory.addToStorage(shirt);

        System.out.println(inventory.storage.getListOfItems());
        System.out.println(inventory.equipment.getInfo());

        inventory.wearItem(hat);

        System.out.println(inventory.storage.getListOfItems());
        System.out.println(inventory.equipment.getInfo());

        inventory.wearItem(cap);

        System.out.println(inventory.storage.getListOfItems());
        System.out.println(inventory.equipment.getInfo());
    }
}
