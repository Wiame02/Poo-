package Entity;

/*
 * Cette classe s'intitule Entity,
 * elle regroupe les differentes entites
 * present au sein de notre projet
 */
 
public class Entity{
	
	private String name;
	private int hp;

	Entity(String name, int hp){
		this.name = name;
		this.hp = 0;
	}
	
	// --------------METHODES---------------
	
	/*
	 * GETTERS
	 */
	
	public String getName(){return this.name;}
	public double getHp(){return this.hp;}
	
	/*
	 * SETTERS
	 */
	
	public void setName(String name){this.name=name;}
	public void setHp(int hp){
		if(hp <= 0){
			 this.hp = 0;
		} else {
			this.hp = hp;
		}
	}
	
	public boolean isAlive(){
		if( hp >= 0){
			return true;
		} else {
			return false;
		}
	}
}		
