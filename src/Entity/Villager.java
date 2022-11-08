package Entity;

/*
 * Cette classe s'intitule Villager,
 * elle regroupe les differentes villageois
 * que le joueur aura l'occasion de rencontrer 
 * via differentes quetes
 */
 
public class Villager extends Entity{
	private Arrey<String> dialogues;
	private Quest quest;

	Monster(Arrey<String> dialogues, Quest quest){
		super(name, hp);
		this.dialogues = dialogues;
		this.quest = quest;
	}
	
	//--------------METHODES-------------
	
	/*
	 * GETTERS
	 */
	
	public String get_dialogues(){return this.dialogues;}
	public double get_quest(){return this.quest;}
	
	/*
	 * SETTERS
	 */
	
	public void set_dialogues(Array<String> dialogues){this.dialogues=dialogues;}
	public void set_quest(Quest quest){this.quest=quest;}
	
	
	public void Talk(){
		Quest quest_end;
		Quest quest_current
		
	}
	
}
