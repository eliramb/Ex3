package ex3;

import java.util.Scanner;
import java.util.Vector;

public class Game {

    int col;
    int row;

    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';
    public static char EMPTY = ' ';

    public boolean gameover = false;
    public boolean computerplays;
    public IPlayer currentPlayer;

    //array of two players :  man- man or man-computer
    public Vector<IPlayer> Players;

    //for multiple ui notification which intends to implement "Observer" design pattern
    public GameManager gameManager;

    public Vector<Menu> gameMenu;

    public Game() {
        InitGameMenu();
        Players = new Vector<>();
        gameManager = new GameManager();
    }

    //init the game menu
    private void InitGameMenu() {
        String quit ="0. Exit";
        String play_friend = "1. Play against friend";
        String play_pc = "2. Play against computer";

        Menu m1 = new Menu(quit);
        Menu m2 = new Menu(play_friend);
        Menu m3 = new Menu(play_pc);

        gameMenu = new Vector<>() ;

        AddMenu(m1);
        AddMenu(m2);
        AddMenu(m3);
    }

    public void AddMenu(Menu menu){
        gameMenu.add(menu);
    }

    //print the menu
    public void PrintMenu(){
        for (Menu menu : gameMenu) {
            menu.printMenu();
        }
        System.out.print("Please choose an option:");
    }

    //add Player
    public void AddPlayer(IPlayer player ){
        Players.add(player);
    }

    public boolean IsComputerPlayer(IPlayer player){
        try{
            var p = (ComputerPlayer)player;
            return p!=null;
        }
        catch (Exception ignored){

        }
        return false;
    }

    public static int playerNum (IPlayer player) {
        var asbPlayer = (AbstractPlayer)player;
        if (asbPlayer.discType.type==XPLAYER) return 2; else return 1;
    }

    public void Play(Scanner terminalInput) {
        Board board=((AbstractPlayer)currentPlayer).board;
        System.out.println("Starting a game of 'Four in a Line'.");
        do {
            // loop as long as the chosen column is full
            // we request the player to enter a column which is not full
            do {
                if (computerplays &&  IsComputerPlayer(currentPlayer)) {
                    ComputerPlayer cp = (ComputerPlayer)currentPlayer;
                    Position p = cp.gameLevel.ComputerChoice(cp.board);
                    col = p.col;
                    System.out.print("Computer put a disk in column ");
                    System.out.println(col+1);
                    //System.out.println();
                } else {
                    System.out.print("Player " + playerNum(currentPlayer) + ", choose a column: ");
                    col = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
                    col--; // the real index
                }

                row = -1;

                // is this really a column number?
                if (col<0 || col>=board.COLUMNS)
                    System.out.println("Illegal column number");
                else
                    // find the row and check if winning
                    if (board.isColumnFull(col)) {
                        row = board.firstEmptyRow(col);
                        System.out.println();
                    } else
                        // column is full, try again
                        System.out.println("Column is full.");

            } while (row==-1);
            // now we have a valid (row,col) cell
            Position position=new Position(row, col);

            currentPlayer.alignDisc(position);

            // in any case we print the board
            board.printBoard();

            if (board.winningDisk(position)) {
                gameover = true;
                showWinner(currentPlayer,computerplays);
            } else
            if (board.boardIsFull()) {
                gameover = true;
                showWinner(currentPlayer,computerplays); // tie
            }
            // switch to next player
            changePlayer();

        } while (!gameover);
    }

    public void changePlayer() {
        var player = (AbstractPlayer)currentPlayer;
        if(Players.get(0) == currentPlayer){
            currentPlayer = Players.get(1);
        }
        else currentPlayer = Players.get(0);
    }

    public static void showWinner(IPlayer winner,boolean isComp) {
        if (winner == null)
            System.out.print("Board is full! game has ended with a tie!");
        else
        if (isComp && playerNum(winner)==2) System.out.println("Game has ended! The computer won!");
        else System.out.println("Game has ended! Player " + playerNum(winner) + " won!");
        System.out.println();
    }
}