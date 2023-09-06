package main;

public class Rules {
    public static boolean checkDisponibility(Board b, Position p, boolean[][] s) {
        int x = p.getX();
        int y = p.getY();

        for (int i = 0; i < s.length; ++i) {
            for (int j = 0; j < s[i].length; ++j) {
                try {
                    if (!b.getBoard()[x + i][y + j].equals(PlayerColor.WHITE) && s[i][j]) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkSurrondings(Board b, Position p, boolean[][] s, PlayerColor color) {
        int x = p.getX();
        int y = p.getY();

        boolean isSurrongindsSquareSatisfied = false;

        for (int i = 0; i < s.length; ++i) {
            for (int j = 0; j < s[i].length; ++j) {

                // Check + form
                if (s[i][j]) {
                    try {
                        if (b.getBoard()[x + i - 1][y + j].equals(color)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }

                    try {
                        if (b.getBoard()[x + i][y + j - 1].equals(color)) {
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }

                    try {
                        if (b.getBoard()[x + i][y + j + 1].equals(color)) {
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }

                    try {
                        if (b.getBoard()[x + i + 1][y + j].equals(color)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                }

                // Check x form
                if (s[i][j]) {
                    System.out.println(i + " " + j);
                    System.out.println(x + " " + y);
                    try {
                        System.out.println(b.getBoard()[x + i - 1][y + j - 1]);
                        if (b.getBoard()[x + i - 1][y + j - 1] == color) {
                            System.out.println("OK");
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }

                    try {
                        System.out.println(b.getBoard()[x + i - 1][y + j + 1]);
                        if (b.getBoard()[x + i - 1][y + j + 1] == color) {
                            System.out.println("OK");
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }

                    try {
                        System.out.println(b.getBoard()[x + j + 1][y + i - 1]);
                        if (b.getBoard()[x + j + 1][y + i - 1] == color) {
                            System.out.println("OK");
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }

                    try {
                        System.out.println(b.getBoard()[x + i + 1][y + j + 1]);
                        if (b.getBoard()[x + i + 1][y + j + 1] == color) {
                            System.out.println("OK");
                            isSurrongindsSquareSatisfied = true;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                }

            }
        }

        return isSurrongindsSquareSatisfied;
    }
}
