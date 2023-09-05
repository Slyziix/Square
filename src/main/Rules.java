package main;

public class Rules {
    public static boolean checkDisponibility(Board b, Position p, Piece s) {
        int x = p.getX();
        int y = p.getY();

        for (int i = 0; i < s.getForm().length; ++i) {
            for (int j = 0; j < s.getForm()[i].length; ++j) {
                if (!b.getBoard()[x + i][y + j].equals(PlayerColor.WHITE) && s.getForm()[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkSurrondings(Board b, Position p, Piece s, PlayerColor color) {
        int x = p.getX();
        int y = p.getY();

        boolean isSurrongindsSquareSatisfied = false;

        for (int i = 0; i < s.getForm().length; ++i) {
            for (int j = 0; j < s.getForm()[i].length; ++j) {

                // Check + form
                if (s.getForm()[i][j]) {
                    if (b.getBoard()[x - 1][y].equals(color)) {
                        return false;
                    }

                    if (b.getBoard()[x][y - 1].equals(color)) {
                        return false;
                    }

                    if (b.getBoard()[x][y + 1].equals(color)) {
                        return false;
                    }

                    if (b.getBoard()[x + 1][y].equals(color)) {
                        return false;
                    }
                }

                // Check x form
                if (s.getForm()[i][j]) {
                    if (b.getBoard()[x - 1][y - 1].equals(color)) {
                        isSurrongindsSquareSatisfied = true;
                    }

                    if (b.getBoard()[x - 1][y + 1].equals(color)) {
                        isSurrongindsSquareSatisfied = true;
                    }

                    if (b.getBoard()[x + 1][y - 1].equals(color)) {
                        isSurrongindsSquareSatisfied = true;
                    }

                    if (b.getBoard()[x + 1][y + 1].equals(color)) {
                        isSurrongindsSquareSatisfied = true;
                    }
                }

            }
        }

        return isSurrongindsSquareSatisfied;
    }
}
