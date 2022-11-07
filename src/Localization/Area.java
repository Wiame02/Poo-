package Localization;
import java.util.ArrayList;
import Entity;

/**
 * Area.java
 * Area décrit une zone qui permet le déroulement et l'interaction entre le joueur, les quêtes et les entités
 * @author Monique RIMBERT
 */

public class Area {
    private String name;
    private ArrayList<Entity> entities;
    private ArrayList<String> actions;

    /**
     * Constructeur de Area
     * @param name Le nom de la zone
     */
    public Area(String name) {
        this.name = name;
        this.entities = new ArrayList<Entity>();
        this.actions = new ArrayList<String>();
    }
}