package Entity;

/**
 * Cette classe s'intitule Entity,
 * elle regroupe les differentes entites
 * present au sein de notre projet.
 * @author Nathan Doussin
 */
 
public abstract class Entity{
	protected String name;
	protected int hp;
	private Species species;

    /**
     * Constructeur
     * @param name le nom de l'entité
     * @param hp les points de vies de départ de l'entité
	 * @param species l'espèce de l'entité
    */
	public Entity(String name, int hp, Species species){
		this.name = name;
		this.setHp(hp);
		this.species = species;
	}
	
/*
 * GETTERS
 */
	public 	Species getSpecies()	{return this.species;}
	public 	String 	getName()		{return this.name;}
	public 	double 	getHp()			{return this.hp;}
	
/*
 * SETTERS
 */
	public void setSpecies(Species species)	{this.species=species;}
	public void setName(String name){this.name=name;}
	/**
	 * Modifie les hp de l'entité.
	 * Si les hp d'entrée sont inférieurs à 0 les hp sont mis à 0
	 * @param hp
	 */
	
	public String get_name(){return this.name;}

	public double get_hp(){return this.hp;}
	
	/**
	 * Affiche le nom de l'entité
	 */
	
	public void set_name(String name){this.name=name;}
	public void set_hp(int hp){this.hp=hp;}


	// ----------AFFICHAGE-------------

	void print_name(){
		System.out.println("le nom de l'entité est : " + this.name + "\n");
	}

	void print_hp(){
		System.out.println("le nombre de point(s) de vie de l'entité est : " + this.hp + "\n");
	}
	// ---------------------------------------------------------
	

	/**
	 * Retourne si une entite est vivante ou morte par son nombre de points de vie
	 * @return true si l'entite est vivante
	 * @return false si l'entite est morte (hp = 0)
	 */
	public boolean is_alive(){
		return (hp > 0);
	}

	/**
	* cette methode sert a diminuer
	* les points de vie en fonction d'un entier x
	* @param x un entier
	*/
	public void decreaseHp(int x) throws Exception{

	public boolean is_equal(Entity e){
		return (this.name == e.name);
	}

	public String to_string(){
		return "Nom de l'entité : " + this.name + ", points de vie " + this.hp;
	}

	/**
	 * Retourne l'entité sous forme de chaîne de caractères
	 * @return l'entité sous forme de chaîne de caractères
	 */
	public String toString(){
		return "Nom de l'entité : " + this.name + "\n points de vie " + this.hp + "\n espèce : " + this.species.get_name();
	}
}		
