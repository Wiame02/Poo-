package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 

public class Armor extends Item {
    private int defense_point ;
    //TODO : ajouter le type de l'armure + dans le constructeur

//--------------------constructeur ---------------------------
public Armor(String name , int durability , int defense_point){
  super (name , durability ) ;
  this.defense_point =defense_point;
} 
/**
     * SETTERS
     */
     public void set_defense_point(int defense_point) {this.defense_point = defense_point;} 
    


//---------------------methode--------------------------------
public int getdefense_point()    {return this.defense_point;} 
@Override  
public void use_damage_n (int nb_damage) {this.use_damage (nb_damage) ;} 

//TODO :Overrive de la fonction d'affichage 
}
