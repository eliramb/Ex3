package ex3;

public class EasyLevel implements IGameLevel{
    // returns a column number within 0...COLUMNS, -1 if board is full
    /*public static int computerChoice(Position position) {
        int emptyrow= 0;
        // first check if a move can win
        for (int i=0; i<position.COLUMNS; i++) {
            if (!isColumnFull(board,i)) {
                emptyrow = firstEmptyRow(board,i);
                board[emptyrow][i] = XPLAYER;
                if (winningDisk(board, emptyrow, i)) {
                    board[emptyrow][i] = EMPTY; // reset
                    return i;
                }
                board[emptyrow][i] = EMPTY; // reset
            }
        }
        // otherwise then pick up any move that will prevent other player to win
        // in case there is a win on next turn
        int counter = 0; // i count other player possible winnings
        int chosenrow = 0;
        for (int i=0; i<position.COLUMNS; i++) {
            if (!isColumnFull(board,i)) {
                emptyrow = firstEmptyRow(board,i);
                board[emptyrow][i] = OPLAYER; // assume the other player does this
                if (winningDisk(board, emptyrow, i)) {
                    board[emptyrow][i] = EMPTY; // reset
                    counter++; // we found a winning disc
                    chosenrow = i; // remember the row
                }
                board[emptyrow][i] = EMPTY; // reset
            }
        }
        // we block the player if there is exactly one winning disc
        if (counter==1) return chosenrow;

        // else if other player wins no matter what, pick up first non full column
        for (int i=0; i<position.COLUMNS; i++)
            if (!isColumnFull(board,i)){
                return i;
            }
        return -1;

    }*/
}
