package computer.game.commands;

import computer.game.commands.ICommand.BaseCommand;

public class LookCommand extends BaseCommand {
  private String direction;

  public LookCommand() {
  }

  /*
   * Calls triggerEvent with the event type "go" and the direction as the event
   * data
   */
  @Override
  public void execute() {
    triggerEvent("look", direction);
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getDirection() {
    return direction;
  }

  @Override
  public void parse(String[] words) {
    if (words.length == 2) {
      setDirection(words[1]);
      execute();
    }
  }
}
