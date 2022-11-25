package Application;
import Entity.Monster;
import java.util.ArrayList;

/**
 * Dénombre tous les monstres qui exitent dans le jeu
 * @author Hignard Katel
 */

public class DataMonsters {
    
    public static ArrayList<Monster> create_monsters_valkiem(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        
        //TODO : Ajouter les monstres

        return monsters;
    }

    public static ArrayList<Monster> create_monsters_cimebel(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();

        //TODO : Ajouter les monstres

        return monsters;
    }

    public static ArrayList<Monster> create_monsters_codix(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();

        //TODO : Ajouter les monstres

        return monsters;
    }

    public static ArrayList<ArrayList<Monster>> data_monsters(){
        ArrayList<ArrayList<Monster>> monsters = new ArrayList<ArrayList<Monster>>();

        monsters.add(create_monsters_valkiem());
        monsters.add(create_monsters_cimebel());
        monsters.add(create_monsters_codix());

        return monsters;
    }
}
