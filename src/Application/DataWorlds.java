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

        univers_cite.add_area(new Area("Entrée de l'Univer-Cité",univers_cite));
        univers_cite.add_area(new Area("Hall du Batiment 1",univers_cite));
        univers_cite.add_area(new Area("Amphi A",univers_cite));
        univers_cite.add_area(new Area("Amphi B",univers_cite));
        univers_cite.add_area(new Area("Amphi C",univers_cite));
        univers_cite.add_area(new Area("Cafétéria Le Patio'",univers_cite));
        univers_cite.add_area(new Area("Hall piscine",univers_cite));
        univers_cite.add_area(new Area("Salle i044",univers_cite));
        univers_cite.add_area(new Area("Bibliotheque Universitaire",univers_cite));
        univers_cite.add_area(new Area("Amphi D",univers_cite));
        univers_cite.add_area(new Area("Amphi E",univers_cite));

        // TODO : Faire les liaisons (graphe)

        return univers_cite;
    }

    /**
     * Crée le monde de Valkiem avec ses zones
     * @return le monde Valkiem
     */
    public static World create_valkiem(){
        World valkiem = new World("Valkïem", Period.PAST);

        valkiem.add_area(new Area("Foyer",valkiem));
        valkiem.add_area(new Area("Tente 1",valkiem));
        valkiem.add_area(new Area("Tente 2",valkiem));
        valkiem.add_area(new Area("Champs",valkiem));
        valkiem.add_area(new Area("Réserve",valkiem));
        valkiem.add_area(new Area("Tente du chef",valkiem));
        valkiem.add_area(new Area("Chemin sinueux",valkiem));
        valkiem.add_area(new Area("Entrée de la grotte",valkiem));
        valkiem.add_area(new Area("Croisement",valkiem));
        valkiem.add_area(new Area("Lac souterrain",valkiem));
        valkiem.add_area(new Area("Gisement de fer",valkiem));
        valkiem.add_area(new Area("Orée de la fôret",valkiem));
        valkiem.add_area(new Area("Rivière",valkiem));
        valkiem.add_area(new Area("Arbre ancien",valkiem));
        valkiem.add_area(new Area("Tente abandonée",valkiem));

        // TODO : Faire les liaisons (graphe)

        return valkiem;
    }

    /**
     * Crée le monde de Cimebel avec ses zones
     * @return le monde cimebel
     */
    public static World create_cimebel(){
        World cimebel = new World("Cimebel", Period.PRESENT);
        
        cimebel.add_area(new Area("Mairie", cimebel));
        cimebel.add_area(new Area("Avenue", cimebel));
        cimebel.add_area(new Area("Boulevard", cimebel));
        cimebel.add_area(new Area("Quartier renforcé", cimebel));
        cimebel.add_area(new Area("Commerce", cimebel));
        cimebel.add_area(new Area("Maison", cimebel));
        cimebel.add_area(new Area("Gare", cimebel));
        cimebel.add_area(new Area("Cimetière", cimebel));
        cimebel.add_area(new Area("Ruines de Bollève", cimebel));
        cimebel.add_area(new Area("Autel", cimebel));
        cimebel.add_area(new Area("Musée", cimebel));
        cimebel.add_area(new Area("Parc", cimebel));
        cimebel.add_area(new Area("Pharmacie", cimebel));

        // TODO : Faire les liaisons (graphe)

        return cimebel;
    }

    /**
     * Crée le monde de Codix avec ses zones
     * @return le monde Codix
     */
    public static World create_codix(){
        World codix = new World("Codix", Period.FUTURE);

        codix.add_area(new Area("Douane (Unité Centrale)", codix));
        codix.add_area(new Area("unité Centrale", codix));
        codix.add_area(new Area("Tour des affaires", codix));
        codix.add_area(new Area("Stockage", codix));
        codix.add_area(new Area("Ecole centrale", codix));
        codix.add_area(new Area("Unité Artihmétique et Logique", codix));
        codix.add_area(new Area("Salle du portail (Unité Centrale)", codix));
        codix.add_area(new Area("Salle du portail (Extérieur)", codix));
        codix.add_area(new Area("Douane (Extérieur)", codix));
        codix.add_area(new Area("Cellules d'habitations", codix));
        codix.add_area(new Area("Laboratoire de cultures", codix));
        codix.add_area(new Area("Pied du mont Luchi", codix));
        codix.add_area(new Area("Gorges du diable", codix));
        codix.add_area(new Area("Pic du mint Luchi", codix));
        

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
