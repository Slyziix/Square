package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Game{

    private int nbJoueur = 2;

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }
    
    public void affichageJoueur(){
        System.out.println("Combien de joueurs ?");
        System.out.println("1. 2 Joueurs");
        System.out.println();
        System.out.println("2. 4 Joueurs");
        System.out.println();
        int nb = Game.choixNbJoueur();
    }

    public static int choixNbJoueur(){
        int nb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir une option (1 ou 2) :");
        String choix = sc.nextLine();
        while(!choix.equals("1") && !choix.equals("2")){
            System.out.println("Choix impossible ! Veuillez entrez un choix entre A et B.");
            choix = sc.nextLine();
        }
        sc.close();
        nb = Integer.parseInt(choix);
        return nb*2;
    }

    static void affichageRegles() throws FileNotFoundException{
        int nb = Game.choixRegles(); 
        System.out.println(nb);       
        FileReader file = new FileReader("res/regles/"+ nb + ".txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
        {
          System.out.println(sc.nextLine());
        }
        sc.close();    
      }

    public static int choixRegles(){
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
        while( !choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6")){
            System.out.println("Choix impossible ! Veuillez entrez un entier entre 1 et 6.");
            choix = sc.nextLine();
        }
        sc.close();
        nb = Integer.parseInt(choix);
        return nb;
    }

    public static void affichageMenu(){
        System.out.println("QUE VOULEZ-VOUS FAIRE ?");
        System.out.println();
        System.out.println("1 - Nombre de joueurs");
        System.out.println();
        System.out.println("2 - Règles");
        Game.choixMenu();
    
    }

    public static int choixMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir une options (1 ou 2) :");
        int choix = sc.nextInt();
        while( choix != 1 || choix != 2){
            System.out.println("Choix impossible ! Veuillez entrez un choix entre 1 et 2.");
            choix = sc.nextInt();
        }
        sc.close();
        return choix;
    }

    public static void main(String[] args) throws FileNotFoundException {
        affichageRegles();
    }
}