package ILD18MSM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

;

class MainTest {


    @Test
    public void caluclateNumbeOfMoves() {
        int out = Main.caluclateNumbeOfMoves("aab", "aab");
        assertEquals(0, out);
    }


    @Test
    public void caluclateNumbeOfMovesSwapNeeded() {
        int out = Main.caluclateNumbeOfMoves("baaaaaaa", "aaaaaaba");
        assertEquals(2, out);
    }
}