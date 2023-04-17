package computer.game.commands;

import computer.game.commands.ICommand.BaseCommand;

public class DropCommand extends BaseCommand {
  private String itemName;

  public DropCommand() {
  }

  @Override
  public void execute() {
    triggerEvent("drop", itemName);
  }

  public void setItem(String item) {
    this.itemName = item;
  }

  @Override
  public void parse(String[] words) {
    if (words.length == 2) {
      setItem(words[1]);
      execute();
    }
  }
}
