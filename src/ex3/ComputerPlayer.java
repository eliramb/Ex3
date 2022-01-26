package ex3;

public class ComputerPlayer extends AbstractPlayer {

    public IGameLevel gameLevel;
    public ComputerPlayer(){
        super();
        gameLevel = new EasyLevel();
    }
    public ComputerPlayer(char _playerChar, Board _board) {
        super();
        board = _board;
        discType = new DiscType(_playerChar);
        gameLevel = new EasyLevel();
    }

    @Override
    public Position alignDisc(Position position) {
        //return gameLevel.ComputerChoice(board);
        board.alignDisc(position, discType);
        return position;
    }
}
