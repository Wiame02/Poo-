package Entity;
import java.util.ArrayList;

/**
 * Cette classe s'intitule Villager,
 * elle regroupe les differentes villageois
 * que le joueur aura l'occasion de rencontrer 
 * via differentes quetes.
 * @author Nathan Doussin
 */
 
public class Villager extends Entity{
	private Arrey<String> dialogues;
	private Quest quest;

	public Villager(Arrey<String> dialogues, Quest quest){
		super(name, hp);
		this.dialogues = new arrayList<String>();
		this.quest = quest;
	}
	
	//--------------METHODES-------------
	
	/**
	 * GETTERS
	 */
	
	public String get_dialogues_at(int i) {return this.dialogues.get(i);}
	public Quest get_quest() {return this.quest;}
	
	/**
	 * SETTERS
	 */

	public void set_quest(Quest quest) {this.quest=quest;}
	

	//--------------AFFICHE------------

	void print_name(Quest quest){
		System.out.println("le nom de l'entité est : " + this.quest + "\n");
	}






	//----------------------------

	/**
	 * Cette methode sera utiliser lors d'une 
	 * rencontre avec un villageois.
	 * on saura alors la reponse du villageois
	 * en fonction de notre actuelle
	 * @param quest cette atribut correspond a quete que la villageois nous donne lors de son interaction avec le personnage
	 */

	/*public void talk_villager(Quest quest){
		
		Quest quest_current_end;
		boolean b = false;
		
		if(quest_current_end == b){ // est-ce que notre quete actuelle est finie ?
			
			if(quest_current_end == quest){ // est-ce que notre quete actuelle coorespond a celle que la villageois nous donne ? 
				
				System.out.println("Veuillez finir votre quete actuelle");
			
			} else {
				
				// on appelle la quete du villageois
			}	
		
		} else { // notre quete actuelle est finie
			
			if(quest_current_end == quest){ // est-ce que notre quete actuelle coorespond a celle que la villageois nous donne ? 
				
				// rendre la quete au villageois et récuperer les recompenses
			
			} else {
				
				System.out.println("");
			}
		}
		
	}
	*/
	
	
}
