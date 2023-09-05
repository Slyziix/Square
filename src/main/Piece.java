package main;

public enum Piece{
    PIECE_1(new boolean[][]{{true}}),
    PIECE_2(new boolean[][]{{true},{true}}),
    PIECE_3(new boolean[][]{{true},{true},{true}}),
    PIECE_4(new boolean[][]{{true,false},{true,true}}),
    PIECE_5(new boolean[][]{{true},{true},{true},{true}}),
    PIECE_6(new boolean[][]{{false,true},{false,true},{true,true}}),
    PIECE_7(new boolean[][]{{true,false},{true,true},{true, false}}),
    PIECE_8(new boolean[][]{{true,true},{true,true}}),
    PIECE_9(new boolean[][]{{true,true,false},{false,true,true}}),
    PIECE_10(new boolean[][]{{true},{true},{true},{true},{true}}),
    PIECE_11(new boolean[][]{{false,true},{false,true},{false,true},{true,true}}),
    PIECE_12(new boolean[][]{{false,true},{false,true},{true,true},{true,false}}),
    PIECE_13(new boolean[][]{{false,true},{true,true},{true,true}}),
    PIECE_14(new boolean[][]{{true,true},{false,true},{true,true}}),
    PIECE_15(new boolean[][]{{true,false},{true,true},{true,false},{true,false}}),
    PIECE_16(new boolean[][]{{false,true,false},{false,true,false},{true,true,true}}),
    PIECE_17(new boolean[][]{{true,false,false},{true,false,false},{true,true,true}}),
    PIECE_18(new boolean[][]{{true,true,false},{false,true,true},{false,false,true}}),
    PIECE_19(new boolean[][]{{true,false,false},{true,true,true},{false,false,true}}),
    PIECE_20(new boolean[][]{{true,false,false},{true,true,true},{false,true,false}}),
    PIECE_21(new boolean[][]{{false,true,false},{true,true,true},{false,true,false}});


    private boolean[][] form;

    public static void main(String[] str) {
        Piece piece = Piece.PIECE_7;
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