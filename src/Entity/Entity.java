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
	public void setHp(int hp){
		if(hp>0){
			this.hp = hp;
		}else{
			this.hp = 0;
		}
	}

/*
 * Affichages
 */	
	/**
	 * Affiche le nom de l'entité
	 */
	void printName(){
		System.out.println("le nom de l'entité est : " + this.name + "\n");
	}

	/**
	 * Affiche les points de vies de l'entité
	 */
	void printHp(){
		System.out.println("le nombre de point(s) de vie de l'entité est : " + this.hp + "\n");
	}
	

	/**
	 * Retourne si une entite est vivante ou morte par son nombre de points de vie
	 * @return true si l'entite est vivante
	 * @return false si l'entite est morte (hp = 0)
	 */
	public boolean isAlive(){
		return (hp > 0);
	}

	/**
	* cette methode sert a diminuer
	* les points de vie en fonction d'un entier x
	* @param x un entier
	*/
	public void decreaseHp(int x) throws Exception{

        if((this.isAlive())){
            if(x >= 0){
                if(this.hp <= x){
                    this.hp = 0;
                } else {
                    this.hp -= x;
                }
            } throw new Exception("La valeur de retrait de points de vie ne peut pas être négative");

        } throw new Exception("L'entité est déjà morte");

	}

	/**
	 * Test si deux entitées sont égales par leurs noms et espèces
	 * @param e l'entité à comparée
	 * @return 	true si égaux 
	 * 			false sinon
	 */
	public boolean isEqual(Entity e){
		return (this.name == e.name && this.species==e.species );
	}

	/**
	 * Retourne l'entité sous forme de chaîne de caractères
	 * @return l'entité sous forme de chaîne de caractères
	 */
	public String toString(){
		return "Nom de l'entité : " + this.name + "\n points de vie " + this.hp + "\n espèce : " + this.species.get_name();
	}
}		
