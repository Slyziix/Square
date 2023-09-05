package main;

import java.awt.Color;

public class Board {
    private PlayerColor[][] board;
    private static PlayerColor CURRENT_PLAYER = PlayerColor.RED;

    public Board() {
        board = new PlayerColor[20][20];
    }

    public void initialise() {
        for (int i = 0; i < this.board.length; ++i) {
            for (int j = 0; j < this.board[i].length; ++j) {
                this.board[i][j] = PlayerColor.WHITE;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < this.board.length; ++i) {
            for (int j = 0; j < this.board[i].length; ++j) {
                PlayerColor cellColor = board[i][j];
                Color foregroundColor = cellColor.getColor();
                String square = "\u25A0 "; // "■"

                System.out.print("\u001B[38;2;" + foregroundColor.getRed() + ";" + foregroundColor.getGreen() + ";"
                        + foregroundColor.getBlue() + "m" + square + "\u001B[0m");
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

    public PlayerColor[][] getBoard() {
        return board;
    }

    public void placeShape(Position p, Board b, PlayerColor pcolor, Piece shape) {
        if (Rules.checkDisponibility(b, p, shape) && Rules.checkSurrondings(b, p, shape, pcolor)) {
            int x = p.getX();
            int y = p.getY();

            for (int i = 0; i < shape.getForm().length; ++i) {
                for (int j = 0; j < shape.getForm()[i].length; ++j) {
                    if (shape.getForm()[i][j])
                        b.setColorAt(new Position(x + i, y + j));
                }
            }
        }

    }

    public static void main(String[] args) {
        Board b = new Board();
        b.initialise();

        b.setColorAt(new Position(5, 5));
        b.setColorAt(new Position(6, 5));

        b.placeShape(new Position(7, 5), b, PlayerColor.RED, Piece.PIECE_F);

        b.displayBoard();
    }

}