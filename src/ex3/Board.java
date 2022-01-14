package ex3;

public class Board implements IBoard {
    public Disc[] Discs;
    public char[][] board;
    Position position;
    int WIN;
    @Override
    public void DecorateBoard() {
    }

    public void AlignDisc(Position pos, Disc disc){

    }

    public boolean isColumnFull(int col){
        for (int i = 0; i < position.getROWS(); i++) {
            if (board[i][col] == ' ')//EMPTY)
                return false;
        }
        return true;
    }
    public int firstEmptyRow(int col)
    {
        for (int i = position.getCOLUMNS()-1; i >=0; i--) {
            if (board[i][col] == ' ')return i;//EMPTY) return i;
        }
        return -1;
    }
    // is the disc at board[rowIndex][colIndex] winning?
    public boolean winningDisk(int row, int col)
    {
        char c = board[row][col];
        int count = 1;

        // horizontal right
        for (int i=col+1; i < col; i++) {
            if (board[row][i]==c)
                count++;
            else break;
        }
        if (count >= WIN) return true; // won horizontally
        // keep counting horizontal left
        for (int i=col-1; i >=0; i--) {
            if (board[row][i]==c)
                count++;
            else break;
        }
        if (count >= WIN) return true; // won horizontally

        count = 1;
        // vertical down
        for (int i=row+1; i < position.getROWS(); i++) {
            if (board[i][col]==c)
                count++;
            else break;
        }
        if (count >= WIN) return true; // won vertical
        // keep counting vertical up
        for (int i=row-1; i >=0; i--) {
            if (board[i][col]==c)
                count++;
            else
                break;
        }
        if (count >= WIN) return true; // won vertical

        // first diagonal:  /
        count = 1;
        // up
        int kol = col+1;
        for (int i=row-1; i >= 0; i--) {
            if (kol>=position.getCOLUMNS()) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= WIN) return true;
        // keep counting down
        kol = col-1;
        for (int i=row+1; i < position.getROWS(); i++) {
            if (kol<0) break; // we reached the end of the board left side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol--;
        }
        if (count >= WIN) return true; // won diagonal "/"

        // second diagonal : \
        count = 1;
        // up
        kol = col-1;
        for (int i=row-1; i >= 0; i--) {
            if (kol<0) break; // we reached the end of the board left side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol--;
        }
        if (count >= WIN) return true; // won diagonal "\"
        // keep counting down
        kol = col+1;
        for (int i=row+1; i < position.getROWS(); i++) {
            if (kol>= position.getCOLUMNS()) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= WIN) return true; // won diagonal "\"

        return false;
        }
    public void setDisc(int row, int col, char disc)
    {
        board[row][col] = disc;
    }
    public boolean boardIsFull() {
        // it's enough to check top row
        for (int i=0; i<position.getCOLUMNS(); i++)
            if (board[0][i]== ' ') return false;//EMPTY) return false;
        return true;
    }

    public void printBoard() {
        System.out.println("Printing board:");
        System.out.println();
        for (int j = 0; j < position.getROWS(); j++) {
            System.out.print("|");
            for (int k = 0; k < position.getCOLUMNS(); k++)
                System.out.print(board[j][k] + "|");
            System.out.println();
        }
        for (int k = 0; k < 2* position.getCOLUMNS()+1; k++)
            System.out.print("-");
        System.out.println();
        System.out.println();
    }
}
