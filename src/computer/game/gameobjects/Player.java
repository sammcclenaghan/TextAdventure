package computer.game.gameobjects;

public class Player {
  private int health;
  private Room location;

  public Player(Room startingRoom) {
    location = startingRoom;
  }

  public Room getLocation() {
    return this.location;
  }

  public void setLocation(Room location) {
    this.location = location;
  }
}