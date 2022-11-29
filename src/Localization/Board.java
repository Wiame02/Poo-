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
    public World getWorldAt(int i) {return this.worlds.get(i);};
    public ArrayList<World> getWorlds() {return this.worlds;};

    /**
     * Ajout d'un nouveau monde sur notre plateau
     * @param world
     */
    public void addWorld(World world) {
        this.worlds.add(world);
    }
    
    /**
     * Ajout de plusieurs nouveaux mondes sur notre plateau
     * @param listWorld
     */
    public void addAllWorlds(ArrayList<World> listWorld) {
        this.worlds.addAll(listWorld);
    }
}