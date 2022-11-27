package Entity;

/**
 * Cette sous-classe s'intitule Species,
 * elle regroupe les differents noms des especes
 * presentes au sein de notre projet.
 * @author Nathan Doussin
 */
 
public enum Species{
	 
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
	WYVERN("Wyvern"), // espece lien parentée avec les dragons
	DRAGON("Dragon"),
	ANCESTRAL_DRAGON("Dragon ancestral"),
	DEMONIC_DRAGON("Dragon demoniaque"),
	GHOUL("Goule"),
	ALGOULE("Algoule"), // type de goule
	ZOMBIE("Zombie"),
	UNDEADV("Mort-vivant"),
	DEMON("Demon"),
	ELVES_DEMON("Elfes demon"),
	SAINT("Saint"); // fusion des demons et elfes demons

	private String name;

    /* Contructeur non utile à enlever
	 Species(String name){
     	    this(name);
     	 }
    */
	Species(String name){
	   this.name = name;
	}
	public String get_name(){ return this.name; }

	/* inutile : A enlever, soit tu fais un fichier a part pour tester soit tu mets directement le main (on evite les classes dans es classe)
	class Test
    {
        public static void main(String[] args)
        {
            Species species = Species.GRIFFIN;  // exemple d'appel d'une espece parmi la liste d'enumération
            System.out.print("L'espece est un(e) " + species.getName());
    }
    */
}

