package Stuff;

/**
 * La classe Item représente les objets utilisées par le joueur 
 * @author Wiame TAII
 * @author Monique RIMBERT //Correction : relecture et formatage
 */
public class Item {
    private String name;
    private int quantity;

    /**
     * Constructeur de la classe Item
     * @param name Le nom de l'item en question
     */
    public Item(String name) {
        this.name = name;
        this.quantity = 1;
    }

    /**
     * @return Le nom de l'item
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return La quantité de l'Item
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Fixe le nom de l'Item au nom donné
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Fixe la quantité de l'Item au nombre donné
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Formattage de la classe Item
     */
    @Override
    public String toString() {
        return "Nom : " + this.name + "\nQuantité : " + String.valueOf(this.quantity);
    }

    /**
     * Verification si d'un objet par rapport au nom
     * @param i
     * @return true Si les items portent le même nom
     */
    public boolean isEqual(Item i) {
        return (this.name.equals(i.getName()));
    }

    /**
     * Diminue la quantité de 1
     */
    public void use() {
        this.quantity -= (this.quantity>0)?1:0;
    }
}
