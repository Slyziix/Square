public enum Piece{

    UN(),DEUX,TROIS,QUATRE,CINQ;

    String name;
    boolean[][] form;
    
    Piece(String name, boolean[][] form){
        this.name=name;
        this.form=form;
    }
}