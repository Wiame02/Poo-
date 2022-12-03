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

    public static ArrayList<Villager> createVillagersValkiem(ArrayList<Monster> monsters){
        ArrayList<Villager> villagers = new ArrayList<Villager>();
        
        // Création des villageois
        villagers.add(new Villager("Chef Bebar", 100));
        villagers.add(new Villager("Sally", 100));
        villagers.add(new Villager("Obé", 100));
        villagers.add(new Villager("Oxianne", 100));
        villagers.add(new Villager("Lileo", 100));
        
        // Création des quêtes et liaison aux villageois
        villagers.get(0).set_quest(new QuestKillMonster("Mammouth nourissant",2,monsters.get(0)));
        villagers.get(0).get_quest().set_reward(new Item("Potagé à la viande"));

        villagers.get(1).set_quest(new QuestKillMonster("Gare au Griffon",2,monsters.get(2)));
        villagers.get(1).get_quest().set_reward(new Armor("Casque du griffon",40,50,Type.HELMET));

        villagers.get(2).set_quest(new QuestKillMonster("Molosse dérangeant",1,monsters.get(3)));
        villagers.get(2).get_quest().set_reward(new Armor("Cuissarde", 60, 40, Type.BOOT));

        villagers.get(3).set_quest(new QuestKillMonster("Pierre du Golem",5,monsters.get(4)));
        villagers.get(3).get_quest().set_reward(new Weapon("Massue destructrice", 100, 120));

        villagers.get(4).set_quest(new QuestRecoltItem("Pénurie de nourriture",1,villagers.get(0).get_quest().get_reward()));
        villagers.get(4).get_quest().set_reward(new Armor("Tunique en peau de Mammouth",80,30,Type.CHESTPLATE));



        // Création des dialogues et liaison aux villageois
            // 0 : Chef Bebar
        villagers.get(0).add_dialogue("Bonjour voyageur.se, si vous souhaitez un potage de mammouth, malheureusement je n'en ai plus. \n Mais ! Vous pourriez me rapporter de la viande de celui-ci !");
        villagers.get(0).add_dialogue("Merci beaucoup voyageur.se, revenez me voir dès que vous aurez réussi à en chasser un. Et un gros s'il vous plait !");
        villagers.get(0).add_dialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(0).add_dialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(0).add_dialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(0).add_dialogue("N'hésitez pas à aider mes compatriotes, ils vous le rendront fortement");
            // 1 : Sally
        villagers.get(1).add_dialogue("Eh vous là ! Vous voulez pas aller me chercher un griffon ? J'en ai besoin pour fabriquer des armures. Je vous offres un casque en échange.");
        villagers.get(1).add_dialogue("Ah bien le merci ! Reviens vite.");
        villagers.get(1).add_dialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(1).add_dialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(1).add_dialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(1).add_dialogue("Quand j'ouvrirais mon armurie j'espère que vous passerez !");

            // 2 : Obé
        villagers.get(2).add_dialogue("Excusez-moi, vous m'avez l'air fort.e et courageux.se, pourriez-vous éloigner les molosses de mon pré ? Une de mes vaches a déjà été attaquée, je n'ai pas envie d'en perdre plus. *snif*");
        villagers.get(2).add_dialogue("Vous me soulagez, n'hésitez pas à revenir me voir lorsque vous aurez réussi!");
        villagers.get(2).add_dialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(2).add_dialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(2).add_dialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(2).add_dialogue("Merci encore pour la dernière fois, grâce à vous je n'ai plus aucun problème.");
        
            // 3 : Oxianne
        villagers.get(3).add_dialogue("Salut toi ! C'est quoi cette arme ? J'en fais des meilleures moi ! Tiens je sais ce qu'on va faire. Si tu me ramènes la perle d'un golem, je te fais une arme sur mesure ! Alors, ca te va ?");
        villagers.get(3).add_dialogue("Ouais ! Enfin quelqu'un qui accepte !");
        villagers.get(3).add_dialogue("Pouah... T'es pas fun ! Reviens si jamais tu changes d'avis !");
        villagers.get(3).add_dialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(3).add_dialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(3).add_dialogue("Oh salut ! J'ai pas d'autres marché à faire avec toi. Reviens plus tard, peut-être que j'aurais trouver quelque chose.");

            // 4 : Liléo
        villagers.get(4).add_dialogue("Bonjour, j'aimerais beaucoup que vous me rendiez service. Il manque de la nourriture à l'infirmerie, pourrier-vous nous en rapporter auprè du chef ?");
        villagers.get(4).add_dialogue("Merci beaucoup, vous êtes d'une grande aide !");
        villagers.get(4).add_dialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(4).add_dialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(4).add_dialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(4).add_dialogue("Tiens vous voilà, je vous remercies pour la dernière fois. Vous avez été d'une grande aide.");
        

        return villagers;
    }

    public static ArrayList<Villager> createVillagersCimebel(ArrayList<Monster> monsters){
        ArrayList<Villager> villagers = new ArrayList<Villager>();

        // Création des villageois
        villagers.add(new Villager("Maire Robert", 100));
        villagers.add(new Villager("Ophélie", 100));
        villagers.add(new Villager("Maxime", 100));
        villagers.add(new Villager("Sylvia", 100));
        villagers.add(new Villager("Jules", 100));
        villagers.add(new Villager("Juliette", 100));
        villagers.add(new Villager("Gaspard", 100));
        
        // Création des quêtes et liaison aux villageois
            // 0 : Maire Robert
        villagers.get(0).set_quest(new QuestKillMonster("Pierre du Djin",1,monsters.get(6)));
        villagers.get(0).get_quest().set_reward(new Item("Pierre Ecarlate"));
            // 1 : Ophélie
        villagers.get(1).set_quest(new QuestKillMonster("Invasion",1,monsters.get(0)));
        villagers.get(1).get_quest().set_reward(new Item("Trousse de secours"));
            // 2 : Maxime
        villagers.get(2).set_quest(new QuestKillMonster("Ville en destruction",1,monsters.get(4)));
        villagers.get(2).get_quest().set_reward(new Armor("Gilet pareballe",150,85,Type.CHESTPLATE));
            // 3 : Sylvia
        villagers.get(3).set_quest(new QuestRecoltItem("Matériel à améliorer",1,villagers.get(0).get_quest().get_reward()));
        villagers.get(3).get_quest().set_reward(new Weapon("Fusil magique",85,70));
            // 4 : Jules
        villagers.get(3).set_quest(new QuestRecoltItem("Bléssés en détresse",1,villagers.get(0).get_quest().get_reward()));
        villagers.get(3).get_quest().set_reward(new Item("Bon de ravitaillement"));
            // 5 : Juliette
        villagers.get(4).set_quest(new QuestKillMonster("Abréger les soufrances",1,monsters.get(2)));
        villagers.get(4).get_quest().set_reward(new Armor("Casque de chantier",20,30,Type.HELMET));
            // 6 : Gaspard
        villagers.get(5).set_quest(new QuestRecoltItem("Besoin en matériel",1,villagers.get(3).get_quest().get_reward()));
        villagers.get(5).get_quest().set_reward(new Armor("Chaussures renforcées",60,60,Type.BOOT));

        // Création des dialogues et liaison aux villageois
        // Création des dialogues et liaison aux villageois
            // 0
        villagers.get(0).add_dialogue("");
            // 1
        villagers.get(1).add_dialogue("");
            // 2
        villagers.get(2).add_dialogue("");
            // 3
        villagers.get(3).add_dialogue("");
            // 4
        villagers.get(4).add_dialogue("");
            // 5
        villagers.get(4).add_dialogue("");
            // 6
        villagers.get(4).add_dialogue("");

        return villagers;
    }

    public static ArrayList<Villager> createVillagersCodix(ArrayList<Monster> monsters){
        ArrayList<Villager> villagers = new ArrayList<Villager>();

        // Création des villageois
        villagers.add(new Villager("Chef de Brigade Marianne", 100));
        villagers.add(new Villager("Agent 007", 100));
        villagers.add(new Villager("Agent 117", 100));
        villagers.add(new Villager("Chercheur-cultivateur Olivier", 100));
        villagers.add(new Villager("Etudiant Sophian", 100));
        villagers.add(new Villager("Enseignant Didier", 100));
        villagers.add(new Villager("Droide C3PO", 100));
        
        // Création des quêtes et liaison aux villageois
            // 0 : Chef de Brigade Marianne
        villagers.get(0).set_quest(new QuestKillMonster("A bat le demon",5,monsters.get(4)));
        villagers.get(0).get_quest().set_reward(new Weapon("Lance de Luchi",1000,300));
            // 1 : Agent 007
        villagers.get(1).set_quest(new QuestKillMonster("Bug de drone",1,monsters.get(1)));
        villagers.get(1).get_quest().set_reward(new Item("Puce mémoire"));
            // 2 :  Agent 117
        villagers.get(2).set_quest(new QuestRecoltItem("Analyse des bugs",1,villagers.get(1).get_quest().get_reward()));
        villagers.get(2).get_quest().set_reward(new Armor("Casque d'agent",50,35,Type.HELMET));
            // 6 : Droide C3PO
        villagers.get(6).set_quest(new QuestKillMonster("Cyborg en mission",1,monsters.get(2)));
        villagers.get(6).get_quest().set_reward(new Item("Herbes glaciales"));
            // 3 : Chercheur-cultivateur Olivier
        villagers.get(3).set_quest(new QuestRecoltItem("Analyse des bugs",1,villagers.get(6).get_quest().get_reward()));
        villagers.get(3).get_quest().set_reward(new Armor("Tunique en lin OGM",120,72,Type.CHESTPLATE));
            // 4 : Etudiant Sophian
        villagers.get(4).set_quest(new QuestKillMonster("cyborg disparu",1,monsters.get(3)));
        villagers.get(4).get_quest().set_reward(new Armor("Bottes volées",15,60,Type.BOOT));  
            // 5 : Enseignant Didier
        villagers.get(5).set_quest(new QuestKillMonster("Peau du Dragon",2,monsters.get(5)));
        villagers.get(5).get_quest().set_reward(new Armor("Pantalon innovant",120,95,Type.LEGGING));

        // Création des dialogues et liaison aux villageois
            // 0
        villagers.get(0).add_dialogue("");
            // 1
        villagers.get(1).add_dialogue("");
            // 2
        villagers.get(2).add_dialogue("");
            // 3
        villagers.get(3).add_dialogue("");
            // 4
        villagers.get(4).add_dialogue("");
            // 5
        villagers.get(4).add_dialogue("");
            // 6
        villagers.get(4).add_dialogue("");
        return villagers;
    }

    public static ArrayList<ArrayList<Villager>> dataVillagers(ArrayList<Monster> monstersValkiem,ArrayList<Monster>monstersCimebel,ArrayList<Monster>monstersCodix){
        ArrayList<ArrayList<Villager>> villagers = new ArrayList<ArrayList<Villager>>();

        villagers.add(createVillagersValkiem(monstersValkiem));
        villagers.add(createVillagersCimebel(monstersCimebel));
        villagers.add(createVillagersCodix(monstersCodix));

        return villagers;
    }

    /*
     * Templates
     */

    /* QuestKillMonster
    villagers.get().set_quest(new QuestKillMonster("",,monsters.get()));
    villagers.get().get_quest().set_reward(new Item(""));
    */

    /* QuestRecoltItem
    villagers.get().set_quest(new QuestRecoltItem("",1,villagers.get().get_quest().get_reward()));
    villagers.get().get_quest().set_reward(new );
    */
}
