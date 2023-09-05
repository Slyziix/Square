package main;

public class Rules {
    public static boolean checkDisponibility(Board b, Position p, Piece s) {
        int x = p.getX();
        int y = p.getY();

        for (int i = 0; i < s.getForm().length; ++i) {
            for (int j = 0; j < s.getForm()[i].length; ++j) {
                try {
                    if (!b.getBoard()[x + i][y + j].equals(PlayerColor.WHITE) && s.getForm()[i][j]) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
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
                    try {
                        if (b.getBoard()[x + i - 1][y + j].equals(color)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }

                    try {
                        if (b.getBoard()[x + i][y + j - 1].equals(color)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }

                    try {
                        if (b.getBoard()[x + i][y + j + 1].equals(color)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }

                    try {
                        if (b.getBoard()[x + i + 1][y + j].equals(color)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }
                }

                // Check x form
                if (s.getForm()[i][j]) {
                    try {
                        if (b.getBoard()[x + i - 1][y + j - 1] == color) {
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }

                    try {
                        if (b.getBoard()[x + i - 1][y + j + 1] == color) {
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }

                    try {
                        if (b.getBoard()[x + j + 1][y + i - 1] == color) {
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }

                    try {
                        if (b.getBoard()[x + i + 1][y + j + 1] == color) {
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return false;
                    }
                }

            }
        }

        return isSurrongindsSquareSatisfied;
    }
}
