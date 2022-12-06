package Stuff;

/**
 * La classe Armor représente les armures utilisées par le joueur 
 * @author Wiame TAII
 * @author Monique RIMBERT //Correction : relecture et formatage
 */
public class Armor extends Item {
    private int defensePoint;
    private Type type;
    private int durability;

    /**
     * Contructeur d'une armure
     * @param name Le nom de l'armure
     * @param durability La durabilité entre [0, n]
     * @param defensePoint Les points de défense entre [0,100] correpond à un pourcentage
     * @param type Type de l'armure 
     * @see Stuff.Type
     */
    public Armor(String name, int durability, int defensePoint, Type type) {
        super(name);
        this.durability = (durability<0)?0:durability;
        this.defensePoint = (defensePoint<0)?0:defensePoint;
        this.type = type;
    }

    /**
     * @return La durabilité de l'armure
     */
    public int getDurability() {
        return this.durability;
    }

    /**
     * @return Le type de l'armure
     * @see Stuff.Type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * @return Les points de défense entre [0,100]
     */
    public int getDefensePoint() {
        return this.defensePoint;
    }
    
    /**
     * Fixe les points de défense au nombre donné
     * @param defensePoint Un pourcentage entre 0 et 100
     */
    public void setDefensePoint(int defensePoint) {
        this.defensePoint = (defensePoint<0)?0:(defensePoint>100)?100:defensePoint;
    }

    /**
     * Fixe la durabilité au nombre donné
     * @param defensePoint Doit être positive
     */
    public void setDurability(int durability) {
        this.durability = (durability<0)?0:durability;
    }

    /**
     * @return Formatage de de la classe Armor
     */
    @Override
    public String toString() {
        return super.toString() + "(" + this.defensePoint + ", " + this.type + ", " + this.durability + ")";
    }

}
