package Stuff;
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

 private void use_damage (int nb_damage) {this.durability -= nb_damage;}  
 public void use_damage_n (int nb_damage) {this.use_damage (1) ;} 



}
 
 






    