package computer.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import computer.game.commands.ICommand;
import computer.game.commands.LookCommand;
import computer.game.commands.TakeCommand;
import computer.game.commands.DropCommand;
import computer.game.commands.EquipCommand;
import computer.game.commands.Event;
import computer.game.commands.GoCommand;
import computer.game.gameobjects.Item;
import computer.game.gameobjects.Player;
import computer.game.gameobjects.Room;
import computer.game.gameobjects.UseCommand;
import computer.game.gameobjects.Weapon;

public class Game {
    GameController controller;

    public Game() {
        controller = new GameController();
        controller.start();
    }

    public static void main(String[] args) throws Exception {
        final Game game = new Game();
    }

    static class GameController {
        private Scanner scanner;
        private Player player;
        private Map<String, Room> rooms;
        private Map<String, ICommand> commandMap;
        private GameHelper helper;
        private Room currentRoom;

        public GameController() {
            helper = new GameHelper();
            helper.titleScreen();
            helper.printIntro();
            initializeRooms();

            scanner = new Scanner(System.in);
            commandMap = new HashMap<>();
            currentRoom = player.getLocation();

            GoCommand goCommand = new GoCommand();
            LookCommand lookCommand = new LookCommand();
            TakeCommand takeCommand = new TakeCommand();
            DropCommand dropCommand = new DropCommand();
            EquipCommand equipCommand = new EquipCommand();
            UseCommand useCommand = new UseCommand();
            InventoryCommand inventoryCommand = new InventoryCommand();

            goCommand.setEventListener(event -> handleGoEvent(event));
            lookCommand.setEventListener(event -> handleLookEvent(event));
            takeCommand.setEventListener(event -> handleTakeEvent(event));
            dropCommand.setEventListener(event -> handleDropEvent(event));
            equipCommand.setEventListener(event -> handleEquipEvent(event));
            useCommand.setEventListener(event -> handleUseEvent(event));
            inventoryCommand.setEventListener(event -> handleInventoryEvent(event));

            commandMap.put("go", goCommand);
            commandMap.put("look", lookCommand);
            commandMap.put("take", takeCommand);
            commandMap.put("drop", dropCommand);
            commandMap.put("equip", equipCommand);
            commandMap.put("use", useCommand);
            commandMap.put("inventory", inventoryCommand);
        }

        public void initializeRooms() {
            RoomInitalizer roomInit = new RoomInitalizer();
            rooms = roomInit.getRooms();
            player = new Player(rooms.get("room1"));
        }

        public void start() {
            boolean exit = false;
            while (!exit) {
                System.out.print(">> ");
                String userInput = scanner.nextLine();
                String[] words = userInput.toLowerCase().split("\\s+");

                if (words.length > 0) {
                    String commandWord = words[0];
                    ICommand command = commandMap.get(commandWord);

                    if (command != null) {
                        command.parse(words);
                    } else {
                        System.out.println("What?");
                    }
                } else {
                    System.out.println("I don't understand");
                }
            }
        }

        public void handleGoEvent(Event event) {
            if ("go".equals(event.getType())) {
                String direction = (String) event.getData();
                Room currentRoom = player.getLocation();
                Room nextRoom = currentRoom.getNeighbor(direction);
                if (nextRoom == null) {
                    System.out.println("There is no room in that direction");
                } else {
                    System.out.println(nextRoom.getDescription());
                    player.setLocation(nextRoom);
                }
            }
        }

        public void handleLookEvent(Event event) {
            if ("look".equals(event.getType())) {
                String direction = (String) event.getData();
                Room nextRoom = currentRoom.getNeighbor(direction);
                if (nextRoom == null) {
                    System.out.println("There is no room in that direction");
                } else {
                    System.out.println(nextRoom.getDescription());
                }
            }
        }

        public void handleTakeEvent(Event event) {
            if ("take".equals(event.getType())) {
                String item = (String) event.getData();
                Item roomItem = currentRoom.getItem(item);
                if (roomItem == null) {
                    System.out.println("Item not found");
                } else {
                    player.addItem(roomItem);
                    currentRoom.removeItem(roomItem);
                    System.out.println(roomItem.getName() + " was added to inventory");
                }
            }
        }

        public void handleDropEvent(Event event) {
            if ("drop".equals(event.getType()) && event.getData() != null) {
                String item = (String) event.getData();
                Item playerItem = player.getItem(item);
                if (playerItem == null) {
                    System.out.println("Item not found");
                } else {
                    currentRoom.addItem(playerItem);
                    player.removeItem(playerItem);
                    System.out.println(playerItem.getName() + " was removed to inventory");
                }
            }
        }

        public void handleEquipEvent(Event event) {
            if ("equip".equalsIgnoreCase(event.getType())) {
                Item item = player.getInventory().getItem(event.getData());
                if (item != null && item instanceof Weapon) {
                    Weapon weapon = (Weapon) item;
                    player.equipWeapon(weapon);
                } else {
                    System.out.println("Item not found");
                }
            }
        }

        public void handleUseEvent(Event event) {
            if ("use".equalsIgnoreCase(event.getType())) {
                Item item = player.getInventory().getItem(event.getData());
                if (item != null && item instanceof Potion) {
                    Potion potion = (Potion) item;
                    potion.use(player);
                } else {
                    System.out.println("Item not found");
                }
            }
        }

        public void handleInventoryEvent(Event event) {
            if ("inventory".equalsIgnoreCase(event.getType())) {
                player.getInventory().display(player);
            }
        }
    }
}