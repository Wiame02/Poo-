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
    public static  ArrayList<ArrayList<Villager>> DATA_VILLAGERS = dataVillagers(DataMonsters.DATA_MONSTERS.get(0), DataMonsters.DATA_MONSTERS.get(1), DataMonsters.DATA_MONSTERS.get(2));
    public static  ArrayList<ArrayList<Entity>> DATA_ENTITIES = dataEntities(DATA_VILLAGERS, DataMonsters.DATA_MONSTERS);

    public static ArrayList<Villager> createVillagersValkiem(ArrayList<Monster> monsters){
        ArrayList<Villager> villagers = new ArrayList<Villager>();
        
        // Création des villageois
        villagers.add(new Villager("Chef Bebar", 100));
        villagers.add(new Villager("Sally", 100));
        villagers.add(new Villager("Obé", 100));
        villagers.add(new Villager("Oxianne", 100));
        villagers.add(new Villager("Lileo", 100));
        
        // Création des quêtes et liaison aux villageois
        villagers.get(0).setQuest(new QuestKillMonster("Mammouth nourissant",2,monsters.get(0)));
        villagers.get(0).getQuest().setReward(new Item("Potagé à la viande"));

        villagers.get(1).setQuest(new QuestKillMonster("Gare au Griffon",2,monsters.get(2)));
        villagers.get(1).getQuest().setReward(new Armor("Casque du griffon",40,50,Type.HELMET));

        villagers.get(2).setQuest(new QuestKillMonster("Molosse dérangeant",1,monsters.get(3)));
        villagers.get(2).getQuest().setReward(new Armor("Cuissarde", 60, 40, Type.BOOT));

        villagers.get(3).setQuest(new QuestKillMonster("Pierre du Golem",5,monsters.get(4)));
        villagers.get(3).getQuest().setReward(new Weapon("Massue destructrice", 100, 120));

        villagers.get(4).setQuest(new QuestRecoltItem("Pénurie de nourriture",1,villagers.get(0).getQuest().getReward()));
        villagers.get(4).getQuest().setReward(new Armor("Tunique en peau de Mammouth",80,30,Type.CHESTPLATE));



        // Création des dialogues et liaison aux villageois
            // 0 : Chef Bebar
        villagers.get(0).addDialogue("Bonjour voyageur.se, si vous souhaitez un potage de mammouth, malheureusement je n'en ai plus. \n Mais ! Vous pourriez me rapporter de la viande de celui-ci !");
        villagers.get(0).addDialogue("Merci beaucoup voyageur.se, revenez me voir dès que vous aurez réussi à en chasser un. Et un gros s'il vous plait !");
        villagers.get(0).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(0).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(0).addDialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(0).addDialogue("N'hésitez pas à aider mes compatriotes, ils vous le rendront fortement");
            // 1 : Sally
        villagers.get(1).addDialogue("Eh vous là ! Vous voulez pas aller me chercher un griffon ? J'en ai besoin pour fabriquer des armures. Je vous offres un casque en échange.");
        villagers.get(1).addDialogue("Ah bien le merci ! Reviens vite.");
        villagers.get(1).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(1).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(1).addDialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(1).addDialogue("Quand j'ouvrirais mon armurie j'espère que vous passerez !");

            // 2 : Obé
        villagers.get(2).addDialogue("Excusez-moi, vous m'avez l'air fort.e et courageux.se, pourriez-vous éloigner les molosses de mon pré ? Une de mes vaches a déjà été attaquée, je n'ai pas envie d'en perdre plus. *snif*");
        villagers.get(2).addDialogue("Vous me soulagez, n'hésitez pas à revenir me voir lorsque vous aurez réussi!");
        villagers.get(2).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(2).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(2).addDialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(2).addDialogue("Merci encore pour la dernière fois, grâce à vous je n'ai plus aucun problème.");
        
            // 3 : Oxianne
        villagers.get(3).addDialogue("Salut toi ! C'est quoi cette arme ? J'en fais des meilleures moi ! Tiens je sais ce qu'on va faire. Si tu me ramènes la perle d'un golem, je te fais une arme sur mesure ! Alors, ca te va ?");
        villagers.get(3).addDialogue("Ouais ! Enfin quelqu'un qui accepte !");
        villagers.get(3).addDialogue("Pouah... T'es pas fun ! Reviens si jamais tu changes d'avis !");
        villagers.get(3).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(3).addDialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(3).addDialogue("Oh salut ! J'ai pas d'autres marché à faire avec toi. Reviens plus tard, peut-être que j'aurais trouver quelque chose.");

            // 4 : Liléo
        villagers.get(4).addDialogue("Bonjour, j'aimerais beaucoup que vous me rendiez service. Il manque de la nourriture à l'infirmerie, pourrier-vous nous en rapporter auprè du chef ?");
        villagers.get(4).addDialogue("Merci beaucoup, vous êtes d'une grande aide !");
        villagers.get(4).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(4).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(4).addDialogue("Merci pour votre service j'apprécie beaucoup votre dévouement, voiçi votre récompense.");
        villagers.get(4).addDialogue("Tiens vous voilà, je vous remercies pour la dernière fois. Vous avez été d'une grande aide.");
        

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
        villagers.get(0).setQuest(new QuestKillMonster("Pierre du Djin",1,monsters.get(5)));
        villagers.get(0).getQuest().setReward(new Item("Pierre Ecarlate"));
            // 1 : Ophélie
        villagers.get(1).setQuest(new QuestKillMonster("Invasion",1,monsters.get(0)));
        villagers.get(1).getQuest().setReward(new Item("Trousse de secours"));
            // 2 : Maxime
        villagers.get(2).setQuest(new QuestKillMonster("Ville en destruction",1,monsters.get(3)));
        villagers.get(2).getQuest().setReward(new Armor("Gilet pareballe",150,85,Type.CHESTPLATE));
            // 3 : Sylvia
        villagers.get(3).setQuest(new QuestRecoltItem("Matériel à améliorer",1,villagers.get(0).getQuest().getReward()));
        villagers.get(3).getQuest().setReward(new Weapon("Fusil magique",85,70));
            // 4 : Jules
        villagers.get(4).setQuest(new QuestRecoltItem("Bléssés en détresse",1,villagers.get(1).getQuest().getReward()));
        villagers.get(4).getQuest().setReward(new Item("Bon de ravitaillement"));
            // 5 : Juliette
        villagers.get(5).setQuest(new QuestKillMonster("Abréger les soufrances",1,monsters.get(2)));
        villagers.get(5).getQuest().setReward(new Armor("Casque de chantier",20,30,Type.HELMET));
            // 6 : Gaspard
        villagers.get(6).setQuest(new QuestRecoltItem("Besoin en matériel",1,villagers.get(3).getQuest().getReward()));
        villagers.get(6).getQuest().setReward(new Armor("Chaussures renforcées",60,60,Type.BOOT));

        // Création des dialogues et liaison aux villageois
            // 0
        villagers.get(0).addDialogue("Bonjour aventurier.e ! Si jamais tu trouves un Djin j'aimerais beaucoup que tu me le rapportes, nous avons besoins d'informations sur cette entité.");
        villagers.get(0).addDialogue("Merci bien !");
        villagers.get(0).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(0).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(0).addDialogue("Olala ! Merci beaucoup !  Tenez vous pouvez récupérer sa perle, je n'en ai pas besoin.");
        villagers.get(0).addDialogue("Grâce à vous j'ai obtenus de merveilleuses informations sur les Djins !");

            // 1
        villagers.get(1).addDialogue("Eh, tu vois pas qu'on est débordés! Aide-nous un peu dis donc, va tuer des zombies!");
        villagers.get(1).addDialogue("Merci ! J'espères te revoir.");
        villagers.get(1).addDialogue("Ah bah sympa, merci de nous laissez comme ca... Si tu changes d'avis je te récompenserais peut-être.");
        villagers.get(1).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(1).addDialogue("C'est cool de nous avoir aidé, tiens pour la peine");
        villagers.get(1).addDialogue("J'en peux plus de ces zombies...");

            // 2
        villagers.get(2).addDialogue("Des goules sont en train de détruire la ville ! S'il vous plait aidez-nous !");
        villagers.get(2).addDialogue("Merci ! Dis moi quand tu auras réussi a t'en débarasser.");
        villagers.get(2).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(2).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(2).addDialogue("Merci beaucoup de nous avoir aidé !");
        villagers.get(2).addDialogue("Salut toi, j'espère que tu vas bien.");

            // 3
        villagers.get(3).addDialogue("Eh si jamais tu trouves une pierre de Djin, rapportes moi en une ! La maire m'a dis que ca pouvait etre très utile pour améliorer mes armes.");
        villagers.get(3).addDialogue("Super !");
        villagers.get(3).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(3).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(3).addDialogue("Merci pour le service ! Pour la peine je vais te choisir une arme, la tienne à pas l'air très efficace.");
        villagers.get(3).addDialogue("J'espère que l'arme de que je t'ai offerte de convient !");

            // 4
        villagers.get(4).addDialogue("S'il te plait tu peux aller me chercher une trousse de secours, je suis un peu amoché là !");
        villagers.get(4).addDialogue("Reviens vite ! J'ai pas envie d'être attaqué par des zombies en t'attendant...");
        villagers.get(4).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(4).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(4).addDialogue("Merci ! Tu me sauves la vie !");
        villagers.get(4).addDialogue("Je te suis redevant pour la dernière fois, merci encore !");

            // 5
        villagers.get(5).addDialogue("Excusez-moi... J'ai vue le corps de ma femme décédé errer... Pourrier-vous abréger ses souffrances ? Je sais qu'elle est déjà décédé mais cela me peine beaucoup... *snif*");
        villagers.get(5).addDialogue("Merci beaucoup.");
        villagers.get(5).addDialogue("Bien, merci tout de même de m'avoir écouté...");
        villagers.get(5).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(5).addDialogue("Merci beaucoup ! vous avez libéré l'esprit de ma femme...");
        villagers.get(5).addDialogue("Grâce à vous je suis apaisée");

            // 6
        villagers.get(6).addDialogue("Eh on m'a volé mon bon de ravitaillement ! Tu veux pas m'en ramener un ? Je t'échangerais un truc si tu veux !");
        villagers.get(6).addDialogue("Oh trop cool !");
        villagers.get(6).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(6).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(6).addDialogue("Merci beaucoup ! Tiens en échange.");
        villagers.get(6).addDialogue("J'hésiterais pas à refaire échange avec toi la prochaine fois.");

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
        villagers.get(0).setQuest(new QuestKillMonster("A bat le demon",5,monsters.get(4)));
        villagers.get(0).getQuest().setReward(new Weapon("Lance de Luchi",1000,300));
            // 1 : Agent 007
        villagers.get(1).setQuest(new QuestKillMonster("Bug de drone",1,monsters.get(1)));
        villagers.get(1).getQuest().setReward(new Item("Puce mémoire"));
            // 2 :  Agent 117
        villagers.get(2).setQuest(new QuestRecoltItem("Analyse des bugs",1,villagers.get(1).getQuest().getReward()));
        villagers.get(2).getQuest().setReward(new Armor("Casque d'agent",50,35,Type.HELMET));
            // 6 : Droide C3PO
        villagers.get(6).setQuest(new QuestKillMonster("Cyborg en mission",1,monsters.get(2)));
        villagers.get(6).getQuest().setReward(new Item("Herbes glaciales"));
            // 3 : Chercheur-cultivateur Olivier
        villagers.get(3).setQuest(new QuestRecoltItem("Mélange douteux",1,villagers.get(6).getQuest().getReward()));
        villagers.get(3).getQuest().setReward(new Armor("Tunique en lin OGM",120,72,Type.CHESTPLATE));
            // 4 : Etudiant Sophian
        villagers.get(4).setQuest(new QuestKillMonster("Cyborg disparu",1,monsters.get(3)));
        villagers.get(4).getQuest().setReward(new Armor("Bottes volées",15,60,Type.BOOT));  
            // 5 : Enseignant Didier
        villagers.get(5).setQuest(new QuestKillMonster("Peau du Dragon",2,monsters.get(5)));
        villagers.get(5).getQuest().setReward(new Armor("Pantalon innovant",120,95,Type.LEGGING));

        // Création des dialogues et liaison aux villageois
            // 0
        villagers.get(0).addDialogue("Salut guerrier.e ! Mon équipe et moi avons vraiment du mal à abattre le démon Luchi. Si tu as de la trempe, va l'affronter !");
        villagers.get(0).addDialogue("AHAHA ! bon courage !");
        villagers.get(0).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(0).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(0).addDialogue("tu m'impressiones ! Bravo de l'avoir abattus, tu me rends bien service !");
        villagers.get(0).addDialogue("Oh te revoila le héro !");

            // 1
        villagers.get(1).addDialogue("Mon drone a disparue, si jamais tu le retrouves ramènes le moi !");
        villagers.get(1).addDialogue("Merci d'avance !");
        villagers.get(1).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(1).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(1).addDialogue("Quoi ? Il t'a attaqué ? Je suis un oeu décu j'aimais beaucoup ce drône... Tiens sa puce, je sais que l'agent 117 aime bien récuperer les puces des drones défectueux.");
        villagers.get(1).addDialogue("Eh regardes j'ai un nouveau drône ! Il est encore plus performant qu'avant. J'espère qu'il n'aura pas de problème lui.");

            // 2
        villagers.get(2).addDialogue("Salut toi ! N'hésites pas a me rapporter des morceaux de drône, ou tout autre chose mécaniques. J'adore les analyser !");
        villagers.get(2).addDialogue("Merci d'avance !");
        villagers.get(2).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(2).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(2).addDialogue("Oooh... Je reconnais bien le drône de l'agent 007 là !");
        villagers.get(2).addDialogue("La puce que tu m'as ramener avait de précieuses informations ! Merci beaucoup !");

            // 3
        villagers.get(3).addDialogue("Bonjour ! J'ai envoyé mon droide chercher des herbes glaciales mais il est toujours pas revenu... Si jamais tu en trouves avant lui, rapportes les moi.");
        villagers.get(3).addDialogue("Bonnée journée !");
        villagers.get(3).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(3).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(3).addDialogue("Merci beaucoup ! Je vais pouvoir continuer mon expérience !");
        villagers.get(3).addDialogue("J'ai eu des super résultats grâce à toi ! (One eternity later...) Bref désolé je me suis emporté, et j'ai raconter tout mon processus de recherche... Aller va sinon je vais continuer !");

            // 4
        villagers.get(4).addDialogue("Hé oh, toi ! Il paraît qu'un certain cyborg rode dans les parages. Je n'ai pas envie de le croiser... enfin j'ai peur. Est-ce que tu peux l'achever pour moi ?");
        villagers.get(4).addDialogue("Merci infiniment ! Je m'en souviendrai !");
        villagers.get(4).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(4).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(4).addDialogue("Oh te revoilà et vainqueur ?! Merci beaucoup, je peux ne plus me faire de soucis maintenant !");
        villagers.get(4).addDialogue("Grâce à toi, je ressens moins de stress. Et en plus, je vais pouvoir passer mes examens tranquil. Merci encore !");

            // 5
        villagers.get(4).addDialogue("Hop hop hop, vous ! On ne cours pas ici ! Si vous ne voulez pas que je vous dénonce au Conseil vous avez intêret à suivre mes ordres et me trouver cette fichue peau de Dragon !");
        villagers.get(4).addDialogue("Tu as bien raison d'accepter. Sinon, tu aurais été dans de beaux draps !");
        villagers.get(4).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(4).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(4).addDialogue("Ah ! Voilà ma fameuse peau de Dragon... je la cherche depuis des années. Allez, filez avant que je ne change d'avis.");
        villagers.get(4).addDialogue("Hors de ma vue !");

            // 6
        villagers.get(4).addDialogue("bip boup bip bip ! Moi... bip... problème... boup");
        villagers.get(4).addDialogue("");
        villagers.get(4).addDialogue("Très bien, n'hésite pas à revenir me voir si tu changes d'avis");
        villagers.get(4).addDialogue("Revenez me voir quand vous aurez finis ma demande.");
        villagers.get(4).addDialogue("");
        villagers.get(4).addDialogue("");

        return villagers;
    }

    /**
     * Crée les données des villageois par monde
     * @param monstersValkiem   Les monstres dans Valkiem
     * @param monstersCimebel   Les monstres dans Cimebel
     * @param monstersCodix     Les monstres dans Codix
     * @return Les données des villageois par monde
     */
    public static ArrayList<ArrayList<Villager>> dataVillagers(ArrayList<Monster> monstersValkiem,ArrayList<Monster>monstersCimebel,ArrayList<Monster>monstersCodix){
        ArrayList<ArrayList<Villager>> villagers = new ArrayList<ArrayList<Villager>>();

        villagers.add(createVillagersValkiem(monstersValkiem));
        villagers.add(createVillagersCimebel(monstersCimebel));
        villagers.add(createVillagersCodix(monstersCodix));

        return villagers;
    }

    /**
     * Fusionne les données villageois et monstres afin de nous donner les informations des entités par monde
     * @param villagers Les données des villageois par monde
     * @param monsters  Les données des monstres par monde
     * @return  Les données des Entités par monde
     */
    public static ArrayList<ArrayList<Entity>> dataEntities (ArrayList<ArrayList<Villager>> villagers, ArrayList<ArrayList<Monster>> monsters) {
        ArrayList<ArrayList<Entity>> entities = new ArrayList<ArrayList<Entity>>();

        for (int i=0; i<villagers.size(); i++) {
            ArrayList<Entity> tmp = new ArrayList<Entity>();
            tmp.addAll(villagers.get(i));
            tmp.addAll(monsters.get(i));

            entities.add(tmp);
        }
        return entities;
    }
    /*
     * Templates
     */

    /* QuestKillMonster
    villagers.get().setQuest(new QuestKillMonster("",,monsters.get()));
    villagers.get().getQuest().set_reward(new Item(""));
    */

    /* QuestRecoltItem
    villagers.get().setQuest(new QuestRecoltItem("",1,villagers.get().getQuest().getReward()));
    villagers.get().getQuest().set_reward(new );
    */
}
