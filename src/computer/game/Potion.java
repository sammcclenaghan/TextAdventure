package computer.game;

import computer.game.gameobjects.Item;
import computer.game.gameobjects.Player;

public class Potion extends Item {
  private int healthAmount;

  public Potion(String name, String description, int healthAmount) {
    super(name, description);
    this.healthAmount = healthAmount;
  }

  @Override
  public void use(Player player) {
    player.heal(healthAmount);
  }
}
