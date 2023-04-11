package computer.game;

import java.util.Scanner;

public class GameHelper {
  private static Scanner input = new Scanner(System.in);

  public void titleScreen() {
    System.out.println("┌─────────────────────────────────────────────────┐");
    System.out.println("│                                                 │");
    System.out.println("│        The Cursed Relics of Drakenholme         │");
    System.out.println("│                                                 │");
    System.out.println("│                A Text Adventure                 │");
    System.out.println("│                                                 │");
    System.out.println("└─────────────────────────────────────────────────┘");
    System.out.println("");
    anythingToContinue();
  }

  static void anythingToContinue() {
    System.out.print("\nEnter anything to continue...");
    input.nextLine();
  }

  public void printIntro() {
    System.out.println(
        """
            In a land of magic and mystery, the once-magnificent Castle of Aetheria has fallen under a sinister curse. The once-great chambers and halls have warped into a twisted labyrinth, filled with dark energy and strange creatures. The relics that once protected the castle have been scattered throughout its rooms, and only by finding and returning these relics to their rightful place can the curse be lifted.

            As you take your first steps into the Twisted Entrance Hall, you realize that your journey will be anything but ordinary. The distorted mirrors and crumbling pillars give way to an eerie sense of disorientation, making you question the very fabric of reality.
              """);
  }

}
