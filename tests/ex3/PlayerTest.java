package ex3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    private char playerChar;

    @BeforeEach
    void setUp() {
        player = new Player(playerChar, new Board());
    }

    @AfterEach
    void tearDown() {
        player = null;
    }

    @Test
    void checkPlayer() {
        assertNotNull(player);
    }
}