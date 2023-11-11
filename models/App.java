package models;

import models.item.Edible;
import models.item.Weapon;
import models.item.armor.Armor;
import models.item.armor.Boots;
import models.item.armor.Chest;
import models.item.armor.Helmet;

public class App {


    public static void main(String[] args) {

        //TODO: logs

        Edible apple = new Edible("Apple", 2, 0.5, 10);
        Edible broccoli = new Edible("Broccoli", 5, 2, 20);
        Weapon sword = new Weapon("Sword", 150, 15.2, 100, 100);
        Weapon stick = new Weapon("Stick", 1, 5, 250, 100);
        Armor hat = new Helmet("Hat", 50, 0.5, 10);
        Armor cap = new Helmet("Cap", 50, 0.5, 10);
        Armor shirt = new Chest("Shirt", 35, 0.7, 15);
        Armor socks = new Boots("Socks not in inventory", 35, 0.2, 10);

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

        inventory.sellItem(hat);
        inventory.sellItem(apple);

        System.out.println(inventory.storage.getInfo(2));
        System.out.println(inventory.equipment.getInfo());

        /*
        Jak to tutaj działa?

        Item a = new Edible("a",1,1,1);
        Edible b = new Edible("b",2,2,2);

        System.out.println(a.getInfo());
        System.out.println(b.getInfo()); */
    }
}
