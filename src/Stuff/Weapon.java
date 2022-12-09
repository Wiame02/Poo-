package Stuff;
/**
 * La classe Weapon représente les armure utilisées par le joueur pour combattre
 * @author Wiame TAII
 * @author Monique RIMBERT //Correction : relecture et formatage
 */

public class Weapon extends Item {
    private int attackPoints;
    private int durability;
    
    /**
    * Contructeur de la classe Weapon
    * @param name Le nom de l'item
    * @param durability La durabilité entre [0,n]
    * @param attackPoints Les points d'attaque entre [0,n]
    */
    public Weapon(String name, int durability, int attackPoints){
        super(name);
        this.attackPoints = (attackPoints<0)?0:attackPoints;
        this.durability = (durability<0)?0:durability;
    } 

    /**
     * @return Retourne les points d'attaque de l'arme
     */
    public int getAttackPoints() {
        return this.attackPoints;
    } 

    /**
     * @return Retourne la durabilité de l'arme
     */
    public int getDurability() {
        return this.durability;
    }

    /**
     * Fixe la durabilité de l'arme
     * @param durability
     */
    public void setDurability(int durability){
        this.durability = (durability<0)?0:durability;
    }

    /**
     * Diminue la durabilité en fontion du nombre de dégat reçu
     * @param nbDamage
     */
    public void looseDurability(int nbDamage) {
        this.durability -= nbDamage;
    }    

    /**
     * @return Formattage de la classe Weapon
     */
    @Override
    public String toString(){
        return super.toString() + "\nPoints d'attaque : " + String.valueOf(this.attackPoints) + "\nDurabilité : " + String.valueOf(this.durability);
    }

}
 
 






        