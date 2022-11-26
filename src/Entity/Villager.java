package Entity;
import Quest.*;
import User.*;
import java.util.ArrayList;

/**
 * Cette classe s'intitule Villager,
 * elle regroupe les differentes villageois
 * que le joueur aura l'occasion de rencontrer 
 * via differentes quetes.
 * @author Nathan Doussin
 */
 
public class Villager extends Entity{
	private ArrayList<String> dialogues;
	private Quest quest;

	public Villager(String name, int hp, ArrayList<String> dialogues, Quest quest){
		super(name, hp);
		this.dialogues = new ArrayList<String>();
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
	public void add_dialogue(String dialogue){//TODO
	}

	//--------------AFFICHE------------

	void print_quest(Quest quest){
		System.out.println("le titre de la quête est : " + this.quest + "\n");
	}


	//----------------------------

	 public boolean is_equal(Player p){
    		return (this.quest == p.get_current_quest());
    	}

    	@override
    	/**
        * Marque une quete comme accomplie
        * @param p un joueur de type Player
        */
    	public abstract void submit(Player p){
    	    p.get_current_quest().is_finished();
    	}

	/**
	 * Cette methode sera utiliser lors d'une 
	 * rencontre avec un villageois.
	 * on saura alors la reponse du villageois
	 * en fonction de notre quete actuelle
	 * @param quest cette attribut correspond à la quete que la villageois nous donne lors de son interaction avec le personnage
	 * @param p cette attribut correspond a un joueur de type Player
	 */


	public void talk(Quest quest, Player p){ // quete  proposer par le villageois
		
		if(submit(p) == false){ // est-ce que notre quete actuelle est achevée ? faudrait pouvoir savoir si la current_quest de joueur est fini ou pas
			//non la quete n'est pas achevée
			if(is_equal(p)){ // est-ce que notre quete actuelle correspond à celle que la villageois nous donne ?
				
				System.out.println("Veuillez finir votre quete actuelle pour recevoir la recompense");
		
		} else { // notre quete actuelle est finie, is_finished == true
			//la quete actuelle est achevée
			if(is_equal(p)){ // est-ce que notre quete actuelle correspond à celle que la villageois nous donne ?
		        p.get_Inventory().add_item(quest.reward); // on reçoit la recompense et on la stock dans l'inventaire du joueur
		        p.get_lvl() += quest.bonus_exp // le joueur reçoit une bonus d'exp pour avoir achevée la quete
			    System.out.println("Bravo pour avoir accomplie cette quete, à notre prochaine rencontre");

			} else {

				p.get_current_quest() = quest // current_quete du joueur devient la quete du villageois
				System.out.println("le titre de la quete est : " + quest.title);
				System.out.println("l'intitulé de la quete est : "); // faudrait print l'intitulé de la quete mais je crois que ce n'est pas encore implementé
			}
		}

	}

}
