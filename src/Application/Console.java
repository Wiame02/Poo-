package Application;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.String;
import User.Player;
import java.lang.Thread;  
import java.io.*; 



/**
 * Classe qui controle les entrees des utilisateurs et sorties sur console
 * @author Monique RIMBERT
 */

public class Console {
    public static void show_available_actions() {
        //TODO
    }

    /** Affichage du dialogue de fin du jeu gagné
     * @param p Le joueur
     */
    public static void game_success_ending(Player p) {
        System.out.println("Bravo " + p.get_username() + " !");
        Thread.sleep(1000);
        System.out.println("Vous avez gagné !");
    }

    /** Affichage du dialogue de fin du jeu avec le joueur mort
     * @param p Le joueur
     */
    public static void game_over_ending(Player p) {
        System.out.println("Ah, que c'est dommage " + p.get_username() + " !");
        Thread.sleep(1000);
        System.out.println("Vous êtes mort !");
    }

    /** 
     *  Lit et decrypte l'entrée d'un utilisateur
     * @return la fonction et son parametre d'entree sous forme de tableau
     */
    public static ArrayList<String> read_action() throws ApplicationException {
        ArrayList<String> result_function = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.print(">> ");
        String str = sc.nextLine();

        if (!str.endsWith(";")){
            throw new ApplicationException("Line missing ';'");
        } else {
            return result_function;
        }

    }
    
    


}
