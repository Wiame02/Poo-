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
	private int attack;

    /**
     * Constructeur
     * @param name
     * @param hp
     * @param species
     * @param attack
    */
	public Monster(String name, int hp, Species species, int attack){
		super(name,hp,species);
		this.setAttack(attack);
	}

	
	/*
	 * GETTERS
	 */

	public int get_attack(){return this.attack;}
	
	/*
	 * SETTERS
	 */
	public void setAttack(int attack){
		if(attack <= 0){
			 this.attack = 0;
		} else {
			this.attack = attack;
		}
	}

	/**
	 * Affichage des points d'attaques
	 */
    public void printAttack(){
        System.out.println(this.name + " à infligé " + this.attack + "de dégats");
    }

	/**
	 * Cette methode permet de savoir 
	 * si un monstre correspond au boss de ce monde ou non
	 * @see Localization.World#getBoss() afin de recuperer le boss du monde en question
	 * @param world de type World
	 * @return true si c'est le boss de ce monde
	 * @return false si ce n'est pas le boss de ce monde
	 */
	public boolean isBoss(World world){
		return (this == world.getBoss());
	}

	/**
	 * Le monstre attaque un joueur et lui fait perdre des points de vies
	 * @param p le joueur attaqué
	 */
	public void attack(Player p){
    	try{
            p.decreaseHpWithArmor(this.attack,this);
        }
        catch(Exception e){
            System.out.println(p.getUsername()+" a esquivé l'attaque");
        }
    }

	/**
	 * renvoie toutes les informations sur un monstre
	 */
    @Override
	public String toString(){
	    return super.toString() + "\n Nom du monstre : " + this.name + "\n dégats d'attaque " + this.attack;
	}
}
