package Localization;
import java.util.ArrayList;
import Entity.Entity;

/**
 * Area.java
 * Area décrit une zone qui permet le déroulement et l'interaction entre le joueur, les quêtes et les entités
 * @author Monique RIMBERT
 */

public class Area {
    private String name;
    private ArrayList<Entity> entities;
    private ArrayList<String> actions;
    private World world;

    /**
     * Constructeur de Area
     * @param name Chaine de caractere representant le nom de la zone
     */
    public Area(String name, World world) {
        this.name = name;
        this.entities = new ArrayList<Entity>();
        this.actions = new ArrayList<String>();
        this.world = world;
    }

    /**
     * GETTERS
     */
    public String get_name()            {return this.name;}
    public Entity get_entity_at(int i)  {return this.entities.get(i);}
    public String get_action_at(int i)  {return this.actions.get(i);}
    public World  get_world()           {return this.world;}

    /**
     * SETTERS
     */
    public void set_name(String name)   {this.name = name;}
    public void set_world(World world)  {this.world = world;}
    
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

    /**
     * Procedure d'affichage de la classe Area
     */
    public String to_string() {
        String res = new String();

        res = "name: " + this.name + '\n';

        res+= "entities: ";
        for (Entity e : this.entities) {
            res+=e.toString();
        }

        res+= "actions: " + this.actions.get(0);
        for (int i=1; i<this.actions.size(); i++) {
            res+= ';' + this.actions.get(i);
        }

        res+= "\nworld: " + world.to_string();

        return res;
    }

    public static void main(String[] args) {
        World w = new World("koko", Period.PAST, null);
        Entity e = new Entity("Cardigan", 6);
        

        Area testA = new Area("New World", w);
        testA.add_entity(e);
        System.out.println("DEFAULT : " + testA.toString());
        System.out.println("OTHER : " + testA.toString());
    }
}