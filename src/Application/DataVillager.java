package Application;
import Entity.Villager;
import java.util.ArrayList;

/**
 * Dénombre tous les personnages qui exitent dans le jeu
 * @author Hignard Katel
 */

public class DataVillager {

    public static ArrayList<Villager> create_Villagers_valkiem(){
        ArrayList<Villager> villagers = new ArrayList<Villager>();
        
        //TODO : Ajouter les villageois

        return villagers;
    }

    public static ArrayList<Villager> create_Villagers_cimebel(){
        ArrayList<Villager> villagers = new ArrayList<Villager>();

        //TODO : Ajouter les villageois

        return villagers;
    }

    public static ArrayList<Villager> create_Villagers_codix(){
        ArrayList<Villager> villagers = new ArrayList<Villager>();

        //TODO : Ajouter les villageois

        return villagers;
    }

    public static ArrayList<ArrayList<Villager>> data_Villagers(){
        ArrayList<ArrayList<Villager>> villagers = new ArrayList<ArrayList<Villager>>();

        villagers.add(create_Villagers_valkiem());
        villagers.add(create_Villagers_cimebel());
        villagers.add(create_Villagers_codix());

        return villagers;
    }
}
