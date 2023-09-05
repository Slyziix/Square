package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Piece;

public class PieceTest {

    @Test
    public void testGetForm() {
        assertEquals(1, Piece.PIECE_A.getForm().length);
        assertEquals(1, Piece.PIECE_A.getForm()[0].length);
        assertTrue(Piece.PIECE_A.getForm()[0][0]);
        assertEquals(3, Piece.PIECE_G.getForm().length);
        assertEquals(2, Piece.PIECE_G.getForm()[0].length);
        assertTrue(Piece.PIECE_R.getForm()[0][0]);
        assertFalse(Piece.PIECE_R.getForm()[1][0]);
        assertFalse(Piece.PIECE_R.getForm()[2][0]);
        assertTrue(Piece.PIECE_R.getForm()[0][1]);
        assertTrue(Piece.PIECE_R.getForm()[1][1]);
        assertFalse(Piece.PIECE_R.getForm()[2][1]);
        assertFalse(Piece.PIECE_R.getForm()[0][2]);
        assertTrue(Piece.PIECE_R.getForm()[1][2]);
        assertTrue(Piece.PIECE_R.getForm()[2][2]);
    }
    
}
