package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 


public class Item {
    private String name;
    private int durability;
    


    /**
     * Constructeur de Board
     */
    public Item (String name , int durability) {
        this.name = name;
        this.durability = durability;
    }  

    /**
     * GETTERS
     */

    public String get_name()  {return this.name;} 
    public  int get_durability()  {return this.durability;}  

     /**
     * SETTERS
     */
    public void set_name (String name) {this.name = name;} 
    public void set_durability (int durability ) {this.durability = durability;} 


    
    /**
     * diminution de la durabilite
     * @param nb_damage
     */
    public void use_damage (int nb_damage) {this.durability -= nb_damage;}  

    /**
     * diminution de la durabilite de 1
     * @param w
     */
    public void use_damage_n (int nb_damage) {this.use_damage (1) ;} 

    /**
     * affichage de l'item
     */
    public String to_string(){
        return this.name+ "("+this.durability+")";
    }

    /**
     * verification si un item est egale à cette item la 
     * @param i
     */
    public boolean is_equal(Item i){
        return (i.get_name()==this.name);
    }
}
 
 






    