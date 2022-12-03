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


    /**
     * Constructeur
     * @param name
     * @param hp
     * @param species
     * @param attack
    */
	public Monster(String name, int hp, Species species, int attack){
		super(name, hp);
		this.species = species;
		this.attack = attack;
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


    public void print_attack(){

        System.out.println(this.name + " à infligé " + this.attack + "de dégats");
    }

	/**
	* cette methode sert a diminuer
	* les points de vie en fonction d'un entier x
	* @param x un entier
	*/
	public void decrease_hp(int x) throws Exception{

        if((this.is_alive())){  // le monstre est-il deja mort ?
            if(x >= 0){
                if(this.hp <= x){
                    this.hp = 0;
                } else {
                    this.hp -= x;
                }
            } throw new Exception("La valeur de retrait de points de vie ne peut pas être négative");

        } throw new Exception("Le monstre est déjà mort");

	}

	/**
	 * Cette methode permet de savoir 
	 * si un monstre correspond au boss de ce monde ou non
	 * @see Localization.World#getBoss() afin de recuperer le boss du monde en question
	 * @param world de type World
	 * @return true si c'est le boss de ce monde
	 * @return false si ce n'est pas le boss de ce monde
	 */
	public boolean is_boss(World world){
		return (this == world.getBoss());
	}


	void attack(Player p) throws Exception{

    	try{
            p.decrease_hp(this.attack);
        }
        catch(Exception e){
            System.out.println(p.getUsername()+" a esquivé l'attaque");
        }
    }

	/**
	 * renvoie toutes les informations sur un monstre
	 */
    @Override
	public String to_string(){

	    return "Nom du monstre : " + this.name + ", points de vie " + this.hp + ", nom d'espèce " + this.species.get_name() + ", dégats de son attaque " + this.attack;
	}
}
