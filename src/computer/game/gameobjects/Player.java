package computer.game.gameobjects;

public class Player extends Character {
  private Room location;
  private Weapon equippedWeapon;
  private Inventory inventory;
  private int health;

  public Player(Room startingRoom) {
    location = startingRoom;
    this.inventory = new Inventory();
  }

  public Room getLocation() {
    return this.location;
  }

  public void setLocation(Room location) {
    this.location = location;
  }

  public int getHealth() {
    return health;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void addItem(Item item) {
    inventory.addItem(item);
  }

  public void removeItem(Item item) {
    inventory.removeItem(item);
  }

  @Override
  public void takeDamage(int damage) {
    health -= damage;
  }

  public void heal(int healthAmount) {
    this.health += healthAmount;
    if (health > 100) {
      health = 100;
    }
    System.out.println("Healed " + healthAmount + " HP!");
  }

  @Override
  public void attack(Character target) {

  }

  public void equipWeapon(Weapon weapon) {
    equippedWeapon = weapon;
    System.out.println("You have equipped the " + weapon.getName() + ".");
  }

  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  public Item getItem(String itemName) {
    for (Item item : inventory.getItems()) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        return item;
      }
    }
    return null;
  }
}