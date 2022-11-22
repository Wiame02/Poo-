package Entity;

/**
 * Cette classe s'intitule Entity,
 * elle regroupe les differentes entites
 * present au sein de notre projet.
 * @author Nathan Doussin
 */
 
public class Entity{
	
	private String name;
	private int hp;

	public Entity(String name, int hp){
		this.name = name;
		this.hp = 0;
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

	public void setHp(int hp){
		return (this.hp != 0)
		}


	// ----------AFFICHAGE-------

	void print_name(String name){
		System.out.println("le nom de l'entité est : " + this.name + "\n");
	}

	void print_hp(int hp){
		System.out.println("le nombre de point(s) de vie de l'entité est : " + this.hp + "\n");
	}
	// ---------------------------------
	
	/**
	 * Cette methode permet de savoir 
	 * si une entite est vivante ou morte
	 * (par rapport a son nombre d'hp)
	 * @return true si l'entite est vivante
	 * @return false si l'entite est morte (hp = 0)
	 */
	
	public boolean isAlive(){
		if( hp > 0){
			return true;
		} else {
			return false;
		}
	}
}		
