package ex3;

import java.util.Scanner;

public class GameController {
    Menu menu;
    public void gameControl() {
        Scanner terminalInput = new Scanner(System.in);

        int choice;
        boolean badchoice = true;
        Game game;

        System.out.println("Welcome to Four in a Line!");

        // each loop is a new game
        while (true) {

            do {
                badchoice = false;
                menu.printMenu();
                choice = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
                badchoice = choice < 0 || choice > 2;
                if (badchoice) System.out.println("Input incorrect! Please try again.");
            } while (badchoice);
        switch (choice){
            // 0: quit the game
            case 0:
                System.out.println("Bye bye!");
                terminalInput.close();
                return;
            case 1:
                break;
                case 2:
                    break;

            }
        }
}
}