package Entity;

/**
 * Cette sous-classe s'intitule Species,
 * elle regroupe les differents noms des especes
 * presentes au sein de notre projet.
 * @author Nathan Doussin
 */
 
 public enum Species{
	 
	 SUCCUBUS, // Succube
	 GRIFFIN, // Griffon
	 SPHINX,
	 MAMMOTH,
	 MASTIFF, // Molosse
	 DJIN, 
	 ICE_ELEMENTAL,
	 EARTH_ELEMENTAL,
	 FIRE_ELEMENTAL,
	 WIND_ELEMENTAL,
	 LIGHT_ELEMENTAL,
	 WYVERN,
	 DRAGON,
	 ANCESTRAL_DRAGON,
	 DEMONIC_DRAGON,
	 GHOUL,
	 ALGOULE,
	 ZOMBIE,
	 UNDEAD, //mort-vivant
	 DEMON,
	 ELVES_DEMON, // elfes demons
	 SAINT; // fusion des demons et elfes demons

	/* TODO : Ajouter une attributs nom qui est une chaine de carateres decrivant le nom en francais de chaque espace (ex: GRIFFIN("Griffon"))
	 * -> Permet un affichage plus simple
	 * + ajouter un constructeur pour les enumerations suite au changement (va voir sur google si jamais) 
	 */
}

