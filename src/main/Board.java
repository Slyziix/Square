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
        System.out.print(" ");
        for (int i = 0; i < this.board.length; ++i) {
            char[] c = Character.toChars('A' + i);
            System.out.print(" " + c[0]);
        }
        System.out.println();
        for (int i = 0; i < this.board.length; ++i) {
            char[] c = Character.toChars('A' + i);
            System.out.print(c[0] + " ");
            for (int j = 0; j < this.board[i].length; ++j) {
                PlayerColor cellColor = board[i][j];
                Color foregroundColor = cellColor.getColor();
                String square = "\u25A0 "; // "■"

                System.out.print("\u001B[38;2;" + foregroundColor.getRed() + ";" + foregroundColor.getGreen() + ";"
                        + foregroundColor.getBlue() + "m" + square + "\u001B[0m");
            }
            System.out.print(c[0]);
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < this.board.length; ++i) {
            char[] c = Character.toChars('A' + i);
            System.out.print(" " + c[0]);
        }
        System.out.println();
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

    public boolean placeShape(Position p, Board b, Player player, boolean[][] shape, int turn) {
        PlayerColor pcolor = player.getColor();
        CURRENT_PLAYER = pcolor;

        if (turn == 0) {
            if (Rules.checkDisponibility(b, p, shape)) {
                int x = p.getX();
                int y = p.getY();

                boolean placementOK = false;
                for (int i = 0; i < shape.length; ++i) {
                    for (int j = 0; j < shape[i].length; ++j) {
                        if (shape[i][j] && (x + i) == pcolor.getPosition().getX()
                                && (y + j) == pcolor.getPosition().getY()) {
                            placementOK = true;
                        }
                    }
                }

                for (int i = 0; i < shape.length; ++i) {
                    for (int j = 0; j < shape[i].length; ++j) {
                        if (shape[i][j])
                            b.setColorAt(new Position(x + i, y + j));
                    }
                }

                return placementOK;
            }
        } else if (Rules.checkDisponibility(b, p, shape) && Rules.checkSurrondings(b, p, shape, pcolor)) {
            int x = p.getX();
            int y = p.getY();

            for (int i = 0; i < shape.length; ++i) {
                for (int j = 0; j < shape[i].length; ++j) {
                    if (shape[i][j])
                        b.setColorAt(new Position(x + i, y + j));
                }
            }

            return true;
        }
        return false;
    }
}