package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 

public class Weapon extends Item {
    private int attack_point ;

//--------------------constructeur ---------------------------
public Weapon(String name , int durability , int attack_point){
  super (name , durability ) ;
  this.attack_point = attack_point;
} 

//---------------------methode--------------------------------
public int getattack_point()    {return this.attack_point} 
@Override  
public void use_damage_n (int nb_damage) {this.use_damage (nb_damage) ;} 
}
 
 






    