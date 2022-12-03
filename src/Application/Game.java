package Application;
import Localization.*;
import User.*;
import Entity.*;
import java.util.ArrayList;
import javax.sql.StatementEventListener;

/**
 * Classe qui permet le déroulement et la création du jeu
 * @author Monique RIMBERT
 */

public class Game {
    /**
     * Choisi aléatoirement un boss final parmi les entitées présentes dans ce monde
     * @param world Le monde entré en modification
     */
    public static void chooseBoss(World world, ArrayList<Monster> monsters){
            int i = (int) (Math.random()*(monsters.size()-1));
            world.setBoss(monsters.get(i));
    }

    /**
     * Génère un nombre aléatoire entre [0, max[
     * @param maxExcluded
     * @return un entier entre [0, max[
     */
    public static int generateRandomNumber (int maxExcluded) {
        double computedDouble = Math.random()*1000;
        int randomNumber = ((int) computedDouble)%maxExcluded;

        return randomNumber;
    }

    /**
     * Génère aléatoirement les entitées dans les zones du monde
     * @param world Le monde entré en modification
     */
    public static void generateAreas(World world, ArrayList<Entity> entities){
        for (Entity e : entities) { 
            int i = generateRandomNumber(world.getAreas().size());  //Un entier entre 0 et le nombre de zones dans le monde-1

            while (world.getAreaAt(i).getEntity()!=null) {
                i = generateRandomNumber(world.getAreas().size());
            }

            world.getAreaAt(i).setEntity(e);
        }
    }

    /**
     * Génération du plateau du jeu grâce au données obtenues
     * @return le plateau construit
     */
    public static Board generateBoard(){
        Board b = new Board();
        b.addAllWorlds(DataWorlds.DATA_WORLDS);

        for (int i=0; i<b.getWorlds().size()-1; i++) {
            generateAreas(b.getWorldAt(i+1), DataVillager.DATA_ENTITIES.get(i));
            chooseBoss(b.getWorldAt(i+1), DataMonsters.DATA_MONSTERS.get(i));
        }
        return b;
    }

    /**
     * Création du personnage du joueur
     * @param w Le premier monde
     * @return le personnage du joueur
     */
    public static Player createPlayer(World w){
        return new Player("Hello", Order.COMPUTER_SCIENTIST, w.getAreaAt(0));
    }

    /**
     * Execute la fontion qui a été entrée
     * @param func La fonction entrée avec son parametre sous forme de tableau
     * @throws GameException La fonction entrée soit n'est pas valide soit son paramètre ne l'est pas
     */
    public static void executeFunctionInput(ArrayList<String> func) {
        ArrayList<String> doable_actions = Console.get_available_actions();
        if (func.get(0)=="kill") {
            //TODO verif param
        }
    }

    /**
     * Permet l'execution d'une entree du joueur
     * @param player Le joueur
     */
    public static void doAnAction(Player player) {
        ArrayList<String> input = new ArrayList<>();
        try {
            input = Console.readAction();
            //executeFunctionInput(input);
        }
        catch (Exception e) {
	        System.out.println("Error in playerDoAction() : " + e);
            doAnAction(player);
        }
    }

    /**
     * Vérifie s'il ne reste aucun boss vivant dans les mondes
     * @param board
     * @return true si tous les boss sont morts
     */
    public static boolean are_all_boss_dead(Board board) {
        boolean are_dead = true;
        int i = 0;
        while (i<board.getWorlds().size() && are_dead) {
            are_dead = !board.getWorldAt(i).getBoss().isAlive();
            i++;
        }
        return are_dead;
    }

    /**
     * Déroulement du jeu
     */
    public static void playGame() {
        Board   board   = generateBoard();
        Player  player  = createPlayer(board.getWorldAt(0)); 

        boolean areAllBossesDead = false;
        
        //TODO showAvailableActions(...);

        while (!areAllBossesDead && player.isAlive()) {
            //TODO showAvailableActions(...); Peut-être n'afficher que les actions si le joueur le demande et s'il change de zone.
            doAnAction(player);

            //areAllBossesDead = are_all_boss_dead(board);
        }

        if (player.isAlive()) {
            Console.gameSuccessEnding(player);
        } else {
            Console.gameOverEnding(player);
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
