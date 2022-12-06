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

    /**
     * Constructeur
     * @param name
     * @param hp
    */
	public Entity(String name, int hp){
		this.name = name;
		this.hp = hp;
	}
	
	// --------------METHODES---------------
	
	/**
	 * GETTERS
	 */
	
	public String getName(){return this.name;}

	public double getHp(){return this.hp;}
	
	/**
	 * SETTERS
	 */
	
	public void setName(String name){this.name=name;}
	public void setHp(int hp){this.hp=hp;}

	// ---------------------------------------------------------
	
	/**
	 * Cette methode permet de savoir si une entite est vivante ou morte (par rapport a son nombre de points de vie)
	 * @return true si l'entite est vivante
	 * @return false si l'entite est morte (hp = 0)
	 */
	public boolean isAlive(){
		return (hp > 0);
	}


	public boolean isEqual(Entity e){
		return (this.name == e.name);
	}

	public String toString(){
		return "Nom de l'entité : " + this.name + ", points de vie " + this.hp;
	}

}		
