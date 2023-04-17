package computer.game;

import computer.game.commands.ICommand.BaseCommand;

public class InventoryCommand extends BaseCommand {
  @Override
  public void execute() {
    triggerEvent("inventory", null);
  }

  @Override
  public void parse(String[] words) {
    if (words[0].equalsIgnoreCase("inventory")) {
      execute();
    }
  }
}
