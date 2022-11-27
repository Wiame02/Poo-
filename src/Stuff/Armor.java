package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 

public class Armor extends Item {
    private int defense_point ;
    private Type type;
    private int durability;

     /**
     * Constructeur de Armor
     */
    public Armor(String name , int durability , int defense_point, Type type){
        super (name) ;
        this.durability = durability;
        this.defense_point =defense_point;
        this.type = type;
    } 

    public int get_durability() { return this.durability; }

    /**
    * SETTERS
    */
    public void set_defense_point(int defense_point) {this.defense_point = defense_point;} 
    public void set_durability(int durability){ this.durability = durability; }    


    /**
    * METHODE
    */
    public int getdefense_point()    {return this.defense_point;} 
  
    public void use_damage_n (int nb_damage) {this.use_damage (nb_damage) ;} 

    /**
      * affichage de l'item
      */
    @Override
    public String to_string(){
        return super.to_string()+"("+this.defense_point+" ,"+this.type+ ", "+this.durability+" )";
    }

}
