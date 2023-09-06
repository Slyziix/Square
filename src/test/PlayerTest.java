package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.Piece;
import main.Player;
import main.PlayerColor;

public class PlayerTest {

    Player player = new Player(PlayerColor.BLUE);

    @Test
    public void testRemovePiece() {
        assertTrue(this.player.getAvailablePieces().contains(Piece.PIECE_A));
        this.player.removePiece(Piece.PIECE_A);
        assertFalse(this.player.getAvailablePieces().contains(Piece.PIECE_A));
        assertTrue(this.player.getAvailablePieces().contains(Piece.PIECE_J));
        this.player.removePiece(Piece.PIECE_J);
        assertFalse(this.player.getAvailablePieces().contains(Piece.PIECE_J));
        assertTrue(this.player.getAvailablePieces().contains(Piece.PIECE_P));
        this.player.removePiece(Piece.PIECE_P);
        assertFalse(this.player.getAvailablePieces().contains(Piece.PIECE_P));
        assertTrue(this.player.getAvailablePieces().contains(Piece.PIECE_U));
        this.player.removePiece(Piece.PIECE_U);
        assertFalse(this.player.getAvailablePieces().contains(Piece.PIECE_U));
    }

    @Test
    public void testCalculateScore(){
        assertEquals(-89, this.player.calculateScore());
        this.player.removePiece(Piece.PIECE_A);
        assertEquals(-88, this.player.calculateScore());
        this.player.removePiece(Piece.PIECE_J);
        assertEquals(-83, this.player.calculateScore());
        this.player.removePiece(Piece.PIECE_P);
        assertEquals(-78, this.player.calculateScore());
        this.player.removePiece(Piece.PIECE_U);
        assertEquals(-73, this.player.calculateScore());
        this.player.setAvailablePieces(new ArrayList<Piece>());
        assertEquals(10, this.player.calculateScore());
    }
}
