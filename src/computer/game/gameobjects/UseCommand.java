package computer.game.gameobjects;

import computer.game.commands.ICommand.BaseCommand;

public class UseCommand extends BaseCommand {
  private String itemName;

  @Override
  public void execute() {
    triggerEvent("use", itemName);
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