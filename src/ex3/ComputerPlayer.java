package ex3;

public class ComputerPlayer extends AbstractPlayer {

    public IGameLevel gameLevel;

    public ComputerPlayer(char playerChar, Board _board) {
        super();
        board = _board;
        discType = new DiscType(playerChar);
        gameLevel = new EasyLevel();
    }

    @Override
    public Position alignDisc(Position position) {
        board.alignDisc(position, discType);
        return position;
    }
}
