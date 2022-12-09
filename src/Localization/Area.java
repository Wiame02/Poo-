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
    private World world;
    private ArrayList<Area> accessibleAreas;

    /**
     * Constructeur de Area
     * @param name Chaine de caractere representant le nom de la zone
     * @param entity L'entité qui réside dans la zone
     * @param world Le monde auquel appartient la zone 
     */
    public Area(String name, Entity entity, World world) {
        this.name = name;
        this.entity = entity;
        this.world = world;
        this.accessibleAreas = new ArrayList<Area>();
    }

    /**
     * Constructeur d'un Area
     * @param name Chaine de caractere representant le nom de la zone
     * @param world Le monde auquel appartient la zone 
     */
    public Area(String name, World world) {
        this.name = name;
        this.entity = null;
        this.world = world;
        this.accessibleAreas = new ArrayList<Area>();        
    }


    /**
     * @return Le nom de la Zone
     */
    public String getName()            {return this.name;}

    /**
     * @return L'entité à cette Zone
     */
    public Entity getEntity()          {return this.entity;}

    /**
     * @return Le monde auquel appartient la zone
     */
    public World  getWorld()           {return this.world;}

    /**
     * @return La liste des zones accessibles par celle-ci
     */
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
     * Modifie le nom de la zone
     * @param name
     */
    public void setName(String name)   {this.name = name;}

    /**
     * Modifie le monde auquel appartient la zone
     * @param world
     */
    public void setWorld(World world)  {this.world = world;}

    /**
     * Remplace l'entité qui réside dans cette zone
     * @param ent
     */
    public void setEntity(Entity ent)  {this.entity = ent;}

    /**
     * Ajoute une zone accessible à partir de celle-ci 
     * @param area
     */
    public void addAccessibleArea(Area area) {
        this.accessibleAreas.add(area);
    }
    
    /**
    * Ajoute des zones accessibles à partir de celle-ci 
    * @param area La liste de toutes les zones accessibles à partir de celle-ci
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

        res+= "\nworld: " + world.getName();
        return res;
    }

    /**
     * Vérifie l'égalité entre deux zones
     * @param area
     * @return true Si les deux zones sont les mêmes
     */
    public boolean isEqual (Area area) {
        boolean areSame = true;

        areSame = areSame && this.name.equals(area.name);
        areSame = areSame && this.world.isEqual(area.world);
        areSame = areSame && this.entity.isEqual(area.entity);
        
        return areSame;
    }
    public static void main(String[] args) {
        World w = new World("koko", Period.PAST, null);
        Entity m = new Monster("Cardigan", 6,Species.ALGOULE,50);
        

        Area testA = new Area("New World", m, w);
        System.out.println("OTHER : " + testA.toString());
    }
}