import javax.swing.*;
import java.util.Scanner;

public class Game { //We create a class to write main flow of our game.

    private final Scanner scan = new Scanner(System.in);

    public void start () {
        boolean isPlaying = true;


        while (isPlaying) {
            isPlaying = false;

            System.out.println("Welcome to Adventure Game!");
            System.out.println("Insert name: ");
            //Ask name to user
            String playerName = scan.nextLine();
            //Create an object from Player class with given player name
            Player player = new Player(playerName);
            System.out.println(player.getName()+ "Welcome to Adventure Island!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("To start adventure select a character: ");
            //Call selectChar method from Player class
            player.selectChar();

            boolean quit = false;


            while (true) {
                Location location = null;
                player.printInfo();
                System.out.println();
                System.out.println("### Locations ###");
                System.out.println();
                System.out.println("1- Safe House --> No enemy here. You are safe!");
                System.out.println("2- Tool Store --> Buy equipment from here!");
                System.out.println("3- Cave --> Reward : Food ### Watch out! Zombies are around!");
                System.out.println("4- Forest --> Reward : Firewood ### Watch out! Vampires are around!");
                System.out.println("5- River --> Reward : Water #### Watch out! Bears are around!");
                System.out.println("6- Mine --> Reward : Either Money, Gun, Armor or Nothing ### Watch out! Snakes are around!");
                System.out.println("0- Quit --> Quit");

                if (player.wonGame()) {
                    System.out.println("Go to Safe House to win game!");
                }

                System.out.print("Which location do you want to go now: ");
                int selectLoc = scan.nextInt();

                switch (selectLoc) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:
                        if (!player.getInventory().getHasFood()) {
                            location = new Cave(player);
                        } else {
                            System.out.println("All obstacles are defeated!");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Select another location: ");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println();
                        }
                        break;
                    case 4:
                        if (!player.getInventory().getHasFireWood()) {
                            location = new Forest(player);
                        } else {
                            System.out.println("All obstacles are defeated!");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Select another location: ");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println();
                        }
                        break;
                    case 5:
                        if (!player.getInventory().getHasWater()) {
                            location = new River(player);
                        } else {
                            System.out.println("All obstacles are defeated!");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Select another location: ");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println();
                        }
                        break;
                    case 6:
                        location = new Mine(player);
                        break;
                    default:
                        System.out.println("Select a valid location!");
                }

                if (quit) {
                    System.out.println("You gave up! Bye!");
                    break;
                }

                if (location != null && !location.onLocation()){
                    System.out.println("GAME OVER!");
                    System.out.println("Play Again: <1>YES <2>NO");
                    int playAgain = scan.nextInt();
                    scan.nextLine();
                    if (playAgain==1) {
                        isPlaying=true;
                    }
                    System.out.println();
                    break;
                }
                if (player.wonGame() && selectLoc==1) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    player.printInfo();
                    System.out.println();
                    System.out.println("YOU WON GAME!");
                    break;

                }
            }
        }
    }
}
