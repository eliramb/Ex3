package ex3;
import java.util.Scanner;
public class FourInRow {

    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner terminalInput = new Scanner(System.in);

        System.out.println("Welcome to Four in a Line!");

        int choice=-1;
        while(true) {

            Game game = new Game();
            choice = getChoice(terminalInput, choice, game);

            if(choice==0){
                System.out.println("Bye bye!!!");
                terminalInput.close();
                return;
            }

            Board board = new Board();
            board.printBoard();

            Player player1 = new Player(OPLAYER,board);//first human player
            game.Players.add(player1);
            game.currentPlayer = player1;

            IPlayer player2=null;
            if(choice==1){
                player2 = new Player(XPLAYER,board);//Second human player
            }
            if(choice==2){
                player2 =new ComputerPlayer(XPLAYER, board);
                game.computerplays = true;
            }
            game.Players.add(player2);

            game.Play(terminalInput);
        }
    }

    private static int getChoice(Scanner terminalInput, int choice, Game game) {
        boolean badchoice;
        do {
            game.PrintMenu();
            String sChoice = terminalInput.nextLine();
            if(isInteger(sChoice)) {
                choice = Integer.parseInt(sChoice);
                badchoice = choice < 0 || choice > 2;
            }
            else{
                badchoice=true;
            }
            if (badchoice) System.out.println("Input incorrect! Please try again.");

        }while(badchoice);
        return choice;
    }
}
