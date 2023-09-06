package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    static int nbJoueur = 2;

    static void menuPrincipal() {
        System.out.println("\nBIENVENUE SUR SQUARE !\n");
        System.out.println("QUE VOULEZ-VOUS FAIRE ?\n\n");
        System.out.println("1 - Lancer la partie\n");
        System.out.println("2 - Choisir le nombre de joueurs\n");
        System.out.println("3 - Voir les règles\n");
        System.out.println("4 - Quitter la partie\n");
    }

    static void choixMenu(Scanner sc) throws FileNotFoundException {
        sc.reset();
        menuPrincipal();
        System.out.println();
        int choix = sc.nextInt();
        if (choix < 1 && choix > 5) {
            System.out.println("Choix impossible ! Veuillez entrer un entier entre 1 et 4");
            choix = sc.nextInt();
        }
        System.out.println();
        if (choix == 1) {
            Game game = new Game();
            game.start(game, nbJoueur);
        }
        if (choix == 2) {
            nbJoueur = choixNbJoueur(sc);
            System.out.println("Vous avez choisi " + nbJoueur + " joueurs.\n");
            choixMenu(sc);
        }
        if (choix == 3) {
            affichageRegles(sc);
        }
        if (choix == 4) {
        }
    }

    public static void affichageJoueur() {
        System.out.println("Combien de joueurs ?\n");
        System.out.println("1. 2 Joueurs\n");
        System.out.println("2. 4 Joueurs\n");
    }

    public static int choixNbJoueur(Scanner sc) {
        sc.reset();
        affichageJoueur();
        int nb;
        String choix = sc.nextLine();
        while (!choix.equals("1") && !choix.equals("2")) {
            System.out.println("\nChoisissez une options entre 1 et 2.");
            choix = sc.nextLine();
        }
        System.out.println();
        nb = Integer.parseInt(choix);
        return nb * 2;
    }

    static void affichageRegles(Scanner sc) throws FileNotFoundException {
        sc.reset();
        int nb = choixRegles(sc);
        File file = new File("res/regles/R" + nb + ".txt");
        Scanner scFile = new Scanner(file);
        System.out.println();
        while (scFile.hasNextLine()) {
            System.out.println(scFile.nextLine());
        }
        scFile.close();
        String back = sc.nextLine().toLowerCase();
        while (!back.equals("b")) {
            back = sc.nextLine();
        }
        affichageRegles(sc);

    }

    public static int choixRegles(Scanner sc) throws FileNotFoundException {
        sc.reset();
        int nb;
        System.out.println("\nChoisissez la catégorie que vous voulez lire :\n");
        System.out.println("1 - Composition du jeu\n");
        System.out.println("2 - Les pièces du jeu\n");
        System.out.println("3 - But du Jeu\n");
        System.out.println("4 - Contraintes\n");
        System.out.println("5 - Fin de la partie\n");
        System.out.println("6 - Décompte des points\n");
        String choix = sc.nextLine().toLowerCase();
        while (!choix.equals("b") && (!choix.equals("1")
                && !choix.equals("2") && !choix.equals("3") && !choix.equals("4")
                && !choix.equals("5") && !choix.equals("6"))) {
            System.out.println(
                    "Veuillez entre un entier en 1 et 6 pour choisir une règle ou sur B puis Entrée pour revenir au menu principal");
            choix = sc.nextLine();
        }
        if (choix.equals("b") || choix.equals("B")) {
            choixMenu(sc);
            return 0;
        } else {
            nb = Integer.parseInt(choix);
            return nb;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        choixMenu(sc);
    }
}
