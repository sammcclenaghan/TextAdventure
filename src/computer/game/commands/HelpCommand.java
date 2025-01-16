package computer.game.commands;

import computer.game.commands.ICommand.BaseCommand;

public class HelpCommand extends BaseCommand {

    @Override
    public void execute() {
        triggerEvent("help", null);
    }

    @Override
    public void parse(String[] words) {
        if (words.length == 1 && words[0].equalsIgnoreCase("help")) {
            execute();
        }
    }
}
