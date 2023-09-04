package main;

import java.util.Scanner;

public class Game{

    public static void affichageJoueur(){
        System.out.println("Combien de joueurs ?");
        System.out.println("A - 2 Joueurs");
        System.out.println();
        System.out.println("B - 4 Joueurs");
        Game.choixNbJoueur();
        Board b = new Board();
        b.initialise();
        b.displayBoard();
    }

    public static String choixNbJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir une options (A ou B) :");
        String choix = sc.nextLine();
        while(!choix.contains("A") && !choix.contains("B")){
            System.out.println("Choix impossible ! Veuillez entrez un choix entre A et B.");
            choix = sc.nextLine();
        }
        return choix;
    }    
    
    /* void affichageRegles(){        
        System.out.println("Composition du jeu :");
        System.out.println("Le jeu se compose des éléments suivants :"
        System.out.println("Un plateau de jeu de 400 cases."
        System.out.println("84 pièces (soit 21 pièces dans chacune des 4 couleurs)."
        System.out.println(Chacune des 21 pièces est de forme différente.
        System.out.println(Les pièces du jeu
        System.out.println(Il y a :
        System.out.println(1 pièce d’un carré (qu’on pourrait nommer le
        System.out.println(« monomino »...
        System.out.println(si ce terme existait)
        System.out.println(1 pièce à deux carrés (un « domino »).
        System.out.println(2 pièces à trois carrés (des « triominos »).
        System.out.println(5 pièces à quatre carrés (des « tetraminos »).
        System.out.println(12 pièces à cinq carrés (des « pentaminos »).
        System.out.println(But du jeu :
        System.out.println(Le but du jeu est, pour chaque joueur, de
        System.out.println(placer ses 21 pièces sur le plateau (ou en tous
        System.out.println(les cas, un maximum d’entre elles).
        System.out.println(Contraintes :
        System.out.println(Chaque joueur doit démarrer sur l’un des angles du plateau.
        System.out.println(L’ordre de jeu est bleu, jaune, rouge, vert.
        System.out.println(Chaque nouvelle pièce posée doit toucher au moins une pièce de la même couleur,
        System.out.println(mais uniquement par les angles, jamais par les cotés.
        System.out.println(Fin de la partie :
        System.out.println(Lorsqu’un joueur est bloqué et ne peut plus placer de pièce, il est obligé de passer son
        System.out.println(tour. Les autres joueurs poursuivent en conservant le même ordre de jeu, jusqu’à ce
        System.out.println(que plus personne ne puisse placer de pièce.
        System.out.println(Décompte des points :
        System.out.println(Lorsque tous les joueurs sont bloqués, chacun compte le nombre de carrés qu’il n’a pu
        System.out.println(placer sur le plateau et calcule son score :
        System.out.println(Chaque carré non posé constitue un point négatif.
        System.out.println(Un bonus de15 points est accordé si les 21 pièces ont été posées.
        System.out.println(Ce bonus est de 20 points si les 21 pièces ont été posées avec le carré solitaire en
        System.out.println(dernière position.
        System.out.println(Celui qui a le plus de points a gagné !
System.out.println(;        System.out.println(;}
*/
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
        return choix;
    }

    public static void main(String[] args) {
        affichageJoueur();
    }

}