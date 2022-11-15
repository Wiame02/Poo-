Package Item
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 

public class Armor extends Item {
    private int defense_point ;

//--------------------constructeur ---------------------------
public Armor(String name , int durability , int defense_point){
  super (name , durability ) ;
  this.defense_point =defense_point;
} 

//---------------------methode--------------------------------
public int getdefense_point()    {return this.defense_point} 
}
