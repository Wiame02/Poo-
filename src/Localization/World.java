package Localization;
import java.util.ArrayList;
import Entity;

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

}
