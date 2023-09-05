package main;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Piece> availablePieces;
    private int score;
    private PlayerColor color;

    public static void main(String[] str) {
        Player player = new Player(PlayerColor.BLUE);
        System.out.println(player.getAvailablePieceTotalLength());
    }

    public Player(List<Piece> availablePieces, int score, PlayerColor color) {
        this.availablePieces = availablePieces;
        this.score = score;
        this.color = color;
    }

    public Player(PlayerColor color) {
        this(new ArrayList<Piece>(), 0, color);
        for(int i = 0; i < Piece.values().length; i++) {
            this.availablePieces.add(Piece.values()[i]);
        }
    }
    
    public List<Piece> getAvailablePieces() {
        return availablePieces;
    }
    public void setAvailablePieces(List<Piece> availablePieces) {
        this.availablePieces = availablePieces;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public PlayerColor getColor() {
        return color;
    }
    public void setColor(PlayerColor color) {
        this.color = color;
    }

    public boolean removePiece(Piece piece) {
        return availablePieces.remove(piece);
    }

    private int getAvailablePieceTotalLength() {
        int length = 0;
        for(int i = 0; i < this.availablePieces.size(); i++) {
            length += this.availablePieces.get(i).getForm()[0].length;
        }
        return length;
    }

    public String getAvailablePiecesString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.getAvailablePieces().size(); i++) {
            //f(this.getAvailablePieces().get(i).getForm().length)

        }
        return "";

    }
}
