package main;

public class Board {
    private Color[][] board;

    public Board() {
        board = new Color[20][20];
    }

    public void initialise() {
        for (int i =0; i< this.board.length; ++i) {
            for (int j =0; j< this.board[i].length; ++j) {            
                this.board[i][j] = Color.WHITE;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i< this.board.length; ++i) {
            for (int j = 0; j< this.board[i].length; ++j) {  
                System.out.print(board[i][j].getColor() + "\u25A0" + Color.WHITE.getColor());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.initialise();
        b.displayBoard();
    }
}