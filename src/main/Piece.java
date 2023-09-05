public enum Piece{
    PIECE_A(new boolean[][]{{true}}),
    PIECE_B(new boolean[][]{{true},{true}}),
    PIECE_C(new boolean[][]{{true},{true},{true}}),
    PIECE_D(new boolean[][]{{true,false},{true,true}}),
    PIECE_E(new boolean[][]{{true},{true},{true},{true}}),
    PIECE_F(new boolean[][]{{false,true},{false,true},{true,true}}),
    PIECE_G(new boolean[][]{{true,false},{true,true},{true, false}}),
    PIECE_H(new boolean[][]{{true,true},{true,true}}),
    PIECE_I(new boolean[][]{{true,true,false},{false,true,true}});



    private boolean[][] form;

    public static void main(String[] str) {
        System.out.println(Piece.PIECE_I);
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
}