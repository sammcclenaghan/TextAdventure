package computer.game.gameobjects;

public class Enemy {
  private String name;
  private int health;
  private int damage;

  public Enemy(String name, int health, int damage) {
    this.name = name;
    this.health = health;
    this.damage = damage;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
    if (!isAlive()) {
      System.out.println("Enemy has been knocked out!");
    }
  }

  public int getDamage() {
    return damage;
  }

  public boolean isAlive() {
    return health > 0;
  }
}
