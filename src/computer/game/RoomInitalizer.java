package computer.game;

import java.util.HashMap;
import java.util.Map;

import computer.game.gameobjects.Room;
import computer.game.gameobjects.Weapon;

public class RoomInitalizer {
  private Map<String, Room> rooms;

  public RoomInitalizer() {
    rooms = new HashMap<>();
    roomsInit();
  }

  public Map<String, Room> getRooms() {
    return rooms;
  }

  private void roomsInit() {
    // Create Rooms
    Room room1 = new Room("The Twisted Entrance Hall",
        "The once grand entrance hall is now filled with distorted mirrors and crumbling pillars. A sense of disorientation envelops the room.");
    Room room2 = new Room("The Maze-like Library",
        "The library is a labyrinth of towering bookshelves, casting eerie shadows that play tricks on the eyes. The scent of ancient tomes fills the air.");
    Room room3 = new Room("The Confounding Alchemy Lab",
        "The lab is cluttered with tables covered in strangely colored potions, eldritch symbols, and bizarre contraptions. The layout seems to change with every glance.");
    Room room4 = new Room("The TreasureVault of Illusions",
        "A treasure vault filled with heaps of glittering gold and jewels, but the gleaming piles seem to shift and disappear, casting doubt on their true nature.");
    Room room5 = new Room("The Garden of Shadows",
        "A dark, twisted garden where the paths wind unpredictably. Sinister plants and creatures lurk in the shadows, blending with the surroundings.");
    Room room6 = new Room("The Hall of Shifting Statues",
        "A hall filled with lifelike statues that appear to change positions when not observed, making it difficult to retrace your steps.");
    Room room7 = new Room("The Elemental Chamber of Chaos",
        "A room with four distinct, yet intertwined elemental zones. The elements seem to ebb and flow, making it challenging to discern one zone from another.");
    Room room8 = new Room("Room 8: The Dizzying Throne Room",
        "The once-regal throne room is now a whirlwind of dark energy, causing the walls and floor to warp and undulate, disorienting the senses.");
    Room room9 = new Room("The Cursed Gallery of Distortion",
        "A gallery filled with cursed paintings that appear to warp and twist, altering the perception of the room's dimensions and making navigation a challenge.");
    // Add to Map
    rooms.put("room1", room1);
    rooms.put("room2", room2);
    rooms.put("room3", room3);
    rooms.put("room4", room4);
    rooms.put("room5", room5);
    rooms.put("room6", room6);
    rooms.put("room7", room7);
    rooms.put("room8", room8);
    rooms.put("room9", room9);
    room1.setNeighbor("north", room2);
    room1.setNeighbor("south", room5);
    room1.setNeighbor("east", room4);
    room1.setNeighbor("west", room6);
    room1.addItem(new Weapon("Sword", "A sword", 20));
    room1.addItem(new Potion("Potion", "A new potion", 20));

    room2.setNeighbor("north", room3);
    room2.setNeighbor("south", room1);
    room2.setNeighbor("east", room5);
    room2.setNeighbor("west", room4);

    room3.setNeighbor("north", room4);
    room3.setNeighbor("south", room2);
    room3.setNeighbor("east", room6);
    room3.setNeighbor("west", room5);

    room4.setNeighbor("north", room5);
    room4.setNeighbor("south", room3);
    room4.setNeighbor("east", room1);
    room4.setNeighbor("west", room2);

    room5.setNeighbor("north", room6);
    room5.setNeighbor("south", room4);
    room5.setNeighbor("east", room3);
    room5.setNeighbor("west", room1);

    room6.setNeighbor("north", room1);
    room6.setNeighbor("south", room5);
    room6.setNeighbor("east", room2);
    room6.setNeighbor("west", room3);

    room7.setNeighbor("north", room8);
    room7.setNeighbor("south", room6);
    room7.setNeighbor("east", room9);

    room8.setNeighbor("north", room9);
    room8.setNeighbor("south", room7);
    room8.setNeighbor("west", room6);

    room9.setNeighbor("south", room8);
    room9.setNeighbor("east", room6);
    room9.setNeighbor("west", room7);
  }

  public Room getRoomByName(String name) {
    return rooms.get(name);
  }
}
