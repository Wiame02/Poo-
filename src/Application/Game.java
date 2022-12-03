package Application;
import Localization.*;
import User.*;
import Entity.*;
import java.util.ArrayList;
import java.util.Set;

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
     * Génère aléatoirement les entitées dans les zones du monde
     * @param world Le monde entré en modification
     */
    public static void generateAreas(World world, Set<Entity> entities){
        
        for (Entity e : entities) {
            int i = (int) (Math.random()*(world.getAreas().size()-1));  //Un entier entre 0 et le nombre de zones dans le monde-1

            while (world.getAreaAt(i).getEntity()==null) {
                i = (int) (Math.random()*(world.getAreas().size()-1));
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

        b.addAllWorlds(DataWorlds.dataWorlds());

        for (int i=1; i<b.getWorlds().size(); i++) {
            //generateAreas(b.getWorldAt(i), .get(i-1));
            //chooseBoss(b.getWorldAt(i), .get(i-1));
        }
        return new Board();
    }

    /**
     * Création du personnage du joueur
     * @return le personnage du joueur
     */
    public static Player createPlayer(){
        //TODO
        return new Player(null, null, null);
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
     * @param area La zone dans lequel se trouve le joueur
     * @param player Le joueur
     */
    public static void doAnAction(Area area, Player player) {
        try {
            ArrayList<String> input = Console.readAction();
            executeFunctionInput(input);
        }
        catch (ApplicationException e) {
	        System.out.println("Error in playerDoAction() : " + e);
	        e.printStackTrace();
            doAnAction(area, player);
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
            are_dead = !board.getWorldAt(i).getBoss().is_alive();
            i++;
        }
        return are_dead;
    }

    /**
     * Déroulement du jeu
     */
    public static void playGame() {
        Player  player  = createPlayer(); 
        Board   board   = generateBoard();

        boolean areAllBossesDead  = true;
        boolean isPlayerAlive     = true;
        
        //TODO showAvailableActions(...);

        while (!areAllBossesDead && player.isAlive()) {
            //TODO showAvailableActions(...); Peut-être n'afficher que les actions si le joueur le demande et s'il change de zone.
            //TODO player_do_action(...);

            areAllBossesDead = are_all_boss_dead(board);
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
