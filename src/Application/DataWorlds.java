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

        // Ajouts des zones accessibles
            // Zone 0
        univers_cite.get_area_at(0).addAccessibleArea(univers_cite.get_area_at(1));
            // Zone 1
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(0));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(2));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(3));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(4));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(5));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(6));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(7));
        univers_cite.get_area_at(1).addAccessibleArea(univers_cite.get_area_at(8));
            // Zone 2
        univers_cite.get_area_at(2).addAccessibleArea(univers_cite.get_area_at(1));
            // Zone 3
        univers_cite.get_area_at(3).addAccessibleArea(univers_cite.get_area_at(1));
            // Zone 4
        univers_cite.get_area_at(4).addAccessibleArea(univers_cite.get_area_at(1));
            // Zone 5
        univers_cite.get_area_at(5).addAccessibleArea(univers_cite.get_area_at(1));
        univers_cite.get_area_at(5).addAccessibleArea(univers_cite.get_area_at(6));
            // Zone 6
        univers_cite.get_area_at(6).addAccessibleArea(univers_cite.get_area_at(1));
        univers_cite.get_area_at(6).addAccessibleArea(univers_cite.get_area_at(5));
        univers_cite.get_area_at(6).addAccessibleArea(univers_cite.get_area_at(9));
        univers_cite.get_area_at(6).addAccessibleArea(univers_cite.get_area_at(10));
            // Zone 7
        univers_cite.get_area_at(7).addAccessibleArea(univers_cite.get_area_at(1));
            // Zone 8
        univers_cite.get_area_at(8).addAccessibleArea(univers_cite.get_area_at(1));
            // Zone 9
        univers_cite.get_area_at(9).addAccessibleArea(univers_cite.get_area_at(6));
            // Zone 10
        univers_cite.get_area_at(10).addAccessibleArea(univers_cite.get_area_at(6));

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

        // Ajouts des zones accessibles
            // Zone 0
        valkiem.get_area_at(0).addAccessibleArea(valkiem.get_area_at(1));
        valkiem.get_area_at(0).addAccessibleArea(valkiem.get_area_at(2));
        valkiem.get_area_at(0).addAccessibleArea(valkiem.get_area_at(3));
        valkiem.get_area_at(0).addAccessibleArea(valkiem.get_area_at(4));
        valkiem.get_area_at(0).addAccessibleArea(valkiem.get_area_at(5));
        valkiem.get_area_at(0).addAccessibleArea(valkiem.get_area_at(6));
            // Zone 1
        valkiem.get_area_at(1).addAccessibleArea(valkiem.get_area_at(0));
            // Zone 2
        valkiem.get_area_at(2).addAccessibleArea(valkiem.get_area_at(0));
            // Zone 3
        valkiem.get_area_at(3).addAccessibleArea(valkiem.get_area_at(0));
        valkiem.get_area_at(3).addAccessibleArea(valkiem.get_area_at(4));
        valkiem.get_area_at(3).addAccessibleArea(valkiem.get_area_at(11));
            // Zone 4
        valkiem.get_area_at(4).addAccessibleArea(valkiem.get_area_at(0));
        valkiem.get_area_at(4).addAccessibleArea(valkiem.get_area_at(3));
            // Zone 5
        valkiem.get_area_at(5).addAccessibleArea(valkiem.get_area_at(0));
            // Zone 6
        valkiem.get_area_at(6).addAccessibleArea(valkiem.get_area_at(0));
        valkiem.get_area_at(6).addAccessibleArea(valkiem.get_area_at(7));
        valkiem.get_area_at(6).addAccessibleArea(valkiem.get_area_at(12));
            // Zone 7
        valkiem.get_area_at(7).addAccessibleArea(valkiem.get_area_at(6));
        valkiem.get_area_at(7).addAccessibleArea(valkiem.get_area_at(8));
            // Zone 8
        valkiem.get_area_at(8).addAccessibleArea(valkiem.get_area_at(7));
        valkiem.get_area_at(8).addAccessibleArea(valkiem.get_area_at(9));
        valkiem.get_area_at(8).addAccessibleArea(valkiem.get_area_at(10));
            // Zone 9
        valkiem.get_area_at(9).addAccessibleArea(valkiem.get_area_at(8));
            // Zone 10
        valkiem.get_area_at(10).addAccessibleArea(valkiem.get_area_at(8));
            // Zone 11
        valkiem.get_area_at(11).addAccessibleArea(valkiem.get_area_at(3));
        valkiem.get_area_at(11).addAccessibleArea(valkiem.get_area_at(12));
        valkiem.get_area_at(11).addAccessibleArea(valkiem.get_area_at(13));
        valkiem.get_area_at(11).addAccessibleArea(valkiem.get_area_at(14));
            // Zone 12
        valkiem.get_area_at(12).addAccessibleArea(valkiem.get_area_at(11));
        valkiem.get_area_at(12).addAccessibleArea(valkiem.get_area_at(6));
            // Zone 13
        valkiem.get_area_at(13).addAccessibleArea(valkiem.get_area_at(11));
            // Zone 14
        valkiem.get_area_at(14).addAccessibleArea(valkiem.get_area_at(11));

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

        // Ajouts des zones accessibles
            // Zone 0
        cimebel.get_area_at(0).addAccessibleArea(cimebel.get_area_at(1));
        cimebel.get_area_at(0).addAccessibleArea(cimebel.get_area_at(2));
            // Zone 1
        cimebel.get_area_at(1).addAccessibleArea(cimebel.get_area_at(0));
        cimebel.get_area_at(1).addAccessibleArea(cimebel.get_area_at(3));
        cimebel.get_area_at(1).addAccessibleArea(cimebel.get_area_at(9));
        cimebel.get_area_at(1).addAccessibleArea(cimebel.get_area_at(10));
        cimebel.get_area_at(1).addAccessibleArea(cimebel.get_area_at(11));
        cimebel.get_area_at(1).addAccessibleArea(cimebel.get_area_at(12));
            // Zone 2
        cimebel.get_area_at(2).addAccessibleArea(cimebel.get_area_at(0));
        cimebel.get_area_at(2).addAccessibleArea(cimebel.get_area_at(3));
        cimebel.get_area_at(2).addAccessibleArea(cimebel.get_area_at(4));
        cimebel.get_area_at(2).addAccessibleArea(cimebel.get_area_at(5));
        cimebel.get_area_at(2).addAccessibleArea(cimebel.get_area_at(6));
        cimebel.get_area_at(2).addAccessibleArea(cimebel.get_area_at(7));
            // Zone 3
        cimebel.get_area_at(3).addAccessibleArea(cimebel.get_area_at(1));
        cimebel.get_area_at(3).addAccessibleArea(cimebel.get_area_at(2));
            // Zone 4
        cimebel.get_area_at(4).addAccessibleArea(cimebel.get_area_at(2));
            // Zone 5
        cimebel.get_area_at(5).addAccessibleArea(cimebel.get_area_at(2));
            // Zone 6
        cimebel.get_area_at(6).addAccessibleArea(cimebel.get_area_at(2));
            // Zone 7
        cimebel.get_area_at(7).addAccessibleArea(cimebel.get_area_at(4));
        cimebel.get_area_at(7).addAccessibleArea(cimebel.get_area_at(8));
        cimebel.get_area_at(7).addAccessibleArea(cimebel.get_area_at(9));
            // Zone 8
        cimebel.get_area_at(8).addAccessibleArea(cimebel.get_area_at(7));
            // Zone 9
        cimebel.get_area_at(9).addAccessibleArea(cimebel.get_area_at(7));
        cimebel.get_area_at(9).addAccessibleArea(cimebel.get_area_at(1));
            // Zone 10
        cimebel.get_area_at(10).addAccessibleArea(cimebel.get_area_at(1));
            // Zone 11
        cimebel.get_area_at(11).addAccessibleArea(cimebel.get_area_at(1));
        cimebel.get_area_at(11).addAccessibleArea(cimebel.get_area_at(12));
            // Zone 12
        cimebel.get_area_at(12).addAccessibleArea(cimebel.get_area_at(1));
        cimebel.get_area_at(12).addAccessibleArea(cimebel.get_area_at(11));
        
        return cimebel;
    }

    /**
     * Crée le monde de Codix avec ses zones
     * @return le monde Codix
     */
    public static World create_codix(){
        World codix = new World("Codix", Period.FUTURE);

        // Création des zones
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

        // Ajouts des zones accessibles
            // Zone 0
        codix.get_area_at(0).addAccessibleArea(codix.get_area_at(1));
        codix.get_area_at(0).addAccessibleArea(codix.get_area_at(6));
            // Zone 1
        codix.get_area_at(1).addAccessibleArea(codix.get_area_at(0));
        codix.get_area_at(1).addAccessibleArea(codix.get_area_at(2));
        codix.get_area_at(1).addAccessibleArea(codix.get_area_at(3));
        codix.get_area_at(1).addAccessibleArea(codix.get_area_at(4));
        codix.get_area_at(1).addAccessibleArea(codix.get_area_at(5));
            // Zone 2
        codix.get_area_at(2).addAccessibleArea(codix.get_area_at(1));
            // Zone 3
        codix.get_area_at(3).addAccessibleArea(codix.get_area_at(1));
        codix.get_area_at(3).addAccessibleArea(codix.get_area_at(5));
            // Zone 4
        codix.get_area_at(4).addAccessibleArea(codix.get_area_at(1));
            // Zone 5
        codix.get_area_at(5).addAccessibleArea(codix.get_area_at(1));
        codix.get_area_at(5).addAccessibleArea(codix.get_area_at(3));
            // Zone 6
        codix.get_area_at(6).addAccessibleArea(codix.get_area_at(0));
        codix.get_area_at(6).addAccessibleArea(codix.get_area_at(7));
            // Zone 7
        codix.get_area_at(7).addAccessibleArea(codix.get_area_at(6));
        codix.get_area_at(7).addAccessibleArea(codix.get_area_at(8));
            // Zone 8
        codix.get_area_at(8).addAccessibleArea(codix.get_area_at(7));
        codix.get_area_at(8).addAccessibleArea(codix.get_area_at(9));
            // Zone 9
        codix.get_area_at(9).addAccessibleArea(codix.get_area_at(8));
        codix.get_area_at(9).addAccessibleArea(codix.get_area_at(10));
        codix.get_area_at(9).addAccessibleArea(codix.get_area_at(11));
            // Zone 10
        codix.get_area_at(10).addAccessibleArea(codix.get_area_at(9));
            // Zone 11
        codix.get_area_at(11).addAccessibleArea(codix.get_area_at(9));
        codix.get_area_at(11).addAccessibleArea(codix.get_area_at(12));
            // Zone 12
        codix.get_area_at(12).addAccessibleArea(codix.get_area_at(11));
        codix.get_area_at(12).addAccessibleArea(codix.get_area_at(13));
            // Zone 13
        codix.get_area_at(12).addAccessibleArea(codix.get_area_at(12));

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