package Entity;
import Quest.*;
import User.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cette classe s'intitule Villager,
 * elle regroupe les differentes villageois
 * que le joueur aura l'occasion de rencontrer 
 * via differentes quetes.
 * @author Nathan Doussin
 * @author Katel HIGNARD //Correction : relecture et formatage
 */
 
public class Villager extends Entity{
	private Quest quest;
	private ArrayList<String> dialogues;

    /**
     * Constructeur
     * @param name le nom du villageois
     * @param hp les points de vies du villageois
     */
	public Villager(String name, int hp){
		super(name,hp,Species.VILLAGER);
        this.quest = null;
		this.dialogues = new ArrayList<String>();
	}
	
/*
 * GETTERS
 */
	public Quest getQuest() {return this.quest;}
	public String getDialogueAt(int i) {return this.dialogues.get(i);}
	public ArrayList<String> getDialogues() {return this.dialogues;}
	
/*
 * SETTERS
 */
	public void setQuest(Quest quest) {this.quest = quest;}
	public void addDialogue(String dialogue){
		this.dialogues.add(dialogue);
	}
	
	/**
	 * Cette methode sera utiliser lors d'une rencontre avec un villageois.on saura alors la reponse du villageoisen fonction de notre quete actuelle
	 * @param quest cette attribut correspond à la quete que la villageois nous donne lors de son interaction avec le personnage
	 * @param p cette attribut correspond a un joueur de type Player
	 */

	public void talk(Quest quest, Player p){
		// FIXME
		if(this.quest==p.getCurrentQuest()){	// Les deux quêtes seront égales si les deux références la même quête
			if(!quest.isAccomplished(p)){
				//System.out.println(this.dialogues.get(4));
			}
			else {
				p.getInventory().addItem(quest.getReward());

		        p.setLvl(p.getLvl() + quest.getBonusExp());

				quest.isAccomplished(p);

				// quest du joueur devient null?

				//System.out.println("Bravo pour avoir accomplie cette quete, à notre prochaine rencontre");
				//System.out.println(this.dialogues.get(5));
			    

			}
		}
		else {

			if(!quest.isAccomplished(p)){
				//System.out.println("Vous possédé déjà une quete, veuillez la finir et revenez me voir");
				//System.out.println(this.dialogues.get(3));
			}
			else{

				// on demande si le joueur accepte la quete ?
				Scanner sc = new Scanner(System.in);
				System.out.println("Voulez vous accepter la quete : " + quest.getTitle() + "(oui ou non)");
				String rep = sc.nextLine(); // lit la réponse de l'utilisateur
				System.out.println("Vous avez saisi : " + rep);

				if(rep == "oui"){

					//System.out.println(this.dialogues.get(1));

					p.setCurrentQuest(this.quest); // current_quete du joueur devient la quete du villageois

					p.setCurrentQuest(quest); // current_quete du joueur devient la quete du villageois

					p.setCurrentQuest(quest); // current_quete du joueur devient la quete du villageois

					System.out.println(this.dialogues.get(0) + quest.getTitle());

				}
				
				else {
					
					//System.out.println(this.dialogues.get(2));
				}
				sc.close();
			}
		}
	}

	
	/**
	* renvoie toutes les informations sur un villageois
	*/
    @Override
	public String toString(){
		return super.toString() + "\n quete :" + this.quest.getTitle();
	}
	
}
