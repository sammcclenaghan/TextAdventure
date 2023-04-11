package computer.game.commands;

import java.util.function.Consumer;

public interface ICommand {
  void execute();

  void parse(String[] words);

  void setEventListener(Consumer<Event> eventListener);

  // Base command which implements Command behaviour
  public abstract class BaseCommand implements ICommand {
    private Consumer<Event> eventListener;

    protected void triggerEvent(String command, Object data) {
      if (eventListener != null) {
        Event event = new Event(command, data);
        eventListener.accept(event);
      }
    }

    public void setEventListener(Consumer<Event> eventListener) {
      this.eventListener = eventListener;
    }
  }
}
