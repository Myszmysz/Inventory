import items.Item;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: zrobić metody ze storage możliwe do wywołania tylko z inventory
public class Storage {

  private static final Logger logger = LoggerFactory.getLogger(Storage.class);
  private final List<Item> items;
  private int money;

  public Storage() {
    money = 0;
    items = new ArrayList<>();
  }

  public List<Item> getItems() {
    return items;
  }

  protected void addItem(Item item) {
    getItems().add(item);
    Storage.logger.info(item.getName() + " added to storage.");
  }

  protected boolean removeItem(Item item) {
    boolean result = getItems().remove(item);

    // TODO: to logowanie zostawić tutaj czy wywalić wyżej?
    if (result) {
      Storage.logger.info(item.getName() + " removed from storage.");
    } else Storage.logger.error(item.getName() + " not found in storage.");

    return result;
  }

  private int getNumberOfItems() {
    return getItems().size();
  }

  private double getTotalWeight() {
    double totalWeight = 0;
    for (Item item : getItems()) totalWeight += item.getWeight();

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
   * 1 - basic info 2 - basic info with list of items 3 - basic info with extended list of item
   * TODO: 4 - basic info with fully extended list of item
   */
  public String getInfo(int range) {
    StringBuilder info = new StringBuilder();

    switch (range) {
      case 1 -> info.append(
          String.format(
              """

                    Number of items: %s
                    Money: %s coins
                    Total weight: %s
                    """,
              getNumberOfItems(), money, getTotalWeight()));
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
        // TODO: 3 should use Info.getInfo 4 should use specific object getInfo.
    }

    return info.toString();
  }

  public void addMoney(int money) {
    this.money += money;
  }
}
