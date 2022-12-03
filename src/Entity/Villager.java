package Entity;
import Quest.*;
import User.*;
import java.util.Scanner;

/**
 * Cette classe s'intitule Villager,
 * elle regroupe les differentes villageois
 * que le joueur aura l'occasion de rencontrer 
 * via differentes quetes.
 * @author Nathan Doussin
 */
 
public class Villager extends Entity{
	private Quest quest;
	private String dialogues;

    /**
     * Constructeur
     * @param name
     * @param hp
     */
	public Villager(String name, int hp){
		super(name,hp);
        this.quest = null;
	}
	
	//--------------METHODES-------------
	
	/**
	 * GETTERS
	 */
	
	public Quest get_quest() {return this.quest;}
	public String get_dialogues() {return this.dialogues;}
	
	/**
	 * SETTERS
	 */

	public void set_quest(Quest quest) {this.quest = quest;}
	//----------------------------

	 public boolean is_equal(Player p){

    		return (this.quest == p.getCurrentQuest());
    	}

	public String add_dialogue(){
		return this.dialogues;
	}
	
	/**
	 * Cette methode sera utiliser lors d'une rencontre avec un villageois.on saura alors la reponse du villageoisen fonction de notre quete actuelle
	 * @param quest cette attribut correspond à la quete que la villageois nous donne lors de son interaction avec le personnage
	 * @param p cette attribut correspond a un joueur de type Player
	 */

<<<<<<< HEAD
=======
	
	//public void talk(Quest quest, Player p){ // quete  proposer par le villageois
			/* 
	 	 // Redéfinir la foncition, elle fait un peu trop de chose (a voir avec mo et kateul)
		if(!quest.isAccomplished(p)){ // est-ce que notre quete actuelle est achevée ? faudrait pouvoir savoir si la current_quest de joueur est fini ou pas

			if(is_equal(p)){ // est-ce que notre quete actuelle correspond à celle que la villageois nous donne ?
				
				System.out.println("Veuillez finir votre quete actuelle pour recevoir la recompense");
			}else {

				p.get_current_quest() = quest; // current_quete du joueur devient la quete du villageois

				System.out.println("le titre de la quete est : " + quest.getTitle());

				System.out.println("l'intitulé de la quete est : "); // faudrait print l'intitulé de la quete mais je crois que ce n'est pas encore implementé
			}

		} else { // notre quete actuelle est finie, is_finished == true

				if(is_equal(p)){ // est-ce que notre quete actuelle correspond à celle que la villageois nous donne ?

		       		p.get_Inventory().addItem(quest.getReward());

		        	p.set_lvl(p.getLvl() + quest.getBonusExp()) ;

			    	System.out.println("Bravo pour avoir accomplie cette quete, à notre prochaine rencontre");

				} else {

					p.get_current_quest() = quest; // current_quete du joueur devient la quete du villageois

					System.out.println("le titre de la quete est : " + quest.getTitle());

					System.out.println("l'intitulé de la quete est : "); // faudrait print l'intitulé de la quete mais je crois que ce n'est pas encore implementé
				}
			}
		}
	
	} */

>>>>>>> aa87df0e5cbedb064e5d2dc408d109f27f113323
	public void talk(Quest quest, Player p) throws Exception{

		if(is_equal(p)){
			
<<<<<<< HEAD
			if(!quest.is_accomplished(p)){
				//System.out.println(this.dialogues.get(4));
=======
			if(!quest.isAccomplished(p)){
				System.out.println(this.dialogues.get(4));
>>>>>>> aa87df0e5cbedb064e5d2dc408d109f27f113323
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

<<<<<<< HEAD
<<<<<<< HEAD
					p.set_current_quest(this.quest); // current_quete du joueur devient la quete du villageois
=======
					p.set_current_quest(quest); // current_quete du joueur devient la quete du villageois
=======
					p.setCurrentQuest(quest); // current_quete du joueur devient la quete du villageois
>>>>>>> 7b3e6d9269743d7840f52be34e4dc969f61df254

					System.out.println(this.dialogues.get(0) + quest.getTitle());
>>>>>>> aa87df0e5cbedb064e5d2dc408d109f27f113323

				}
				
				else {
					
					//System.out.println(this.dialogues.get(2));
				}
				sc.close();
			} throw new Exception("Le joueur doit choisir d'accepter ou non la quete (ecrire oui ou non !)"); //exception si le joueur ne marque rien autre chose différent de oui ou non
			  

		}
		
	}

	
	 /**
	 * renvoie toutes les informations sur un villageois
	 */
    @Override
	public String to_string(){
		String res;
	    res = super.to_string() + ", quete proposée " + this.quest.getTitle();
		return res;
	}
	
}
