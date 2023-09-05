package main;

import java.util.List;

public class Player {

    private List<Piece> availablePieces;
    private int score;
    private PlayerColor color;

    public Player(List<Piece> availablePieces, int score, Color color) {
        this.availablePieces = availablePieces;
        this.score = score;
        this.color = color;
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
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
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

    }
}
