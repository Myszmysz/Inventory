import items.armors.Armor;
import items.Edible;
import items.Weapon;
import items.armors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

  private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {

    // TODO: damage, armor parameters
    // TODO: durability function
    // TODO: money functions

    Edible apple = new Edible("Apple", 2, 0.5, 10);
    Edible broccoli = new Edible("Broccoli", 5, 2, 20);
    Weapon sword = new Weapon("Sword", 150, 15.2, 100);
    Weapon stick = new Weapon("Stick", 1, 5, 250);
    Armor hat = new Helmet("Hat", 50, 0.5, 10);
    Armor cap = new Helmet("Cap", 50, 0.5, 10);
    Armor shirt = new Chest("Shirt", 35, 0.7, 15);
    Armor socks = new Boots("Socks", 35, 0.2, 10);
    Armor pants = new Legs("Pants", 35, 0.2, 10);

    Inventory inventory = new Inventory();

    inventory.addToStorage(broccoli);
    inventory.addToStorage(sword);
    inventory.addToStorage(stick);
    inventory.addToStorage(hat);
    inventory.addToStorage(cap);
    inventory.addToStorage(shirt);
    inventory.addToStorage(socks);
    inventory.addToStorage(pants);

    inventory.wearItem(hat);
    inventory.wearItem(stick);
    inventory.wearItem(shirt);
    inventory.wearItem(socks);
    inventory.wearItem(pants);

    System.out.println(inventory.storage.getInfo(3));
    System.out.println(inventory.equipment.getInfo(2));

    // TODO: dopytać to ten przypadek: czy da się wywołać getInfo z items.Item zamiast z Edible.
    // items.Item a = new Edible("a",1,1,1); // upcasting
    // Edible b = new Edible("b",2,2,2);
    // System.out.println(a.getInfo());
    // System.out.println(b.getInfo());
  }
}
