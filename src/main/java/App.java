import item.Edible;
import item.Weapon;
import item.armor.Armor;
import item.armor.Boots;
import item.armor.Chest;
import item.armor.Helmet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

  private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {

    //TODO: damage, armor parameters
    //TODO: durability function
    //TODO: money functions

    Edible apple = new Edible("Apple", 2, 0.5, 10);
    Edible broccoli = new Edible("Broccoli", 5, 2, 20);
    Weapon sword = new Weapon("Sword", 150, 15.2, 100, 100);
    Weapon stick = new Weapon("Stick", 1, 5, 250, 100);
    Armor hat = new Helmet("Hat", 50, 0.5, 10);
    Armor cap = new Helmet("Cap", 50, 0.5, 10);
    Armor shirt = new Chest("Shirt", 35, 0.7, 15);
    Armor socks = new Boots("Socks not in inventory", 35, 0.2, 10);

    Inventory inventory = new Inventory();

    inventory.addToStorage(broccoli);
    inventory.removeFromStorage(broccoli);

    inventory.addToStorage(sword);
    inventory.addToStorage(stick);
    inventory.addToStorage(hat);
    inventory.addToStorage(cap);
    inventory.addToStorage(shirt);

    inventory.addToStorage(apple);
    inventory.wearItem(hat);
    System.out.println(inventory.storage.getInfo(2));

    System.out.println(inventory.equipment.getInfo());

    inventory.wearItem(cap);
    inventory.wearItem(socks);
    inventory.wearItem(cap);

    System.out.println(inventory.storage.getInfo(2));
    System.out.println(inventory.equipment.getInfo());

    inventory.takeOffItem(cap);
    inventory.takeOffItem(socks);

    System.out.println(inventory.storage.getInfo(2));
    System.out.println(inventory.equipment.getInfo());

    // TODO: dopytać to ten przypadek: czy da się wywołać getInfo z Item zamiast z Edible.
    // Item a = new Edible("a",1,1,1); // upcasting
    // Edible b = new Edible("b",2,2,2);
    // System.out.println(a.getInfo());
    // System.out.println(b.getInfo());
  }
}
