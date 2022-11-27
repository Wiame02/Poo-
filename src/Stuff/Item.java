package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 


public class Item {
    private String name;    


    /**
     * Constructeur de Board
     */
    public Item (String name) {
        this.name = name;
    }  

    /**
     * GETTERS
     */

    public String get_name()  {return this.name;} 

     /**
     * SETTERS
     */
    public void set_name (String name) {this.name = name;} 

    

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
}
 
 






    