package ex3;

public class ComputerPlayer extends AbstractPlayer {

    public IGameLevel gameLevel;

    @Override
    public Position alignDisc(Position position) {
        return gameLevel.ComputerChoice(board);
    }
}
