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
}