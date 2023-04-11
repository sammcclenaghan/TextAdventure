package computer.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import computer.game.commands.ICommand;
import computer.game.commands.LookCommand;
import computer.game.commands.Event;
import computer.game.commands.GoCommand;
import computer.game.gameobjects.Player;
import computer.game.gameobjects.Room;

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

        public GameController() {
            helper = new GameHelper();
            helper.titleScreen();
            helper.printIntro();
            initializeRooms();

            scanner = new Scanner(System.in);
            commandMap = new HashMap<>();

            GoCommand goCommand = new GoCommand(null);
            LookCommand lookCommand = new LookCommand(null);

            goCommand.setEventListener(event -> handleGoEvent(event));
            lookCommand.setEventListener(event -> handleLookEvent(event));

            commandMap.put("go", goCommand);
            commandMap.put("look", lookCommand);
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
                Room currentRoom = player.getLocation();
                Room nextRoom = currentRoom.getNeighbor(direction);
                if (nextRoom == null) {
                    System.out.println("There is no room in that direction");
                } else {
                    System.out.println(nextRoom.getDescription());
                }
            }
        }
    }
}