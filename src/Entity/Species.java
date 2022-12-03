package Entity;

/**
 * Cette sous-classe s'intitule Species,
 * elle regroupe les differents noms des especes
 * presentes au sein de notre projet.
 * @author Nathan Doussin
 */
 
public enum Species{
	VILLAGER("Villageois"),
	SUCCUBUS("Succube"),
	GRIFFIN("Griffon"),
	SPHINX("Sphinx"),
	MAMMOTH("Mammouth"),
	MASTIFF("Molosse"),
	DJIN("Djin"), // espece avec des competences magiques
	ICE_ELEMENTAL("Elementaire de glace"),
	EARTH_ELEMENTAL("Elementaire de terre"),
	FIRE_ELEMENTAL("Elementaire de feu"),
	WIND_ELEMENTAL("Elementaire de vent"),
	LIGHT_ELEMENTAL("Elementaire de lumiere"),
	WYVERN("Wyvern"), // espece avce un lien de parentée avec les dragons
	DRAGON("Dragon"),
	ANCESTRAL_DRAGON("Dragon ancestral"),
	DEMONIC_DRAGON("Dragon demoniaque"),
	GHOUL("Goule"),
	ALGOULE("Algoule"), // type de goule
	ZOMBIE("Zombie"),
	UNDEAD("Mort-vivant"),
	DEMON("Demon"),
	ELVES_DEMON("Elfes demon"),
	DRONE("Drone"),
	CYBORG("Cyborg"),
	SAINT("Saint"); // fusion des demons et elfes demons

	private String name;

	Species(String name){
	   this.name = name;
	}
	public String get_name(){ return this.name; }
}

