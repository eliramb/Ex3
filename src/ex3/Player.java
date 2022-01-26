package ex3;

public class Player extends AbstractPlayer {

    public Player(char _playerChar, Board _board) {
        super();
        board = _board;
        discType = new DiscType(_playerChar);
    }

    @Override
    public Position alignDisc(Position position) {
        board.alignDisc(position, discType);
        return position;
    }


}
