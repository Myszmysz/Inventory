import item.Item;
import item.Weapon;
import item.armor.Armor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inventory {

  private static final Logger logger = LoggerFactory.getLogger(Inventory.class);

  Storage storage = new Storage();
  Equipment equipment = new Equipment();


  public Inventory() {}

  public void sellItem(Item item) {

    boolean success = false;

    if (storage.getItems().contains(item)) {
      success = storage.removeItem(item);
    } else if (equipment.getItems().contains(item)) {
      success = equipment.takeOffItem(item);
    }

    if (success) {
      storage.addMoney(item.getValue());
      logger.info(item.getName() + " has been sold for " + item.getValue() + " coins.");
    } else logger.error("Unable to sell" + item.getName());
  }

  // TODO: use takeOff in method
  public void wearItem(Item newItem) {

    if (storage.getItems().contains(newItem)) {

      // only armor and weapon can be worn
      if (newItem instanceof Armor || newItem instanceof Weapon) {
        if (storage.removeItem(newItem)) {
          Item oldItem = equipment.wearItem(newItem);
          if (oldItem != null) storage.addItem(oldItem);
        }
      } else
        logger.error(
            "Invalid type of item: "
                + newItem.getName()
                + " ("
                + newItem.getClass().getSimpleName()
                + ")");
    } else {
      logger.error(newItem.getName() + " not found in storage.");
    }
  }

  public void takeOffItem(Item item) {
    if (equipment.getItems().contains(item)) {
      if (equipment.takeOffItem(item)) addToStorage(item);
    } else logger.error(item.getName() + " not found in inventory");
  }

  public void addToStorage(Item item) {
    storage.addItem(item);
  }

  public void removeFromStorage(Item item) {
    storage.removeItem(item);
  }
}
