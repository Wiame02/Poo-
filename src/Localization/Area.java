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
     * @param name Chaine de caractere representant le nom de la zone
     */
    public Area(String name) {
        this.name = name;
        this.entities = new ArrayList<Entity>();
        this.actions = new ArrayList<String>();
    }

    /**
     * GETTERS
     */
    public String get_name()            {return this.name;}
    public Entity get_entity_at(int i)  {return this.entities.get(i);}
    public String get_action_at(int i)  {return this.actions.get(i);}

    /**
     * SETTERS
     */
    public void set_name(String name) {this.name = name;}
    
    /**
     * Ajoute une entite dans la zone
     * @param ent Entite
     */
    public void add_entity(Entity ent) {
        this.entities.add(ent);
    }

    /**
     * Ajoute une action possible dans la zone
     * @param act Chaine de caractere
     */
    public void add_action(String act) {
        this.actions.add(act);
    }

}