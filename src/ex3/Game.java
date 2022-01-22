package ex3;

import java.util.Scanner;

public class Game {

    int col;
    int row;
    public boolean gameover;
    public boolean computerplays;
    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';
    public static char EMPTY = ' ';

    Board board;
    public Player humanPlayer;
    public ComputerPlayer computerPlayer;
    public GameManager gameManager;

    public Game() {
/*        board = new Board();
        gameover = false;
        computerplays = false;
    }

    public static int playerNum (char c) {
        if (c==XPLAYER) return 2; else return 1;
    }

    public static void changePlayer() {
        if (currentPlayer == OPLAYER)
            currentPlayer = XPLAYER;
        else currentPlayer = OPLAYER;
    }

    public static void showWinner(char winner,boolean isComp) {
        if (winner == EMPTY)
            System.out.print("Board is full! game has ended with a tie!");
        else
        if (isComp && playerNum(winner)==2) System.out.println("Game has ended! The computer won!");
        else System.out.println("Game has ended! Player " + playerNum(winner) + " won!");
        System.out.println();
    }

    public void game(){
            // start the game
            board.initializeBoard();
            System.out.println();

            board.printBoard(); // empty board
            System.out.println("Starting a game of 'Four in a Line'.");

            currentPlayer = OPLAYER;
            gameover = false;

            //computerplays = false;
            //if (choice == 2) computerplays = true;

            do {
                // loop as long as the chosen column is full
                // we request the player to enter a column which is not full
                do {
                    if (computerplays && currentPlayer==XPLAYER) {
                        col = computerChoice();
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
                        if (!board.isColumnFull(col)) {
                            row = board.firstEmptyRow(col);
                            System.out.println();
                        } else
                            // column is full, try again
                            System.out.println("Column is full.");

                } while (row==-1);
                // now we have a valid (row,col) cell

                board.setDisc(row,col,currentPlayer);

                // in any case we print the board
                board.printBoard();

                if (board.winningDisk(row, col)) {
                    gameover = true;
                    showWinner(currentPlayer,computerplays);
                } else
                if (board.boardIsFull()) {
                    gameover = true;
                    showWinner(EMPTY,computerplays); // tie
                }
                // switch to next player
                changePlayer();

            } while (!gameover);
        }

    public void addPlayer(){

    }
}*/
    }
}