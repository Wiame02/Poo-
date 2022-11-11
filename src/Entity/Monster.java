package Entity;

/**
 * Cette sous-classe s'intitule Monster,
 * elle regroupe les differents especes de monstres
 * presentes au sein de notre projet.
 * @author Nathan Doussin
 */


public class Monster extends Entity{
	
	private Species species;
	private int attack;

	public Monster(Species species, int attack){
		super(name, hp);
		this.species = species;
		this.attack = 0;
	}
	
	//--------------METHODES-------------
	
	/**
	 * GETTERS
	 */
	
	public String get_species(){return this.species;}
	public double get_attack(){return this.attack;}
	
	/**
	 * SETTERS
	 */
	
	public void set_species(Species species){this.species=species;}
	public void set_attack(int attack){
		if(attack <= 0){
			 this.attack = 0;
		} else {
			this.attack = attack;
		}
	}
}
