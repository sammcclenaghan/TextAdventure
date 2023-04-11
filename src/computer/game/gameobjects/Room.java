package computer.game.commands;

import java.util.HashMap;
import java.util.Map;

public class Room {
  private String name;
  private String description;
  private Map<String, Room> neighborRooms;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
    this.neighborRooms = new HashMap<String, Room>();
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
}
