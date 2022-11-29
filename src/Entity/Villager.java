package Entity;
import Quest.*;
import User.*;
import java.util.ArrayList;
import java.util.Scanner;

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


    /**
     * Constructeur
     * @param name
     * @param hp
     */
	public Villager(String name, int hp){
		super(name,hp);
		this.dialogues = new ArrayList<String>();
		dialogues.add("L'énoncé de la quête que vous venez d'accepter est : ");
		dialogues.add("Merci voyageur d'avoir accepté ma demande");
		dialogues.add("Diantre, vous ne savez pas ce que vous loupez, à la revoyure");
		dialogues.add("Vous possédé déjà une quete, veuillez la finir et revenez me voir");
		dialogues.add("Je vois que vous n'avez pas terminez ma demande, dépêché vous de la finir afin de recevoir une grosse récompense");
		dialogues.add("Bravo pour avoir accomplie cette quete, voici votre récompense à notre prochaine rencontre");
        this.quest = null;
	}
	
	//--------------METHODES-------------
	
	/**
	 * GETTERS
	 */
	
	public String get_dialogues_at(int i) {return this.dialogues.get(i);}
	public ArrayList<String> get_dialogues(){return this.dialogues;}
	public Quest get_quest() {return this.quest;}
	
	/**
	 * SETTERS
	 */

	public void set_quest(Quest quest) {this.quest=quest;}

	//----------------------------

	 public boolean is_equal(Player p){

    		return (this.quest == p.get_current_quest());
    	}

	
	/**
	 * Cette methode sera utiliser lors d'une rencontre avec un villageois.on saura alors la reponse du villageoisen fonction de notre quete actuelle
	 * @param quest cette attribut correspond à la quete que la villageois nous donne lors de son interaction avec le personnage
	 * @param p cette attribut correspond a un joueur de type Player
	 */

	
	//public void talk(Quest quest, Player p){ // quete  proposer par le villageois
			/* 
	 	 // Redéfinir la foncition, elle fait un peu trop de chose (a voir avec mo et kateul)
		if(!quest.is_accomplished(p)){ // est-ce que notre quete actuelle est achevée ? faudrait pouvoir savoir si la current_quest de joueur est fini ou pas

			if(is_equal(p)){ // est-ce que notre quete actuelle correspond à celle que la villageois nous donne ?
				
				System.out.println("Veuillez finir votre quete actuelle pour recevoir la recompense");
			}else {

				p.get_current_quest() = quest; // current_quete du joueur devient la quete du villageois

				System.out.println("le titre de la quete est : " + quest.get_title());

				System.out.println("l'intitulé de la quete est : "); // faudrait print l'intitulé de la quete mais je crois que ce n'est pas encore implementé
			}

		} else { // notre quete actuelle est finie, is_finished == true

				if(is_equal(p)){ // est-ce que notre quete actuelle correspond à celle que la villageois nous donne ?

		       		p.get_Inventory().addItem(quest.get_reward());

		        	p.set_lvl(p.get_lvl() + quest.get_bonus_exp()) ;

			    	System.out.println("Bravo pour avoir accomplie cette quete, à notre prochaine rencontre");

				} else {

					p.get_current_quest() = quest; // current_quete du joueur devient la quete du villageois

					System.out.println("le titre de la quete est : " + quest.get_title());

					System.out.println("l'intitulé de la quete est : "); // faudrait print l'intitulé de la quete mais je crois que ce n'est pas encore implementé
				}
			}
		}
	
	} */

	public void talk(Quest quest, Player p) throws Exception{

		if(is_equal(p)){
			
			if(!quest.is_accomplished(p)){
				System.out.println(this.dialogues.get(4));
			}
			else {
				p.get_Inventory().addItem(quest.get_reward());

		        p.set_lvl(p.get_lvl() + quest.get_bonus_exp());

				quest.is_accomplished(p);

				// quest du joueur devient null?

				//System.out.println("Bravo pour avoir accomplie cette quete, à notre prochaine rencontre");
				System.out.println(this.dialogues.get(5));
			    

			}
		}
		else {

			if(!quest.is_accomplished(p)){
				//System.out.println("Vous possédé déjà une quete, veuillez la finir et revenez me voir");
				System.out.println(this.dialogues.get(3));
			}
			else{

				// on demande si le joueur accepte la quete ?
				Scanner sc = new Scanner(System.in);
				System.out.println("Voulez vous accepter la quete : " + quest.get_title() + "(oui ou non)");
				String rep = sc.nextLine(); // lit la réponse de l'utilisateur
				System.out.println("Vous avez saisi : " + rep);

				
			
				if(rep == "oui"){

					System.out.println(this.dialogues.get(1));

					p.set_current_quest(quest); // current_quete du joueur devient la quete du villageois

					System.out.println(this.dialogues.get(0) + quest.get_title());

				}
				else {
					System.out.println(this.dialogues.get(2));
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
