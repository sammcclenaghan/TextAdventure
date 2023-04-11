package computer.game;

import computer.game.commands.Event;

public interface IEventHandler {
  void handleEvent(Event event);
}
