package Application;
import java.util.ArrayList;

import Localization.*;

/**
 * Décrit les zones présentes sur la carte
 * @author Hignard Katel
 */

public class DataWorlds {

    /**
     * Crée le monde de l'univers-cité avec ses zones
     * @return le monde Univers-cité
     */
    public static World create_univers_cite(){
        World univers_cite = new World("Univers-Cité", Period.PRESENT);

        univers_cite.add_area(new Area("Bibliotheque Universitaire",univers_cite));
        univers_cite.add_area(new Area("Cafétéria Le Patio'",univers_cite));
        univers_cite.add_area(new Area("Amphi A",univers_cite));
        univers_cite.add_area(new Area("Amphi B",univers_cite));
        univers_cite.add_area(new Area("Amphi C",univers_cite));
        univers_cite.add_area(new Area("Amphi D",univers_cite));
        univers_cite.add_area(new Area("Amphi E",univers_cite));
        univers_cite.add_area(new Area("Hall du Batiment 1",univers_cite));
        univers_cite.add_area(new Area("Hall piscine",univers_cite));
        univers_cite.add_area(new Area("Salle i044",univers_cite));

        // TODO : Faire les liaisons (graphe)

        return univers_cite;
    }

    /**
     * Crée le monde de Valkiem avec ses zones
     * @return le monde Valkiem
     */
    public static World create_valkiem(){
        World valkiem = new World("Valkïem", Period.PAST);

        valkiem.add_area(new Area("Entrée de la Mine",valkiem));
        valkiem.add_area(new Area("Lac souterrain",valkiem));
        valkiem.add_area(new Area("",valkiem));
        //TODO : Faire les zones

        // TODO : Faire les liaisons (graphe)

        return valkiem;
    }

    /**
     * Crée le monde de Cimebel avec ses zones
     * @return le monde cimebel
     */
    public static World create_cimebel(){
        World cimebel = new World("Cimebel", Period.PRESENT);
        
        cimebel.add_area(new Area("", cimebel));
        //TODO : Faire les zones

        // TODO : Faire les liaisons (graphe)

        return cimebel;
    }

    /**
     * Crée le monde de Codix avec ses zones
     * @return le monde Codix
     */
    public static World create_codix(){
        World codix = new World("Codix", Period.FUTURE);

        codix.add_area(new Area("", codix));
        //TODO : Faire les zones

        // TODO : Faire les liaisons (graphe)

        return codix;
    }

    /**
     * Retourne la liste des données des mondes
     * @return la liste des mondes crées
     */
    public static ArrayList<World> data_worlds(){
        ArrayList<World> worlds = new ArrayList<World>();
        worlds.add(create_univers_cite());
        worlds.add(create_valkiem());
        worlds.add(create_cimebel());
        worlds.add(create_codix());

        return worlds;
    }

}
