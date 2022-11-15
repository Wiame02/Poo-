Package Item
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 

public class Weapons extends Item {
    int attack_point

//--------------------constructeur ---------------------------
public Item (String name , int durability){
  super (name , durability ) ;
  this.attack_point = attack_point;
} 

//---------------------methode--------------------------------
pulic int getattack_point()    {return this.attack_point} 
}
