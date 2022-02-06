package ex3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;
    private String optionChoice;

    @BeforeEach
    void setUp() {
        menu = new Menu(optionChoice);
    }

    @AfterEach
    void tearDown() {
        menu = null;
    }

    @Test
    public void checkMenu(){
        assertNotNull(menu);
    }
}