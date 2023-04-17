package computer.game.commands;

import computer.game.commands.ICommand.BaseCommand;

public class EquipCommand extends BaseCommand {
  private String weaponName;

  @Override
  public void execute() {
    triggerEvent("equip", weaponName);
  }

  public void setWeaponName(String weaponName) {
    this.weaponName = weaponName;
  }

  @Override
  public void parse(String[] words) {
    if (words.length == 2) {
      setWeaponName(words[1]);
      execute();
    }
  }
}
