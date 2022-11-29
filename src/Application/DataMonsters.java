package Application;
import Entity.*;
import java.util.ArrayList;

/**
 * Dénombre tous les monstres qui exitent dans le jeu
 * @author Hignard Katel
 */

public class DataMonsters {
    
    public static ArrayList<Monster> createMonstersValkiem(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        
        monsters.add(new Monster("Mammouth Agé",150,Species.MAMMOTH,22));
        monsters.add(new Monster("Bébé Mammouth",25,Species.MAMMOTH,3));
        monsters.add(new Monster("Griffon ancestral",75,Species.GRIFFIN,10));
        monsters.add(new Monster("Molosse enragé",40,Species.MASTIFF,5));
        monsters.add(new Monster("Golem terreux",250,Species.EARTH_ELEMENTAL,45));

        return monsters;
    }

    public static ArrayList<Monster> createMonstersCimebel(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();

        monsters.add(new Monster("Zombie décomposé",25,Species.ZOMBIE,12));
        monsters.add(new Monster("Zombie",30,Species.ZOMBIE,25));
        monsters.add(new Monster("Mort-vivant 1",45,Species.UNDEAD,20));
        monsters.add(new Monster("Mort-vivant 2",20,Species.UNDEAD,3));
        monsters.add(new Monster("Goule",110,Species.GHOUL,30));
        monsters.add(new Monster("Algoule",40,Species.ALGOULE,5));
        monsters.add(new Monster("Djin mytérieux",80,Species.DJIN,45));

        return monsters;
    }

    public static ArrayList<Monster> createMonstersCodix(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();

        monsters.add(new Monster("Drone Défaillant",15, Species.DRONE, 30));
        monsters.add(new Monster("Drone Corrompu",20, Species.DRONE, 45));
        monsters.add(new Monster("Cyborg Défaillant", 150, Species.CYBORG, 75));
        monsters.add(new Monster("Cyborg corrompu", 230, Species.CYBORG, 120));
        monsters.add(new Monster("Luchi", 500, Species.DEMON, 175));
        monsters.add(new Monster("Dragon de Luchi", 430, Species.DEMONIC_DRAGON, 260));

        return monsters;
    }

    public static ArrayList<ArrayList<Monster>> data_monsters(){
        ArrayList<ArrayList<Monster>> monsters = new ArrayList<ArrayList<Monster>>();

        monsters.add(createMonstersValkiem());
        monsters.add(createMonstersCimebel());
        monsters.add(createMonstersCodix());

        return monsters;
    }
}
