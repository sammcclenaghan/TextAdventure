package computer.game.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
  private String name;
  private String description;
  private Map<String, Room> neighborRooms;
  private List<Item> items;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
    this.neighborRooms = new HashMap<String, Room>();
    items = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Room getNeighbor(String direction) {
    return neighborRooms.get(direction.toLowerCase());
  }

  public void setNeighbor(String direction, Room room) {
    neighborRooms.put(direction.toLowerCase(), room);
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public Item getItem(String itemName) {
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        return item;
      }
    }
    return null;
  }
}
