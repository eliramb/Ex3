package ex3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EasyLevelTest {
    private EasyLevel easyLevel;
    private Board board;
    Position position;

    @BeforeEach
    void setUp() {
        easyLevel = new EasyLevel();
        board = new Board();
        position = new Position(-1,0);
    }

    @AfterEach
    void tearDown() {
        easyLevel = null;
        board = null;
    }

    @Test
    void computerChoice() {
        board.initializeBoard();
        assertEquals(easyLevel.ComputerChoice(board).row,position.row);
        assertEquals(easyLevel.ComputerChoice(board).col,position.col);
    }
}