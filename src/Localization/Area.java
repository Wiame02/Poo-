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
    private ArrayList<Area> accessibleAreas;

    /**
     * Constructeur de Area
     * @param name Chaine de caractere representant le nom de la zone
     */
    public Area(String name, Entity entity, World world) {
        this.name = name;
        this.entity = entity;
        this.actions = new ArrayList<String>();
        this.world = world;
        this.accessibleAreas = new ArrayList<Area>();
    }

    public Area(String name, World world) {
        this.name = name;
        this.entity = null;
        this.actions = new ArrayList<String>();
        this.world = world;
        this.accessibleAreas = new ArrayList<Area>();        
    }


    /**
     * GETTERS
     */
    public String getName()            {return this.name;}
    public Entity getEntity()          {return this.entity;}
    public String getActionAt(int i)   {return this.actions.get(i);}
    public World  getWorld()           {return this.world;}
    public ArrayList<Area> getAccessAreas() {return this.accessibleAreas;}

    /**
     * Recherche la zone par le nom donnée
     * @param name
     * @return null S'il n'y a pas de zone qui porte le meme nom
     * @return L'area qui porte le même nom qui a été entré
     */
    public Area getAccessArea(String name) {
        for (Area a : this.accessibleAreas){
            if (name.equals(a.getName())){
                return a;
            }
        }
        return null;
    }

    /**
     * SETTERS
     */
    public void setName(String name)   {this.name = name;}
    public void setWorld(World world)  {this.world = world;}
    public void setEntity(Entity ent)  {this.entity = ent;}

    /**
     * Ajoute une action possible dans la zone
     * @param act Chaine de caractere
     */
    public void addAction(String act) {
        this.actions.add(act);
    }

    /**
     * Ajoute une zone accessible à partir de celle-ci 
     * @param area
     */
    public void addAccessibleArea(Area area) {
        this.accessibleAreas.add(area);
    }
    
    /**
    * Ajoute des zones accessibles à partir de celle-ci 
    * @param area
    */
   public void addAllAccessibleArea(ArrayList<Area> areas) {
       this.accessibleAreas.addAll(areas);
   }

    /**
     * Vérifie si une zone entree est accessible a partir de notre zone
     * @return true Si elle l'est
     */
    public boolean isAreaAccessible(Area area) {
        return this.accessibleAreas.contains(area);
    }

    /**
     * Procedure d'affichage de la classe Area
     */
    @Override
    public String toString() {
        String res = new String();

        res = "name: " + this.name + '\n';

        res+= "entities: ";
        res+= (this.entity!=null)?this.entity.toString():"null";

        res+= "\nactions: ";
        for (int i=0; i<this.actions.size(); i++) {
            res+= this.actions.get(i) + ' ';
        }

        res+= "\nworld: " + world.getName();
        return res;
    }

    public boolean isEqual (Area area) {
        boolean areSame = true;

        areSame = areSame && this.name.equals(area.name);
        areSame = areSame && this.world.isEqual(area.world);
        areSame = areSame && this.entity.is_equal(area.entity);
        
        return areSame;
    }
    public static void main(String[] args) {
        World w = new World("koko", Period.PAST, null);
        Entity m = new Monster("Cardigan", 6,Species.ALGOULE,50);
        

        Area testA = new Area("New World", m, w);
        System.out.println("OTHER : " + testA.toString());
    }
}