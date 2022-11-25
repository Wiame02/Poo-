package Localization;
import java.util.ArrayList;

/**
 * Board.java
 * Board décrit le plateau, là où se déroule le jeu.
 * @author Monique RIMBERT
 */

public class Board {
    private ArrayList<World> worlds;

    /**
     * Constructeur de Board
     */
    public Board() {
        this.worlds = new ArrayList<World>();
    }

    /**
     * GETTERS
     */
    public World get_world_at(int i) {return this.worlds.get(i);};
    public ArrayList<World> get_worlds() {return this.worlds;};

    /**
     * Ajout d'un nouveau monde sur notre plateau
     * @param w
     */
    public void add_world(World w) {
        this.worlds.add(w);
    }
    
    /**
     * Ajout de plusieurs nouveaux mondes sur notre plateau
     * @param l_w
     */
    public void add_all_worlds(ArrayList<World> l_w) {
        this.worlds.addAll(l_w);
    }
}