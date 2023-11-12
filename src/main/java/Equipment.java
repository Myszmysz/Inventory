import item.Item;
import item.Weapon;
import item.armor.Boots;
import item.armor.Chest;
import item.armor.Helmet;
import item.armor.Legs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// TODO czy equipment nie powinno być interface?
// TODO: zrobić metody z equipment możliwe do wywołania tylko z inventory
public class Equipment {

  private static final Logger logger = LoggerFactory.getLogger(Equipment.class);

  private static Helmet helmet;
  private static Chest chest;
  private static Legs legs;
  private static Boots boots;
  private static Weapon weapon;

  public Equipment() {}

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

    return "Equipment\n"
        + "helmet: "
        + (helmet == null ? "empty" : helmet.getName())
        + '\n'
        + "chest: "
        + (chest == null ? "empty" : chest.getName())
        + '\n'
        + "legs: "
        + (legs == null ? "empty" : legs.getName())
        + '\n'
        + "boots: "
        + (boots == null ? "empty" : boots.getName())
        + '\n'
        + "weapon: "
        + (weapon == null ? "empty" : weapon.getName())
        + '\n';
  }

  public Item wearItem(Item newItem) {

    Item oldItem;

    if (newItem instanceof Helmet) {
      oldItem = helmet;
      setHelmet((Helmet) newItem);
    } else if (newItem instanceof Chest) {
      oldItem = chest;
      setChest((Chest) newItem);
    } else if (newItem instanceof Legs) {
      oldItem = legs;
      setLegs((Legs) newItem);
    } else if (newItem instanceof Boots) {
      oldItem = boots;
      setBoots((Boots) newItem);
    } else if (newItem instanceof Weapon) {
      oldItem = weapon;
      setWeapon((Weapon) newItem);
    } else {
      logger.error("Illegal class of item: " + newItem.getClass().getSimpleName());
      return null;
    }
   logger.info(newItem.getName() + " equipped.");
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
        logger.error("Illegal class of item: " + item.getClass().getSimpleName());
        return false;
      }
    }
    logger.info(item.getName() + " taken off.");
    return true;
  }
}
