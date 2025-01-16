# Drakenholme

Drakenholme is a text-based adventure game developed in Java. This project exemplifies numerous design patterns like advanced OOP implementation, the Factory Design Pattern, and Event-Driven Development. Set within the ominous castle of Aetheria, players embark on a quest to navigate a cursed castle, interact with artifacts and return them to their rightful places.

### Architecture

##### Factory Pattern
The **Factory Pattern** is employed to initialize and manage the creation of rooms and items quickly and efficiently. This adds scalability for updates without altering core game logic.

**Implementation**
- **RoomInitializer Class:** Responsible for creating and connecting rooms within the world.

  ```java
  public class RoomInitalizer {
      private Map<String, Room> rooms;

      public RoomInitalizer() {
          rooms = new HashMap<>();
          roomsInit();
      }

      private void roomsInit() {
          // Creation and linkage of rooms
      }

      public Map<String, Room> getRooms() {
          return rooms;
      }

      public Room getRoomByName(String name) {
          return rooms.get(name);
      }
  }
  ```

  ##### Event-Driven architecture

  An **Event-Driven Architecture** facilitates communnication between different parts of the system.

  **Implementation**

  - **ICommand Interface** Define a contract for all commands, allowing them to trigger events.
  
  ```java
    public interface ICommand {
      void execute();
      void parse(String[] words);
      void setEventListener(Consumer<Event> eventListener);

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
  ```

  ## Installation
  ### Prerequisites
  - JDK 8 or higher, you can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

  ### Steps

  1. **Clone the repository and Navigate to Directory**
  ```sh
  git clone https://github.com/sammcclenaghan/TextAdventure.git && cd TextAdventure
  ```

  2. **Compile the source code**
  ```sh
    javac -d bin src/computer/game/*.java src/computer/game/commands/*.java src/computer/game/gameobjects/*.java
  ```

  3. **Run the Game**
    ```sh
    java -cp bin computer.game.Game
    ```
