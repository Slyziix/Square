package main;

public enum Piece{
    PIECE_A(new boolean[][]{{true}}),
    PIECE_B(new boolean[][]{{true},{true}}),
    PIECE_C(new boolean[][]{{true},{true},{true}}),
    PIECE_D(new boolean[][]{{true,false},{true,true}}),
    PIECE_E(new boolean[][]{{true},{true},{true},{true}}),
    PIECE_F(new boolean[][]{{false,true},{false,true},{true,true}}),
    PIECE_G(new boolean[][]{{true,false},{true,true},{true, false}}),
    PIECE_H(new boolean[][]{{true,true},{true,true}}),
    PIECE_I(new boolean[][]{{true,true,false},{false,true,true}}),
    PIECE_J(new boolean[][]{{true},{true},{true},{true},{true}}),
    PIECE_K(new boolean[][]{{false,true},{false,true},{false,true},{true,true}}),
    PIECE_L(new boolean[][]{{false,true},{false,true},{true,true},{true,false}}),
    PIECE_M(new boolean[][]{{false,true},{true,true},{true,true}}),
    PIECE_N(new boolean[][]{{true,true},{false,true},{true,true}}),
    PIECE_O(new boolean[][]{{true,false},{true,true},{true,false},{true,false}}),
    PIECE_P(new boolean[][]{{false,true,false},{false,true,false},{true,true,true}}),
    PIECE_Q(new boolean[][]{{true,false,false},{true,false,false},{true,true,true}}),
    PIECE_R(new boolean[][]{{true,true,false},{false,true,true},{false,false,true}}),
    PIECE_S(new boolean[][]{{true,false,false},{true,true,true},{false,false,true}}),
    PIECE_T(new boolean[][]{{true,false,false},{true,true,true},{false,true,false}}),
    PIECE_U(new boolean[][]{{false,true,false},{true,true,true},{false,true,false}});


    private boolean[][] form;

    public static void main(String[] str) {
        Piece piece = Piece.PIECE_G;
        System.out.println(piece);
        piece.rotate();
        System.out.println(piece);
        piece.rotate();
        System.out.println(piece);
        piece.rotate();
        System.out.println(piece);
    }
    
    Piece(boolean[][] form){
        this.form=form;
    }

    public boolean[][] getForm(){
        return this.form;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.form.length;i++){
            for(int j=0;j<this.form[0].length;j++){
                if(this.form[i][j]){
                    sb.append("\u25A0");
                }
                else{
                    sb.append(" ");
                }
                sb.append(" ");
                    
            }
            sb.append("\n");
        }
        return sb.toString();
            
    }

    public void rotate(){
       
        boolean[][] nvforme = new boolean[this.form[0].length][this.form.length];

        for (int i=0;i<this.form[0].length;i++){
            for(int j=0;j<this.form.length;j++){
                nvforme[i][j] = this.form[this.form.length - 1 -j][i];
            }
        }
        this.form = nvforme;
    }
   
}