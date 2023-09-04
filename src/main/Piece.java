package main;

public enum Piece{
    PIECE_A(new boolean[][]{{true}}),
    PIECE_B(new boolean[][]{{true,true}}),
    PIECE_C(new boolean[][]{{true,true,true}}),
    PIECE_D(new boolean[][]{{true,true},{false,true}});

    private boolean[][] form;
    
    Piece(boolean[][] form){
        this.form=form;
    }

    public boolean[][] getForm(){
        return this.form;
    }
}