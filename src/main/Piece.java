package main;

public enum Piece {
    PIECE_A(new boolean[][] { { true } }),
    PIECE_B(new boolean[][] { { true }, { true } }),
    PIECE_C(new boolean[][] { { true }, { true }, { true } }),
    PIECE_D(new boolean[][] { { true, false }, { true, true } }),
    PIECE_E(new boolean[][] { { true }, { true }, { true }, { true } }),
    PIECE_F(new boolean[][] { { false, true }, { false, true }, { true, true } }),
    PIECE_G(new boolean[][] { { true, false }, { true, true }, { true, false } }),
    PIECE_H(new boolean[][] { { true, true }, { true, true } }),
    PIECE_I(new boolean[][] { { true, true, false }, { false, true, true } }),
    PIECE_J(new boolean[][] { { true }, { true }, { true }, { true }, { true } }),
    PIECE_K(new boolean[][] { { false, true }, { false, true }, { false, true }, { true, true } }),
    PIECE_L(new boolean[][] { { false, true }, { false, true }, { true, true }, { true, false } }),
    PIECE_M(new boolean[][] { { false, true }, { true, true }, { true, true } }),
    PIECE_N(new boolean[][] { { true, true }, { false, true }, { true, true } }),
    PIECE_O(new boolean[][] { { true, false }, { true, true }, { true, false }, { true, false } }),
    PIECE_P(new boolean[][] { { false, true, false }, { false, true, false }, { true, true, true } }),
    PIECE_Q(new boolean[][] { { true, false, false }, { true, false, false }, { true, true, true } }),
    PIECE_R(new boolean[][] { { true, true, false }, { false, true, true }, { false, false, true } }),
    PIECE_S(new boolean[][] { { true, false, false }, { true, true, true }, { false, false, true } }),
    PIECE_T(new boolean[][] { { true, false, false }, { true, true, true }, { false, true, false } }),
    PIECE_U(new boolean[][] { { false, true, false }, { true, true, true }, { false, true, false } });

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

    Piece(boolean[][] form) {
        this.form = form;
    }

    public boolean[][] getForm() {
        return this.form;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.form.length; i++) {
            for (int j = 0; j < this.form[0].length; j++) {
                if (this.form[i][j]) {
                    sb.append("\u25A0");
                } else {
                    sb.append(" ");
                }
                sb.append(" ");

            }
            sb.append("\n");
        }
        return sb.toString();

    }

    public static String toString(boolean[][] tab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j]) {
                    sb.append("\u25A0");
                } else {
                    sb.append(" ");
                }
                sb.append(" ");

            }
            sb.append("\n");
        }
        return sb.toString();

    }

    public static String showPlaceable(boolean[][] piece, Player p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[0].length; j++) {
                if (!piece[i][j] && i == 0 && j == 0) {
                    sb.append("X");
                } else if (piece[i][j] && i == 0 && j == 0) {
                    sb.append(
                            "\u001B[38;2;" + p.getColor().getColor().getRed() + ";" + p.getColor().getColor().getGreen()
                                    + ";"
                                    + p.getColor().getColor().getBlue() + "m" + "X" + "\u001B[0m");
                } else if (piece[i][j]) {
                    sb.append(
                            "\u001B[38;2;" + p.getColor().getColor().getRed() + ";" + p.getColor().getColor().getGreen()
                                    + ";"
                                    + p.getColor().getColor().getBlue() + "m" + "\u25A0" + "\u001B[0m");
                } else {
                    sb.append(" ");
                }
                sb.append(" ");

            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean[][] rotate() {

        boolean[][] nvforme = new boolean[this.form[0].length][this.form.length];

        for (int i = 0; i < this.form[0].length; i++) {
            for (int j = 0; j < this.form.length; j++) {
                nvforme[i][j] = this.form[this.form.length - 1 - j][i];
            }
        }
        return nvforme;
    }

    public static boolean[][] rotate(boolean[][] piece) {

        boolean[][] nvforme = new boolean[piece[0].length][piece.length];

        for (int i = 0; i < piece[0].length; i++) {
            for (int j = 0; j < piece.length; j++) {
                nvforme[i][j] = piece[piece.length - 1 - j][i];
            }
        }
        return nvforme;
    }
}