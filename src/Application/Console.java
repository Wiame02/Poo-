package Application;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

import Entity.*;
import Localization.*;

import java.util.ArrayList;
import User.*;
import java.lang.Thread;  

/**
 * Classe qui controle les entrees des utilisateurs et sorties sur console
 * @author Monique RIMBERT
 */

public class Console {
    public static void show_available_actions(Player p) {
        System.out.println("get_current_area()");
        System.out.println("displayInventory()");
        System.out.println("move_linked_area()");
        System.out.println("show_available_actions()");
        System.out.println("get_hp()");

        if (true) { //XXX
            System.out.println("interact("+  p.get_current_area().get_entity().get_name() +")");
        } else {
            System.out.println("attack("+ p.get_current_area().get_entity().get_name() +")");
        }
    }

    /** Affichage du dialogue de fin du jeu gagné
     * @param p Le joueur
     */
    public static void game_success_ending(Player p) {
        System.out.println("Bravo " + p.get_username() + " !");
        try{Thread.sleep(1000);}
        catch(InterruptedException i){
            //TODO : la fonction sleep  renvoie une exception 
        }
        System.out.println("Vous avez gagné !");
    }

    /** Affichage du dialogue de fin du jeu avec le joueur mort
     * @param p Le joueur
     */
    public static void game_over_ending(Player p) {
        System.out.println("Ah, que c'est dommage " + p.get_username() + " !");
        try{Thread.sleep(1000);}
        catch(InterruptedException i){
            //TODO
        }
        System.out.println("Vous êtes mort !");
    }

    /**
     * Verifie si l'espace a le droit d'être placé à cet endroit.
     * @param input La chaine etudiee
     * @param i L'indice où nous nous trouvons
     * @return  true S'il est précédé ou suivi d'une parenthèse gauche ou droite, d'un espace ou d'une virgule
     */
    private static boolean valid_space_placement(String input, int i) {
        boolean is_valid = (input.charAt(i-1)==' ' || input.charAt(i+1)==' ');
        is_valid = is_valid || (input.charAt(i-1)=='(' || input.charAt(i+1)=='(');
        is_valid = is_valid || (input.charAt(i-1)==')' || input.charAt(i+1)==')');
        is_valid = is_valid || (input.charAt(i-1)==',' || input.charAt(i+1)==',');
        return is_valid;
    }
    
    /** 
     *  Lit et decrypte l'entrée d'un utilisateur : elle r
     * @return la fonction et des parametres d'entree sous forme de tableau [nom_fonction, arg1, ..., argn]
     */
    public static ArrayList<String> read_action() throws ApplicationException {
        ArrayList<String> res_input = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.print(">> ");
        String input = sc.nextLine();
        sc.close();

        if (!input.endsWith(";")){
            throw new ApplicationException("La ligne de code n'est pas terminee par un ';'");
        } else {
            String word = "";
            int i = 0;
            boolean left_parenthesis = false, right_parenthesis = false;

            while (i<input.length()-1 && !right_parenthesis) {
                // On rencontre une parenthese gauche : Debut de lecture des arguments.
                if (input.charAt(i)=='(') {
                    if (right_parenthesis)  { throw new ApplicationException("Parenthèse gauche placée après la parenthèse droite."); }
                    if (i<1)                {throw new ApplicationException("Il n'y a appel à aucune fonction.");}
                    else {
                        left_parenthesis = true;
                        res_input.add(word);
                        word = "";
                    }

                // Fin d'un des parametres de la fonction appellée
                } else if (input.charAt(i)==',') {
                    res_input.add(word);
                    word = "";
                
                // On rencontre une parenthese droite : Fin de lecture de la fonction, on va forcer la fin de lecture.
                } else if (input.charAt(i)==')') {
                    if (!left_parenthesis) { throw new ApplicationException("Parenthèse gauche placée après la parenthèse droite."); }
                    else {
                        right_parenthesis = true;
                        res_input.add(word);
                        word = "";
                    }
                
                // On lit la suite du mot courant
                } else {
                    if (input.charAt(i)==' ') {
                        if (!valid_space_placement(input, i)) { throw new ApplicationException("Un espace coupe un argument en deux !"); }
                    }
                    word += (input.charAt(i)!=' ')?input.charAt(i):'\0';
                }
                i++;    //Incrémentation !
            }
            if (!left_parenthesis && !right_parenthesis) { throw new ApplicationException("Parentheses manquantes"); }
            if (i<input.length()-2) { throw new ApplicationException("Arguments restants non valides après les parenthèses."); }
            return res_input;
        }
    }
    
    public static ArrayList<String> get_available_actions(){
        ArrayList<String> doable_actions = null;
        //TODO
        return doable_actions;
    }

    public static void main(String[] args) {
        /*
        World w = new World("TestWorld", Period.FUTURE);
        Villager v = new Villager("TestVillager", 5);
        Monster m = new Monster("TestMonster", 99, Species.DEMON, 99);
        Area a = new Area("TestArea", m, w);
        Player p = new Player("TestPlayer", Order.CHEMIST, a);

        show_available_actions(p);
        */
        try {
            ArrayList<String> ls = read_action();
            System.out.println("Nb arguments dans la fonction : " + (ls.size()-1));
            for (String s : ls) {
                System.out.println(s);
            }
        }
        catch (ApplicationException e) {
            System.out.println(e);
        }
    }
}


