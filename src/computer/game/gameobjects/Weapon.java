package computer.game.gameobjects;

public class Weapon extends Item {
  private int damage;
  private boolean isEquipped;

  public Weapon(String name, String description, int damage) {
    super(name, description);
    this.damage = damage;
  }

  @Override
  public void use(Player player) {
    // Logic for attack
    System.out.println("You used the " + getName() + " dealing " + damage + " damage!");
  }

  public boolean isEquipped() {
    return isEquipped;
  }

  public void use(Player player, Enemy enemy) {
    System.out.println("You attacked " + enemy.getName());
    enemy.setHealth(enemy.getHealth() - damage);
  }
}
