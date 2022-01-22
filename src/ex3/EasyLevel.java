package ex3;

public class EasyLevel implements IGameLevel{
    private char XPLAYER = 'X';
    private char OPLAYER = 'O';
    private char EMPTY = ' ';

    @Override
    public Position ComputerChoice(Board board) {
    // returns a column number within 0...COLUMNS, -1 if board is full
        int emptyrow= 0;
        Position position=new Position();
        // first check if a move can win
        for (int i=0; i<board.COLUMNS; i++) {
            if (!board.isColumnFull(i)) {
                emptyrow = board.firstEmptyRow(i);
                board.alignDisc(emptyrow, i, XPLAYER);
                if (board.winningDisk(emptyrow, i)) {
                    board.alignDisc(emptyrow, i, EMPTY); // reset
                    position.row = emptyrow;
                    position.col = i;
                    //return i;
                    return position;
                }
                board.alignDisc(emptyrow, i, EMPTY); // reset
            }
        }
        // otherwise then pick up any move that will prevent other player to win
        // in case there is a win on next turn
        int counter = 0; // i count other player possible winnings
        int chosenrow = 0;
        for (int i=0; i<board.COLUMNS; i++) {
            if (!board.isColumnFull(i)) {
                emptyrow = board.firstEmptyRow(i);
                board.alignDisc(emptyrow, i, OPLAYER); // assume the other player does this
                if (board.winningDisk(emptyrow, i)) {
                    board.alignDisc(emptyrow, i, EMPTY); // reset
                    counter++; // we found a winning disc
                    chosenrow = i; // remember the row
                }
                board.alignDisc(emptyrow, i, EMPTY); // reset
            }
        }
        // we block the player if there is exactly one winning disc

        if (counter==1){
            position.row = emptyrow;
            position.col = chosenrow;
           // return chosenrow;
            return position;
        }

        // else if other player wins no matter what, pick up first non full column
        for (int i=0; i<board.COLUMNS; i++)
            if (!board.isColumnFull(i)){
                position.row = emptyrow;
                position.col = i;
                //return i;
                return position;
            }
        return null;
    }
}
