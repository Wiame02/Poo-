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
	

/*	public void talk_v1(Player p){
		if(this.quest==null) {return;}
		if(this.quest==p.getCurrentQuest()){	// Les deux quêtes seront égales si les deux références la même quête

			if(quest.isAccomplished(p)){ // La quête du villageois a été accomplie par le joueur
				System.out.println(this.name+": "+this.dialogues.get(4));
				
				System.out.println("Vous avez obtenu : "+this.quest.getReward().getName()+"\n");
				p.getInventory().addItem(this.quest.getReward());

				System.out.println("Et : +"+this.quest.getBonusExp()+" lvl");
				p.setLvl(p.getLvl() + this.quest.getBonusExp());
			}
			else { // La quête du villageois est en cours de réalisation
				System.out.println(this.name+": "+this.dialogues.get(3));
			}
		}else {
			if(this.quest.isAccomplished(p)){  // La quête du villageaois a déjà été réalisée dans le passé
			}
			else{ // La quête n'est pas en cours et n'a pas été faite
			}
		}
	}*/

	/**
	 * Dialogue du villageois selon l'avancement de sa quête
	 * @param p joueur qui intéragit avec le villageois
	 */

	public void talk(Player p){

		if( !this.quest.isAccepted() && !this.quest.isFinished()){
			// La quête n'est ni acceptée, ni rendue
			
			System.out.print("\n");
			System.out.println(this.name+": "+this.dialogues.get(0));
			System.out.print("\n");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Voulez vous accepter la quete : " + quest.getTitle() + "\n decline() pour refuser \n accept() pour accepter \n >> ");
			String rep = sc.nextLine();
			while(!rep.equals("accept();") && !rep.equals("decline();")){ // Vérification de la réponse du joueur 
				System.out.print("\n");
				System.out.println("Mauvaise commande, veuillez réessayer.");
				System.out.print("Voulez vous accepter la quete : " + quest.getTitle() + "\n decline() pour refuser \n accept() pour accepter \n >> ");
				rep = sc.nextLine();
			}
			System.out.print("\n");
			if(rep.equals("accept();")){ // La joueur accepte la quête
				p.setCurrentQuest(this.quest);
				System.out.print("\n");
				System.out.println(this.name+": "+this.dialogues.get(1));
				System.out.print("\n");
			}
			else{ // Le joueur refuse la quête
				System.out.print("\n");
				System.out.println(this.name+": "+this.dialogues.get(2));	
				System.out.print("\n");
			}
			this.quest.acceptQuest() ;
		}else if(this.quest.isAccepted() && !this.quest.isFinished() ){
			if(this.quest.isAccomplished(p)){
				System.out.print("\n");
				System.out.println(this.name+": "+this.dialogues.get(4));
				System.out.print("\n");
				System.out.println("Vous avez obtenu : "+this.quest.getReward().getName()+"\n");
				p.getInventory().addItem(this.quest.getReward());

				System.out.println("Et : +"+this.quest.getBonusExp()+" lvl");
				p.setLvl(p.getLvl() + this.quest.getBonusExp());

				this.quest.finishQuest();
			}else{
				// La quête a été acceptée, mais est ni complétée ni rendue (quête en cours)

				System.out.print("\n");
				System.out.println(this.name+": "+this.dialogues.get(3));
				System.out.print("\n");
			}
		}else if( this.quest.isAccepted() && this.quest.isFinished() && this.quest.isAccomplished(p)){  
			// La quête a été acceptée, complétée et rendue
			
			System.out.print("\n");
			System.out.println(this.name+": "+this.dialogues.get(5));
			System.out.print("\n");

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
