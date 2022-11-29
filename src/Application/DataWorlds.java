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
    public static World createUniversCite(){
        World universCite = new World("Univers-Cité", Period.PRESENT);

        universCite.addArea(new Area("Entrée de l'Univers-Cité",universCite));
        universCite.addArea(new Area("Hall du Batiment 1",universCite));
        universCite.addArea(new Area("Amphi A",universCite));
        universCite.addArea(new Area("Amphi B",universCite));
        universCite.addArea(new Area("Amphi C",universCite));
        universCite.addArea(new Area("Cafétéria Le Patio'",universCite));
        universCite.addArea(new Area("Hall piscine",universCite));
        universCite.addArea(new Area("Salle i044",universCite));
        universCite.addArea(new Area("Bibliotheque Universitaire",universCite));
        universCite.addArea(new Area("Amphi D",universCite));
        universCite.addArea(new Area("Amphi E",universCite));

        // Ajouts des zones accessibles
            // Zone 0
        universCite.getAreaAt(0).addAccessibleArea(universCite.getAreaAt(1));
            // Zone 1
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(0));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(2));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(3));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(4));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(5));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(6));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(7));
        universCite.getAreaAt(1).addAccessibleArea(universCite.getAreaAt(8));
            // Zone 2
        universCite.getAreaAt(2).addAccessibleArea(universCite.getAreaAt(1));
            // Zone 3
        universCite.getAreaAt(3).addAccessibleArea(universCite.getAreaAt(1));
            // Zone 4
        universCite.getAreaAt(4).addAccessibleArea(universCite.getAreaAt(1));
            // Zone 5
        universCite.getAreaAt(5).addAccessibleArea(universCite.getAreaAt(1));
        universCite.getAreaAt(5).addAccessibleArea(universCite.getAreaAt(6));
            // Zone 6
        universCite.getAreaAt(6).addAccessibleArea(universCite.getAreaAt(1));
        universCite.getAreaAt(6).addAccessibleArea(universCite.getAreaAt(5));
        universCite.getAreaAt(6).addAccessibleArea(universCite.getAreaAt(9));
        universCite.getAreaAt(6).addAccessibleArea(universCite.getAreaAt(10));
            // Zone 7
        universCite.getAreaAt(7).addAccessibleArea(universCite.getAreaAt(1));
            // Zone 8
        universCite.getAreaAt(8).addAccessibleArea(universCite.getAreaAt(1));
            // Zone 9
        universCite.getAreaAt(9).addAccessibleArea(universCite.getAreaAt(6));
            // Zone 10
        universCite.getAreaAt(10).addAccessibleArea(universCite.getAreaAt(6));

        return universCite;
    }

    /**
     * Crée le monde de Valkiem avec ses zones
     * @return le monde Valkiem
     */
    public static World createValkiem(){
        World valkiem = new World("Valkïem", Period.PAST);

        valkiem.addArea(new Area("Foyer",valkiem));
        valkiem.addArea(new Area("Tente 1",valkiem));
        valkiem.addArea(new Area("Tente 2",valkiem));
        valkiem.addArea(new Area("Champs",valkiem));
        valkiem.addArea(new Area("Réserve",valkiem));
        valkiem.addArea(new Area("Tente du chef",valkiem));
        valkiem.addArea(new Area("Chemin sinueux",valkiem));
        valkiem.addArea(new Area("Entrée de la grotte",valkiem));
        valkiem.addArea(new Area("Croisement",valkiem));
        valkiem.addArea(new Area("Lac souterrain",valkiem));
        valkiem.addArea(new Area("Gisement de fer",valkiem));
        valkiem.addArea(new Area("Orée de la fôret",valkiem));
        valkiem.addArea(new Area("Rivière",valkiem));
        valkiem.addArea(new Area("Arbre ancien",valkiem));
        valkiem.addArea(new Area("Tente abandonée",valkiem));

        // Ajouts des zones accessibles
            // Zone 0
        valkiem.getAreaAt(0).addAccessibleArea(valkiem.getAreaAt(1));
        valkiem.getAreaAt(0).addAccessibleArea(valkiem.getAreaAt(2));
        valkiem.getAreaAt(0).addAccessibleArea(valkiem.getAreaAt(3));
        valkiem.getAreaAt(0).addAccessibleArea(valkiem.getAreaAt(4));
        valkiem.getAreaAt(0).addAccessibleArea(valkiem.getAreaAt(5));
        valkiem.getAreaAt(0).addAccessibleArea(valkiem.getAreaAt(6));
            // Zone 1
        valkiem.getAreaAt(1).addAccessibleArea(valkiem.getAreaAt(0));
            // Zone 2
        valkiem.getAreaAt(2).addAccessibleArea(valkiem.getAreaAt(0));
            // Zone 3
        valkiem.getAreaAt(3).addAccessibleArea(valkiem.getAreaAt(0));
        valkiem.getAreaAt(3).addAccessibleArea(valkiem.getAreaAt(4));
        valkiem.getAreaAt(3).addAccessibleArea(valkiem.getAreaAt(11));
            // Zone 4
        valkiem.getAreaAt(4).addAccessibleArea(valkiem.getAreaAt(0));
        valkiem.getAreaAt(4).addAccessibleArea(valkiem.getAreaAt(3));
            // Zone 5
        valkiem.getAreaAt(5).addAccessibleArea(valkiem.getAreaAt(0));
            // Zone 6
        valkiem.getAreaAt(6).addAccessibleArea(valkiem.getAreaAt(0));
        valkiem.getAreaAt(6).addAccessibleArea(valkiem.getAreaAt(7));
        valkiem.getAreaAt(6).addAccessibleArea(valkiem.getAreaAt(12));
            // Zone 7
        valkiem.getAreaAt(7).addAccessibleArea(valkiem.getAreaAt(6));
        valkiem.getAreaAt(7).addAccessibleArea(valkiem.getAreaAt(8));
            // Zone 8
        valkiem.getAreaAt(8).addAccessibleArea(valkiem.getAreaAt(7));
        valkiem.getAreaAt(8).addAccessibleArea(valkiem.getAreaAt(9));
        valkiem.getAreaAt(8).addAccessibleArea(valkiem.getAreaAt(10));
            // Zone 9
        valkiem.getAreaAt(9).addAccessibleArea(valkiem.getAreaAt(8));
            // Zone 10
        valkiem.getAreaAt(10).addAccessibleArea(valkiem.getAreaAt(8));
            // Zone 11
        valkiem.getAreaAt(11).addAccessibleArea(valkiem.getAreaAt(3));
        valkiem.getAreaAt(11).addAccessibleArea(valkiem.getAreaAt(12));
        valkiem.getAreaAt(11).addAccessibleArea(valkiem.getAreaAt(13));
        valkiem.getAreaAt(11).addAccessibleArea(valkiem.getAreaAt(14));
            // Zone 12
        valkiem.getAreaAt(12).addAccessibleArea(valkiem.getAreaAt(11));
        valkiem.getAreaAt(12).addAccessibleArea(valkiem.getAreaAt(6));
            // Zone 13
        valkiem.getAreaAt(13).addAccessibleArea(valkiem.getAreaAt(11));
            // Zone 14
        valkiem.getAreaAt(14).addAccessibleArea(valkiem.getAreaAt(11));

        return valkiem;
    }

    /**
     * Crée le monde de Cimebel avec ses zones
     * @return le monde cimebel
     */
    public static World createCimebel(){
        World cimebel = new World("Cimebel", Period.PRESENT);
        
        cimebel.addArea(new Area("Mairie", cimebel));
        cimebel.addArea(new Area("Avenue", cimebel));
        cimebel.addArea(new Area("Boulevard", cimebel));
        cimebel.addArea(new Area("Quartier renforcé", cimebel));
        cimebel.addArea(new Area("Commerce", cimebel));
        cimebel.addArea(new Area("Maison", cimebel));
        cimebel.addArea(new Area("Gare", cimebel));
        cimebel.addArea(new Area("Cimetière", cimebel));
        cimebel.addArea(new Area("Ruines de Bollève", cimebel));
        cimebel.addArea(new Area("Autel", cimebel));
        cimebel.addArea(new Area("Musée", cimebel));
        cimebel.addArea(new Area("Parc", cimebel));
        cimebel.addArea(new Area("Pharmacie", cimebel));

        // Ajouts des zones accessibles
            // Zone 0
        cimebel.getAreaAt(0).addAccessibleArea(cimebel.getAreaAt(1));
        cimebel.getAreaAt(0).addAccessibleArea(cimebel.getAreaAt(2));
            // Zone 1
        cimebel.getAreaAt(1).addAccessibleArea(cimebel.getAreaAt(0));
        cimebel.getAreaAt(1).addAccessibleArea(cimebel.getAreaAt(3));
        cimebel.getAreaAt(1).addAccessibleArea(cimebel.getAreaAt(9));
        cimebel.getAreaAt(1).addAccessibleArea(cimebel.getAreaAt(10));
        cimebel.getAreaAt(1).addAccessibleArea(cimebel.getAreaAt(11));
        cimebel.getAreaAt(1).addAccessibleArea(cimebel.getAreaAt(12));
            // Zone 2
        cimebel.getAreaAt(2).addAccessibleArea(cimebel.getAreaAt(0));
        cimebel.getAreaAt(2).addAccessibleArea(cimebel.getAreaAt(3));
        cimebel.getAreaAt(2).addAccessibleArea(cimebel.getAreaAt(4));
        cimebel.getAreaAt(2).addAccessibleArea(cimebel.getAreaAt(5));
        cimebel.getAreaAt(2).addAccessibleArea(cimebel.getAreaAt(6));
        cimebel.getAreaAt(2).addAccessibleArea(cimebel.getAreaAt(7));
            // Zone 3
        cimebel.getAreaAt(3).addAccessibleArea(cimebel.getAreaAt(1));
        cimebel.getAreaAt(3).addAccessibleArea(cimebel.getAreaAt(2));
            // Zone 4
        cimebel.getAreaAt(4).addAccessibleArea(cimebel.getAreaAt(2));
            // Zone 5
        cimebel.getAreaAt(5).addAccessibleArea(cimebel.getAreaAt(2));
            // Zone 6
        cimebel.getAreaAt(6).addAccessibleArea(cimebel.getAreaAt(2));
            // Zone 7
        cimebel.getAreaAt(7).addAccessibleArea(cimebel.getAreaAt(4));
        cimebel.getAreaAt(7).addAccessibleArea(cimebel.getAreaAt(8));
        cimebel.getAreaAt(7).addAccessibleArea(cimebel.getAreaAt(9));
            // Zone 8
        cimebel.getAreaAt(8).addAccessibleArea(cimebel.getAreaAt(7));
            // Zone 9
        cimebel.getAreaAt(9).addAccessibleArea(cimebel.getAreaAt(7));
        cimebel.getAreaAt(9).addAccessibleArea(cimebel.getAreaAt(1));
            // Zone 10
        cimebel.getAreaAt(10).addAccessibleArea(cimebel.getAreaAt(1));
            // Zone 11
        cimebel.getAreaAt(11).addAccessibleArea(cimebel.getAreaAt(1));
        cimebel.getAreaAt(11).addAccessibleArea(cimebel.getAreaAt(12));
            // Zone 12
        cimebel.getAreaAt(12).addAccessibleArea(cimebel.getAreaAt(1));
        cimebel.getAreaAt(12).addAccessibleArea(cimebel.getAreaAt(11));
        
        return cimebel;
    }

    /**
     * Crée le monde de Codix avec ses zones
     * @return le monde Codix
     */
    public static World createCodix(){
        World codix = new World("Codix", Period.FUTURE);

        // Création des zones
        codix.addArea(new Area("Douane (Unité Centrale)", codix));
        codix.addArea(new Area("unité Centrale", codix));
        codix.addArea(new Area("Tour des affaires", codix));
        codix.addArea(new Area("Stockage", codix));
        codix.addArea(new Area("Ecole centrale", codix));
        codix.addArea(new Area("Unité Artihmétique et Logique", codix));
        codix.addArea(new Area("Salle du portail (Unité Centrale)", codix));
        codix.addArea(new Area("Salle du portail (Extérieur)", codix));
        codix.addArea(new Area("Douane (Extérieur)", codix));
        codix.addArea(new Area("Cellules d'habitations", codix));
        codix.addArea(new Area("Laboratoire de cultures", codix));
        codix.addArea(new Area("Pied du mont Luchi", codix));
        codix.addArea(new Area("Gorges du diable", codix));
        codix.addArea(new Area("Pic du mint Luchi", codix));

        // Ajouts des zones accessibles
            // Zone 0
        codix.getAreaAt(0).addAccessibleArea(codix.getAreaAt(1));
        codix.getAreaAt(0).addAccessibleArea(codix.getAreaAt(6));
            // Zone 1
        codix.getAreaAt(1).addAccessibleArea(codix.getAreaAt(0));
        codix.getAreaAt(1).addAccessibleArea(codix.getAreaAt(2));
        codix.getAreaAt(1).addAccessibleArea(codix.getAreaAt(3));
        codix.getAreaAt(1).addAccessibleArea(codix.getAreaAt(4));
        codix.getAreaAt(1).addAccessibleArea(codix.getAreaAt(5));
            // Zone 2
        codix.getAreaAt(2).addAccessibleArea(codix.getAreaAt(1));
            // Zone 3
        codix.getAreaAt(3).addAccessibleArea(codix.getAreaAt(1));
        codix.getAreaAt(3).addAccessibleArea(codix.getAreaAt(5));
            // Zone 4
        codix.getAreaAt(4).addAccessibleArea(codix.getAreaAt(1));
            // Zone 5
        codix.getAreaAt(5).addAccessibleArea(codix.getAreaAt(1));
        codix.getAreaAt(5).addAccessibleArea(codix.getAreaAt(3));
            // Zone 6
        codix.getAreaAt(6).addAccessibleArea(codix.getAreaAt(0));
        codix.getAreaAt(6).addAccessibleArea(codix.getAreaAt(7));
            // Zone 7
        codix.getAreaAt(7).addAccessibleArea(codix.getAreaAt(6));
        codix.getAreaAt(7).addAccessibleArea(codix.getAreaAt(8));
            // Zone 8
        codix.getAreaAt(8).addAccessibleArea(codix.getAreaAt(7));
        codix.getAreaAt(8).addAccessibleArea(codix.getAreaAt(9));
            // Zone 9
        codix.getAreaAt(9).addAccessibleArea(codix.getAreaAt(8));
        codix.getAreaAt(9).addAccessibleArea(codix.getAreaAt(10));
        codix.getAreaAt(9).addAccessibleArea(codix.getAreaAt(11));
            // Zone 10
        codix.getAreaAt(10).addAccessibleArea(codix.getAreaAt(9));
            // Zone 11
        codix.getAreaAt(11).addAccessibleArea(codix.getAreaAt(9));
        codix.getAreaAt(11).addAccessibleArea(codix.getAreaAt(12));
            // Zone 12
        codix.getAreaAt(12).addAccessibleArea(codix.getAreaAt(11));
        codix.getAreaAt(12).addAccessibleArea(codix.getAreaAt(13));
            // Zone 13
        codix.getAreaAt(12).addAccessibleArea(codix.getAreaAt(12));

        return codix;
    }

    /**
     * Retourne la liste des données des mondes
     * @return la liste des mondes crées
     */
    public static ArrayList<World> dataWorlds(){
        ArrayList<World> worlds = new ArrayList<World>();
        worlds.add(createUniversCite());
        worlds.add(createValkiem());
        worlds.add(createCimebel());
        worlds.add(createCodix());

        return worlds;
    }
}