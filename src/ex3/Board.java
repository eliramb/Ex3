package ex3;

public class Board implements IBoard {
    public Disc[] Discs;
    public char[][] board;
    @Override
    public void DecorateBoard() {
    }

    public void AlignDisc(Position pos, Disc disc){

    }

    public boolean IsColumnFull(int col){
        throw new RuntimeException("need to implements method");
       // return true;
    }
}
