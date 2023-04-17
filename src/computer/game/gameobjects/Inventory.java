package computer.game.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private List<Item> items;

  public Inventory() {
    items = new ArrayList<>();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public boolean contains(Item item) {
    return items.contains(item);
  }

  public void display(Player player) {
    System.out.println("Inventory: ");
    if (items.isEmpty()) {
      System.out.println("Inventory is empty");
    } else {
      for (Item item : items) {
        System.out.print("- " + item.getName());
        if (item instanceof Weapon && player.getEquippedWeapon() == item) {
          System.out.println(" (equipped)");
        }
        System.out.println();
      }
    }
  }

  public Item getItem(Object itemName) {
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase((String) itemName)) {
        return item;
      }
    }
    return null;
  }

  public List<Item> getItems() {
    return items;
  }
}
