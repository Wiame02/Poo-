Package Item
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 


public class Item {
    private String name;
    private int durability;
    


 // constructeur
public Item (String name , int durability) {
    this.name = name;
    this.durability = durability;
}  

// methode 

 void use_damage () {return(this.durability -= 1);}  
 abstract void use_damage_n () {return(this.durability -= n );} 



}
 
 






    