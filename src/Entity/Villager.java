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

    		return (this.quest == p.get_current_quest());
    	}

	public String add_dialogue(){
		return this.dialogues;
	}
	
	/**
	 * Cette methode sera utiliser lors d'une rencontre avec un villageois.on saura alors la reponse du villageoisen fonction de notre quete actuelle
	 * @param quest cette attribut correspond à la quete que la villageois nous donne lors de son interaction avec le personnage
	 * @param p cette attribut correspond a un joueur de type Player
	 */

	public void talk(Quest quest, Player p) throws Exception{

		if(is_equal(p)){
			
			if(!quest.is_accomplished(p)){
				//System.out.println(this.dialogues.get(4));
			}
			else {
				p.get_Inventory().add_item(quest.get_reward());

		        p.set_lvl(p.get_lvl() + quest.get_bonus_exp());

				quest.is_accomplished(p);

				// quest du joueur devient null?

				//System.out.println("Bravo pour avoir accomplie cette quete, à notre prochaine rencontre");
				//System.out.println(this.dialogues.get(5));
			    

			}
		}
		else {

			if(!quest.is_accomplished(p)){
				//System.out.println("Vous possédé déjà une quete, veuillez la finir et revenez me voir");
				//System.out.println(this.dialogues.get(3));
			}
			else{

				// on demande si le joueur accepte la quete ?
				Scanner sc = new Scanner(System.in);
				System.out.println("Voulez vous accepter la quete : " + quest.get_title() + "(oui ou non)");
				String rep = sc.nextLine(); // lit la réponse de l'utilisateur
				System.out.println("Vous avez saisi : " + rep);

				
			
				if(rep == "oui"){

					//System.out.println(this.dialogues.get(1));

					p.set_current_quest(this.quest); // current_quete du joueur devient la quete du villageois

				}
				
				else {
					
					//System.out.println(this.dialogues.get(2));
				}
					
			} throw new Exception("Le joueur doit choisir d'accepter ou non la quete (ecrire oui ou non !)"); //exception si le joueur ne marque rien autre chose différent de oui ou non
			  

		}
		
	}

	
	 /**
	 * renvoie toutes les informations sur un villageois
	 */
    @Override
	public String to_string(){
		String res;
	    res = super.to_string() + ", quete proposée " + this.quest.get_title();
		return res;
	}
	
}
