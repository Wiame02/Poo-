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

    /**
     * Constructeur de World
     * @param name  Le nom de la zone
     * @param era   La temporalité du monde
     */
    public World(String name, Period era){
        this.name = name;
        this.areas = new ArrayList<Area>();
        this.era = era;
        this.boss = null;
    }

    
    /**
     * @return Le nom du monde
     */
    public String   getName()          {return this.name;}

    /**
     * @return La zone à l'indice donné
     * @throws NullExceptionPointer i<0 et this.areas.size()>=i
     */
    public Area     getAreaAt(int i)  {return this.areas.get(i);}

    /**
     * @return Toutes les zones sur le monde
     */
    public ArrayList<Area> getAreas()  {return this.areas;}

    /**
     * @return La temporalité du monde
     */
    public Period   getEra()           {return this.era;}

    /**
     * @return Le boss final du monde
     */
    public Monster  getBoss()          {return this.boss;}

    /**
     * Modifie le nom du monde
     * @param name
     */
    public void setName(String name)   {this.name = name;}

    /**
     * Modifie la temporalité du monde
     * @param era
     */
    public void setEra(Period era)     {this.era = era;}
    
    /**
     * Remplace le boss final du monde, il doit être l'un des entités du monde
     * On part du principe où le boss est l'un des monstres d'une des zones du monde
     * @param boss
     */
    public void setBoss(Monster boss) {this.boss = boss;}

    /**
     * Ajouter une zone
     * @param area
     */
    public void addArea(Area area) {
        this.areas.add(area);
    }

    /**
     * Formattage de l'affichage d'un Monde
     */
    @Override
    public String toString() {
        String txt = "name: " + this.name;
        txt += "\nperiod: " + era.toString();
        txt += "\nboss: ";
        txt += (this.boss!=null)?boss.toString():"null";  
        txt += "\nareas: {";
        for (Area a : this.areas) {
            txt +=a.getName();
        }
        txt +='}';
        return txt;
    }

    /**
     * @return Deux mondes sont identiques
     */
    public boolean isEqual(World w) {
        return (this.name.equals(w.name) && this.era==w.era && this.boss.isEqual(w.boss));
    }

    public static void main(String[] args) {
        World w = new World("TestWorld", Period.FUTURE);
        Area a = new Area ("TestArea", w);
        w.addArea(a);
        System.out.println(w.toString());
    }
}
