package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private int nbJoueur = 2;
    private ArrayList<Player> playersList = new ArrayList<Player>();
    private Player current_player;
    private static Player Red_Player;
    private static Player Blue_Player;
    private static Player Green_Player;
    private static Player Yellow_Player;
    private boolean[][] currentPiece;

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public void affichageJoueur() {
        System.out.println("Combien de joueurs ?");
        System.out.println("1. 2 Joueurs");
        System.out.println();
        System.out.println("2. 4 Joueurs");
        System.out.println();
        int nb = Game.choixNbJoueur();
    }

    public static int choixNbJoueur() {
        int nb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir une option (1 ou 2) :");
        String choix = sc.nextLine();
        while (!choix.equals("1") && !choix.equals("2")) {
            System.out.println("Choix impossible ! Veuillez entrez un choix entre A et B.");
            choix = sc.nextLine();
        }
        sc.close();
        nb = Integer.parseInt(choix);
        return nb * 2;
    }

    public ArrayList<Player> initializePlayers(int nbJoueur) {
        Red_Player = new Player(PlayerColor.RED);
        Yellow_Player = new Player(PlayerColor.MAGENTA);
        Blue_Player = new Player(PlayerColor.BLUE);
        Green_Player = new Player(PlayerColor.GREEN);

        if (nbJoueur == 2) {
            playersList = new ArrayList<>(2);
            playersList.add(0, Red_Player);
            playersList.add(1, Yellow_Player);
        } else {
            playersList = new ArrayList<>(4);
            playersList.add(Red_Player);
            playersList.add(Blue_Player);
            playersList.add(Green_Player);
            playersList.add(Yellow_Player);

        }
        current_player = playersList.get(0);

        return playersList;
    }

    public void switchPlayer() {
        ArrayList<Player> tmp = new ArrayList<Player>();
        Player tmp_Player = current_player;
        for (int i = 1; i < playersList.size(); i++) {
            tmp.add(i - 1, playersList.get(i));
        }
        tmp.add(playersList.size() - 1, tmp_Player);
        playersList = tmp;
        current_player = playersList.get(0);
    }

    static void affichageRegles() throws FileNotFoundException {
        int nb = Game.choixRegles();
        File file = new File("res/regles/R" + nb + ".txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

    public static int choixRegles() {
        int nb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez la catégorie que vous voulez lire :");
        System.out.println();
        System.out.println("1 - Composition du jeu");
        System.out.println();
        System.out.println("2 -  Les pièces du jeu");
        System.out.println();
        System.out.println("3 - But du Jeu");
        System.out.println();
        System.out.println("4 - Contraintes");
        System.out.println();
        System.out.println("5 - Fin de la partie");
        System.out.println();
        System.out.println("6 - Décompte des points");
        String choix = sc.nextLine();
        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4")
                && !choix.equals("5") && !choix.equals("6")) {
            System.out.println("Choix impossible ! Veuillez entrez un entier entre 1 et 6.");
            choix = sc.nextLine();
        }
        sc.close();
        nb = Integer.parseInt(choix);
        return nb;
    }

    public static void affichageMenu() {
        System.out.println("QUE VOULEZ-VOUS FAIRE ?");
        System.out.println();
        System.out.println("1 - Nombre de joueurs");
        System.out.println();
        System.out.println("2 - Règles");
        Game.choixMenu();

    }

    public static int choixMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir une options (1 ou 2) :");
        int choix = sc.nextInt();
        while (choix != 1 || choix != 2) {
            System.out.println("Choix impossible ! Veuillez entrez un choix entre 1 et 2.");
            choix = sc.nextInt();
        }
        sc.close();
        return choix;
    }

    public ArrayList<Player> getPlayerList() {
        return playersList;
    }

    public Player getCurrent_player() {
        return current_player;
    }

    public void start(Game g, int nbPlayers) {
        int turn = 0;

        g.initializePlayers(nbPlayers);
        Board b = new Board();
        b.initialise();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            b.displayBoard();
            Player currentP = g.getCurrent_player();
            System.out.println();
            System.out.println(currentP.getAvailablePiecesString());
            boolean placementDone = false;
            while (!placementDone) {
                int[] input = getUserInput(scanner, currentP.getAvailablePieces().size());
                int choice = input[0];
                Piece pieceChose = currentP.getAvailablePieces().get(choice);
                Position p = new Position(input[1], input[2]);
                placementDone = b.placeShape(p, b, currentP, currentPiece, turn);
                if (placementDone) {
                    currentP.removePiece(pieceChose);
                }
            }
            g.switchPlayer();
            if (g.current_player.getColor() == PlayerColor.RED) {
                ++turn;
            }
        }
    }

    public int[] getUserInput(Scanner scanner, int max) {
        int number;
        int x;
        int y;
        String rotate;

        do {
            System.out.print("Entrer le numero de la piece souhaite : ");
            number = scanner.nextInt();
        } while (number < 1 || number > max);

        boolean[][] selectShape = current_player.getAvailablePieces().get(number-1).getForm();
        do {
            System.out.println("Voulez vous trounez votre pièce ?");
            rotate = scanner.next().toLowerCase();
            if (rotate.equals("oui")){
                selectShape = Piece.rotate(selectShape);
                System.out.println(Piece.toString(selectShape));
            }
        } while (rotate.equals("oui"));
        currentPiece = selectShape;

        do {
            System.out.print("Entrer la ligne : ");
            String tmpX = scanner.next().toUpperCase();
            x = tmpX.charAt(0) - 'A';
        } while (x < 0 || x > 19);

        do {
            System.out.print("Entrer la colonne : ");
            String tmpY = scanner.next().toUpperCase();
            y = tmpY.charAt(0) - 'A';
        } while (y < 0 || y > 19);

        return new int[] { number - 1, x, y };
    }



    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game();
        game.start(game, 2);

    }

}