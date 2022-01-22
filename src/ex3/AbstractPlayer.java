package ex3;

public abstract class AbstractPlayer implements IPlayer {
    DiscType discType;
    Board board;

    public abstract Position alignDisc(Position position);

}
