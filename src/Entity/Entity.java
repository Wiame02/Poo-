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
	
	public String getName(){return this.name;}

	public double getHp(){return this.hp;}
	
	/**
	 * SETTERS
	 */
	
	public void setName(String name){this.name=name;}
	public void setHp(int hp){this.hp=hp;}


	// ----------AFFICHAGE-------------

	/* Fonctions non utiles
	void print_name(){
		System.out.println("le nom de l'entité est : " + this.name + "\n");
	}

	void print_hp(){
		System.out.println("le nombre de point(s) de vie de l'entité est : " + this.hp + "\n");
	}
	*/
	// ---------------------------------------------------------
	
	/**
	 * Cette methode permet de savoir si une entite est vivante ou morte (par rapport a son nombre d'hp)
	 * @return true si l'entite est vivante
	 * @return false si l'entite est morte (hp = 0)
	 */
	public boolean is_alive(){
		return (this.hp > 0);
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public boolean is_equal(Entity e){
		return (this.name == e.name);
	}


	//TODO:Une fonction to_string() doit faire en sorte de retourner toutes les informations d'une entité donc name et hp
	public String to_string(){
		return this.name;
	}

}		
