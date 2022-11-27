package Entity;
import Localization.*;
import User.*;

/**
 * Cette sous-classe s'intitule Monster,
 * elle regroupe les differents especes de monstres
 * presentes au sein de notre projet.
 * @author Nathan Doussin
 */


public class Monster extends Entity{
	private Species species;
	private int attack;

	public Monster(String name, int hp, Species species, int attack){
		super(name, hp);
		this.species = species;
		this.attack = 0;
	}
	
	//--------------METHODES-------------
	
	/**
	 * GETTERS
	 */
	
	public Species get_species(){return this.species;}
	public int get_attack(){return this.attack;}
	
	/**
	 * SETTERS
	 */
	
	public void set_species(Species species){this.species=species;}
	public void set_attack(int attack){
		if(attack <= 0){
			 this.attack = 0;
		} else {
			this.attack = attack;
		}
	}

	//----------------------AFFICHAGE-----------------

	/* TODO : fonctions inutiles
	void print_name(Species species){
		System.out.println("l'espèce de l'entité est : " + this.species + "\n");
	}

	void print_name(int attack){
		System.out.println("son attaque inflige : " + this.attack + "\n");
	}
	*/

	//--------------------------------------------------

	/**
	* cette methode sert a diminuer
	* les points de vie en fonction d'un entier n
	* @param x un entier
	*/
	public void decrease_hp(int x) throws Exception{
		/*TODO : corriger les erreurs (voir discord)
        if((is_alive) == true){  // le monstre est-il deja mort ?
            if(x >= 0){
                if(hp <= this.x){
                    hp = 0;
                } else {
                    hp = hp - this.x;
                }
            } throw new Exception("La valeur de décroissement ne peut pas être négative");

        } throw new Exception("Le monstre est déjà mort");
		*/
	}

	/**
	 * Cette methode permet de savoir 
	 * si un monstre correspond au boss de ce monde ou non
	 * @see Localization.World#get_boss() afin de recuperer le boss du monde en question
	 * @param world de type World
	 * @return true si c'est le boss de ce monde
	 * @return false si ce n'est pas le boss de ce monde
	 */
	public boolean is_boss(World world){
		return (this == world.get_boss());
	}

	/**
	*Cette methode permet de savoir
    * si une entite est un boss ou non
    * @param world le monde ou se trouve le monstre
	*/
	/*TODO : fonction inutile -> passage dans Game.java. A RETIRER
	public void interact(World world){

		if(isBoss(world)){
			System.out.println("Ce monstre semble avoir une aura particuliere demoniaque  \n");
			System.out.println("Ce monstre est le BOSS de ce monde ! \n");
		}
		/*
		while(Player.hp != 0 || Monster.hp != 0){
			Combat
		}
	}
	*/


	void attack(Player p){
		try{
		p.decrease_hp (this.attack);
		}
		catch(Exception e){
			System.out.println(p.get_username()+" a esquivé l'attaque ");
		}
	}

	//TODO : Override de to_string() qui renvoie toutes les informations sur un monstre
}