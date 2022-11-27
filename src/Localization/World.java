package Localization;
import java.util.ArrayList;
import Entity.Monster;

/**
 * World.java
 * World décrit un monde dans une temporalité, où se trouve plusieurs zones
 * @author Monique RIMBERT
 */

public class World {
    private String name;
    private ArrayList<Area> areas;
    private Period era;
    private Monster boss;
    //private ArrayList<Events> events;

    /**
     * Constructeur de World
     * @param name  Le nom de la zone
     * @param era   La temporalité du monde
     * @param boss  Le boss final du monde
     */
    public World(String name, Period era, Monster boss){
        this.name = name;
        this.areas = new ArrayList<Area>();
        this.era = era;
        this.boss = boss;
    }
    public World(String name, Period era){
        this.name = name;
        this.areas = new ArrayList<Area>();
        this.era = era;
        this.boss = null;
    }

    /**
     * GETTERS
     */
    public String   get_name()          {return this.name;}
    public Area     get_area_at(int i)  {return this.areas.get(i);}
    public ArrayList<Area> get_areas()  {return this.areas;}
    public Period   get_era()           {return this.era;}
    public Monster  get_boss()          {return this.boss;}

    /**
     * SETTERS
     */
    public void set_name(String name)   {this.name = name;}
    public void set_era(Period era)     {this.era = era;}
    public void set_boss(Monster boss)  {this.boss = boss;}

    /**
     * Ajouter une zone
     * @param area
     */
    public void add_area(Area area) {
        this.areas.add(area);
    }

    /**
     * Formattage de l'affichage d'un Monde
     */
    public String to_string() {
        String txt = "name: " + this.name;
        txt += "\nperiod: " + era.toString();
        txt += "\nboss: ";
        txt += (this.boss!=null)?boss.to_string():"null";  
        txt += "\nareas: {";
        for (Area a : this.areas) {
            txt +=a.get_name();
        }
        txt +='}';
        return txt;
    }

    /**
     * @return Deux mondes son identiques
     */
    public boolean is_equal(World w) {
        return (this.name.equals(w.name) && this.era==w.era && this.boss.is_equal(w.boss));
    }

    public static void main(String[] args) {
        World w = new World("TestWorld", Period.FUTURE);
        Area a = new Area ("TestArea", w);
        w.add_area(a);
        System.out.println(w.to_string());
    }
}
