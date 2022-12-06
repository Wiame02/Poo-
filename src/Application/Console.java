package Application;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import User.*;
import java.lang.Thread;  

/**
 * Classe qui controle les entrees des utilisateurs et sorties sur console
 * @author Monique RIMBERT
 */

public class Console {

    /** Affichage du dialogue de fin du jeu gagné
     * @param p Le joueur
     */
    public static void gameSuccessEnding(Player p) {
        System.out.println("Bravo " + p.getUsername() + " !");
        try{Thread.sleep(1000);}
        catch(InterruptedException i){
            System.out.println("Console.gameSuccessEnding(Player) : " + i);
        }
        System.out.println("Vous avez gagné !");
    }

    /** Affichage du dialogue de fin du jeu avec le joueur mort
     * @param p Le joueur
     */
    public static void gameOverEnding(Player p) {
        System.out.println("Ah, que c'est dommage " + p.getUsername() + " !");
        try{Thread.sleep(1000);}
        catch(InterruptedException i){
            System.out.println("Console.gameOverEnding(Player) : " + i);
        }
        System.out.println("Vous êtes mort !");
    }

    /**
     * Verifie si l'espace a le droit d'être placé à cet endroit.
     * @param input La chaine etudiee
     * @param i L'indice où nous nous trouvons
     * @return  true S'il est précédé ou suivi d'une parenthèse gauche ou droite, d'un espace ou d'une virgule
     */
    private static boolean isSpaceAtValidPlacement(String input, int i) {
        boolean isValid = (input.charAt(i-1)==' ' || input.charAt(i+1)==' ');
        isValid = isValid || (input.charAt(i-1)=='(' || input.charAt(i+1)=='(');
        isValid = isValid || (input.charAt(i-1)==')' || input.charAt(i+1)==')');
        isValid = isValid || (input.charAt(i-1)==',' || input.charAt(i+1)==',');
        return isValid;
    }
    
    /** 
     * Lit et decrypte l'entrée d'un utilisateur
     * @return la fonction et des parametres d'entree sous forme de tableau [nom_fonction, arg1, ..., argn]
     */
    public static ArrayList<String> readAction() throws ApplicationException {
        ArrayList<String> resInput = new ArrayList<String>();
        
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!input.endsWith(";")){
            throw new ApplicationException("La ligne de code n'est pas terminee par un ';'");
        } else {
            String word = "";
            int i = 0;
            boolean leftParenthesis = false, rightParenthesis = false;

            while (i<input.length()-1 && !rightParenthesis) {
                // On rencontre une parenthese gauche : Debut de lecture des arguments.
                if (input.charAt(i)=='(') {
                    if (rightParenthesis)  { throw new ApplicationException("Parenthèse gauche placée après la parenthèse droite."); }
                    if (i<1)                {throw new ApplicationException("Il n'y a appel à aucune fonction.");}
                    else {
                        leftParenthesis = true;
                        resInput.add(word);
                        word = "";
                    }

                // Fin d'un des parametres de la fonction appellée
                } else if (input.charAt(i)==',') {
                    resInput.add(word);
                    word = "";
                
                // On rencontre une parenthese droite : Fin de lecture de la fonction, on va forcer la fin de lecture.
                } else if (input.charAt(i)==')') {
                    if (!leftParenthesis) { throw new ApplicationException("Parenthèse gauche placée après la parenthèse droite."); }
                    else {
                        rightParenthesis = true;
                        resInput.add(word);
                        word = "";
                    }
                
                // On lit la suite du mot courant
                } else {
                    if (input.charAt(i)==' ') {
                        if (!isSpaceAtValidPlacement(input, i)) { throw new ApplicationException("Un espace coupe un argument en deux !"); }
                    }
                    word += (input.charAt(i)!=' ')?input.charAt(i):'\0';
                }
                i++;    //Incrémentation !
            }
            if (!leftParenthesis || !rightParenthesis) { throw new ApplicationException("Parenthese(s) manquantes"); }
            if (i<input.length()-2) { throw new ApplicationException("Arguments restants non valides après les parenthèses."); }
            return resInput;
        }
    }
    
    public static ArrayList<String> getAvailableActions(){
        ArrayList<String> doableActions = null;
        //TODO
        return doableActions;
    }

    public static void main(String[] args) {
        /*
        World w = new World("TestWorld", Period.FUTURE);
        Villager v = new Villager("TestVillager", 5);
        Monster m = new Monster("TestMonster", 99, Species.DEMON, 99);
        Area a = new Area("TestArea", m, w);
        Player p = new Player("TestPlayer", Order.CHEMIST, a);

        showAvailableActions(p);
        */
        try {
            ArrayList<String> ls = readAction();
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


