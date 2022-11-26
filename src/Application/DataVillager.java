package Application;
import Entity.*;
import Quest.*;
import Stuff.*;

import java.util.ArrayList;

/**
 * Dénombre tous les personnages qui exitent dans le jeu
 * @author Hignard Katel
 */

public class DataVillager {

    public static ArrayList<Villager> create_villagers_valkiem(ArrayList<Monster> monsters_valkiem){
        ArrayList<Villager> villagers = new ArrayList<Villager>();
        
        // Création des villageois
        villagers.add(new Villager("Chef Bebar", 100, null));
        villagers.add(new Villager("Sally", 100, null));
        villagers.add(new Villager("Obé", 100, null));
        villagers.add(new Villager("Oxianne", 100, null));
        villagers.add(new Villager("Lileo", 100, null));
        
        // Création des quêtes et liaison aux villageois
        villagers.get(0).set_quest(
            new QuestKillMonster(
                "Mammouth nourrisant",
                new Item(null, 0),
                1,
                monsters_valkiem.get()
            )
        );
        


        // Création des dialogues et liaison aux villageois
            // 0 : Chef Bebar
        villagers.get(0).add_dialogue("");
            // 1 : Sally
        villagers.get(1).add_dialogue("");
            // 2 : Obé
        villagers.get(2).add_dialogue("");
            // 3 : Oxianne
        villagers.get(3).add_dialogue("");
            // 4 : Liléo
        villagers.get(4).add_dialogue("");
        return villagers;
    }

    public static ArrayList<Villager> create_villagers_cimebel(){
        ArrayList<Villager> villagers = new ArrayList<Villager>();

        // Création des villageois
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        
        // Création des quêtes et liaison aux villageois

        // Création des dialogues et liaison aux villageois

        return villagers;
    }

    public static ArrayList<Villager> create_villagers_codix(){
        ArrayList<Villager> villagers = new ArrayList<Villager>();

        // Création des villageois
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        villagers.add(new Villager("", 100, null, null));
        
        // Création des quêtes et liaison aux villageois

        // Création des dialogues et liaison aux villageois

        return villagers;
    }

    public static ArrayList<ArrayList<Villager>> data_villagers(){
        ArrayList<ArrayList<Villager>> villagers = new ArrayList<ArrayList<Villager>>();

        villagers.add(create_villagers_valkiem());
        villagers.add(create_villagers_cimebel());
        villagers.add(create_villagers_codix());

        return villagers;
    }

    /*
     * Templates
     */

    /* Création et ajout d'une QuestKillMonster
        villagers.get().set_quest(
            new QuestKillMonster(
                "",
                new Item("",,),
                1,
                monsters_valkiem.get()
            )
        );*/

    /* Création et ajout d'une QuestRecoltItem
    
        villagers.get().set_quest(
            new QuestRecoltItem(
                "",
                new Item("",,),
                1,
                // localisation de l'item
            )
        );
     */
}
