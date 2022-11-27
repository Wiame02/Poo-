package Localization;
import java.util.ArrayList;
import Entity.*;

/**
 * Area.java
 * Area décrit une zone qui permet le déroulement et l'interaction entre le joueur, les quêtes et les entités
 * @author Monique RIMBERT
 */

public class Area {
    private String name;
    private Entity entity;
    private ArrayList<String> actions;
    private World world;
    private ArrayList<Area> accessible_areas;

    /**
     * Constructeur de Area
     * @param name Chaine de caractere representant le nom de la zone
     */
    public Area(String name, Entity entity, World world) {
        this.name = name;
        this.entity = entity;
        this.actions = new ArrayList<String>();
        this.world = world;
        this.accessible_areas = new ArrayList<Area>();
    }

    public Area(String name, World world) {
        this.name = name;
        this.entity = null;
        this.actions = new ArrayList<String>();
        this.world = world;
        this.accessible_areas = new ArrayList<Area>();        
    }


    /**
     * GETTERS
     */
    public String get_name()            {return this.name;}
    public Entity get_entity()          {return this.entity;}
    public String get_action_at(int i)  {return this.actions.get(i);}
    public World  get_world()           {return this.world;}
    public ArrayList<Area> get_access_areas() {return this.accessible_areas;}

    /**
     * Recherche la zone par le nom donnée
     * @param name
     * @return null S'il n'y a pas de zone qui porte le meme nom
     * @return L'area qui porte le même nom qui a été entré
     */
    public Area get_access_area(String name) {
        for (Area a : this.accessible_areas){
            if (name.equals(a.get_name())){
                return a;
            }
        }
        return null;
    }

    /**
     * SETTERS
     */
    public void set_name(String name)   {this.name = name;}
    public void set_world(World world)  {this.world = world;}
    public void set_entity(Entity ent)  {this.entity = ent;}

    /**
     * Ajoute une action possible dans la zone
     * @param act Chaine de caractere
     */
    public void add_action(String act) {
        this.actions.add(act);
    }

    /**
     * Ajoute une zone accessible à partir de celle-ci 
     * @param area
     */
    public void add_accesible_area(Area area) {
        this.accessible_areas.add(area);
    }

    /**
     * Vérifie si une zone entree est accessible a partir de notre zone
     * @return true Si elle l'est
     */
    public boolean is_area_accessible(Area area) {
        return this.accessible_areas.contains(area);
    }

    /**
     * Procedure d'affichage de la classe Area
     */
    public String to_string() {
        String res = new String();

        res = "name: " + this.name + '\n';

        res+= "entities: " + this.entity.to_string();

        res+= "\nactions: ";
        for (int i=0; i<this.actions.size(); i++) {
            res+= this.actions.get(i) + ' ';
        }

        res+= "\nworld: " + world.to_string();

        return res;
    }

    public boolean is_equal (Area area) {
        boolean are_same = true;

        are_same = are_same && this.name.equals(area.name);
        are_same = are_same && this.world.is_equal(area.world);
        are_same = are_same && this.entity.is_equal(area.entity);
        
        return are_same;
    }
    public static void main(String[] args) {
        World w = new World("koko", Period.PAST, null);
        Entity m = new Monster("Cardigan", 6,Species.ALGOULE,50);
        

        Area testA = new Area("New World", m, w);
        System.out.println("DEFAULT : " + testA.toString());
        System.out.println("OTHER : " + testA.to_string());
    }
}