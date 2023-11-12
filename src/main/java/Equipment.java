import items.Item;
import items.Weapon;
import items.armors.*;
import items.armors.Armor;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: zrobić metody z equipment możliwe do wywołania tylko z inventory
public class Equipment {

  private static final Logger logger = LoggerFactory.getLogger(Equipment.class);

  int totalArmorPoints;
  private Helmet helmet;
  private Chest chest;
  private Legs legs;
  private Boots boots;
  private Weapon weapon;

  public Equipment() {}

  public int getTotalArmorPoints() {
    for (Item item : getItems()) {
      if (item instanceof Armor) totalArmorPoints += ((Armor) item).getArmorPoints();
    }
    return totalArmorPoints;
  }

  public Helmet getHelmet() {
    return helmet;
  }

  public void setHelmet(Helmet helmet) {
    this.helmet = helmet;
  }

  public Chest getChest() {
    return chest;
  }

  public void setChest(Chest chest) {
    this.chest = chest;
  }

  public Legs getLegs() {
    return legs;
  }

  public void setLegs(Legs legs) {
    this.legs = legs;
  }

  public Boots getBoots() {
    return boots;
  }

  public void setBoots(Boots boots) {
    this.boots = boots;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
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

  private String getInfo() {

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

  /** 1 - basic info 2 - basic info with list of items 3 - basic info with extended list of item */
  public String getInfo(int range) {
    StringBuilder info = new StringBuilder();

    switch (range) {
      case 1 -> info.append(getInfo());
      case 2 -> {
        info.append("Total armor points: ").append(getTotalArmorPoints()).append("\n");
        info.append(getInfo(1));
      }
      case 3 -> {
        for (Item item : getItems()) {
          info.append(item.getInfo());
          info.append("\n\n");
        }
      }
    }

    return info.toString();
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
