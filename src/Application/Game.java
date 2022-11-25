package Application;
import Localization.Board;
import Localization.World;
import User.Player;
import Entity.*;

/**
 * Classe qui permet le déroulement et la création du jeu
 * @author Monique RIMBERT
 */

public class Game {
    /**
     * Choisi aléatoirement un boss final parmi les entitées présentes dans ce monde
     * @param world Le monde entré en modification
     */
    public static void choose_boss(World world, ArrayList<Monster>monsters){
            int i = (int) (Math.random()*(monsters.size()-1));
            world.set_boss(monsters.get(i);)
    }

    /**
     * Génère aléatoirement les entitées dans les zones du monde
     * @param world Le monde entré en modification
     */
    public static void generate_areas(World world, Set<Entity> entities){
        
        for (Entity e : entities) {
            int i = (int) (Math.random()*(world.get_areas().size()-1));

            while (world.get_area_at().get(i)==null) {
                i = (int) (Math.random()*(world.get_areas().size()-1));
            }

            world.get_area_at(i).set_entity(e);
        }
    }

    /**
     * Génération du plateau du jeu
     * @return le plateau construit
     */
    public static Board generate_board(){
        Board b = new Board();

        b.add_all_world(data_worlds());

        for (int i=1; i<b.get_worlds().size(); i++) {
            //generate_areas(b.get_world_at(i), .get(i-1));
            //choose_boss(b.get_world_at(i), .get(i-1));
        }
        return new Board();
    }

    /**
     * Création du personnage du joueur
     * @return le personnage du joueur
     */
    public static Player create_player(){
        //TODO
        return new Player(null, null, null);
    }

    /**
     * Execute la fontion qui a été entrée
     * @param func La fonction entrée avec son parametre sous forme de tableau
     * @throws GameException La fonction entrée soit n'est pas valide soit son paramètre ne l'est pas
     */
    public static void execute_function_input(ArrayList<String> func) {
        ArrayList<String> doable_actions = get_available_actions();
        if (func[0]=="kill") {
            //TODO verif param
        }
    }

    /**
     * Permet l'execution d'une entree du joueur
     * @param area La zone dans lequel se trouve le joueur
     * @param player Le joueur
     */
    public static void player_do_action(Area area, Player player) {
        try {
            ArrayList<String> input = new read_action();
            execute_function_input(input);
        }
        catch (GameExceptions e) {
	        System.out.println("Error in player_do_action() : " + e);
	        e.printStackTrace();
            player_do_action(Area area, Player player);
        }
    }

    /**
     * Déroulement du jeu
     */
    public static void play_game() {
        Player  player  = create_player(); 
        Board   board   = generate_board();

        boolean are_all_boss_dead  = true;
        boolean is_player_alive     = true;
        
        //TODO show_available_actions(...);

        while (!are_all_boss_dead && is_player_alive) {
            //TODO show_available_actions(...); Peut-être n'afficher que les actions si le joueur le demande et s'il change de zone.
            //TODO player_do_action(...);

            //TODO are_all_boss_alive = are_all_boss_dead();
            is_player_alive = player.get_hp()>0;
        }

        if (is_player_alive) {
            game_success_ending();
        } else {
            game_over_ending();
        }
    }

    public static void main(String[] args) {
        play_game();
    }
}
