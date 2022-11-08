public class Entity{
	
	private String name;
	private int hp;

	Entity(String name, int hp){
		this.name = name;
		this.hp = 0;
	}
	
	// --------------Getter---------------
	
	public String getName(){return this.name;}
	public double getHp(){return this.hp;}
	
	// --------------Setter---------------
	
	public void setName(String name){this.name=name;}
	public void setHp(int hp){
		if(hp <= 0){
			 this.hp = 0;
		} else {
			this.hp = hp;
		}
	}
	
	//----------Methode--------------
	
	public boolean isAlive(){
		if( hp >= 0){
			return true;
		} else {
			return false;
		}
	}
}		
