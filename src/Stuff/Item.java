package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 


public class Item {
    private String name;    
    private int quantity;


    /**
     * Constructeur de Item
     */
    public Item (String name) {
        this.name = name;
        this.quantity = 1;
    }  

    /**
     * GETTERS
     */

    public String get_name()  {return this.name;}
    public int get_quantity() {return this.quantity;}

     /**
     * SETTERS
     */
    public void set_name (String name) {this.name = name;} 
    public void set_quantity (int quantity) {this.quantity = 1;}

    

    /**
     * affichage de l'item
     */
    public String to_string(){
        return this.name;
    }

    /**
     * verification si un item est egale à cette item la 
     * @param i
     */
    public boolean is_equal(Item i){
        return (i.get_name()==this.name);
    }

    /**
     * vérifie la diminution la quantité d'un  Item de 1
     * @param i
     */
    public int use (Item i) { 
        return (i.get_quantity()-= 1);
    }
}
 
 






    