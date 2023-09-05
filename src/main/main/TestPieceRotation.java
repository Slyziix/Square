package main;


public class TestPieceRotation {
    public static void main(String[] args) {
        Piece piece = Piece.PIECE_G;

        System.out.println("Piece avant rotation :");
        System.out.println(piece);

        piece.rotate();

        System.out.println("Piece après rotation :");
        System.out.println(piece);

        // Réinitialisation de la pièce
        piece = Piece.PIECE_G;

        // Rotation supplémentaire pour vérification
        piece.rotate();

        System.out.println("Piece après une deuxième rotation :");
        System.out.println(piece);
    }
}

