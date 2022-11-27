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

	public Entity(String name, int hp){
		this.name = name;
		this.hp = hp;
	}
	
	// --------------METHODES---------------
	
	/**
	 * GETTERS
	 */
	
	public String get_name(){return this.name;}

	public double get_hp(){return this.hp;}
	
	/**
	 * SETTERS
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
	 * Cette methode permet de savoir si une entite est vivante ou morte (par rapport a son nombre d'hp)
	 * @return true si l'entite est vivante
	 * @return false si l'entite est morte (hp = 0)
	 */
	public boolean isAlive(){
		return (hp > 0);
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public boolean is_equal(Entity e){
		return (this.name == e.name);
	}

	public String to_string(){
		return this.name;
	}

}		
