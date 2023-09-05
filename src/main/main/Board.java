

import java.awt.Color;

public class Board {
    private PlayerColor[][] board;
    private static final PlayerColor CURRENT_PLAYER = PlayerColor.RED;

    public Board() {
        board = new PlayerColor[20][20];
    }

    public void initialise() {
        for (int i =0; i< this.board.length; ++i) {
            for (int j =0; j< this.board[i].length; ++j) {            
                this.board[i][j] = PlayerColor.WHITE;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < this.board.length; ++i) {
            for (int j = 0; j < this.board[i].length; ++j) {
                PlayerColor cellColor = board[i][j];
                Color foregroundColor = cellColor.getColor();
                String square = "\u25A0"; // Le caractère "■"
    
                // Vous pouvez maintenant afficher le caractère "■" avec la couleur du texte
                System.out.print("\u001B[38;2;" + foregroundColor.getRed() + ";" + foregroundColor.getGreen() + ";" + foregroundColor.getBlue() + "m" + square + "\u001B[0m");
            }
            System.out.println();
        }
    }
    

    public void setColorAt(Position position) {
        if (isValidCoordinate(position)) {
            this.board[position.getX()][position.getY()] = CURRENT_PLAYER;
        } else {
            System.out.println("Coordonnées invalides.");
        }
    }

    private boolean isValidCoordinate(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.initialise();
        b.displayBoard();

        // Exemple d'utilisation de setColorAt
        int x = 5;
        int y = 5;
        b.setColorAt(new Position(x, y));

        // Afficher le tableau après avoir changé la couleur à la position (x, y)
        b.displayBoard();
    }

}