package Stuff;
//item.java 
// Item les objets utiliser par le personnage 
// @author Taii wiame 

public class Weapon extends Item {
    private int attack_point ;
    private int durability;

    //--------------------constructeur ---------------------------
    public Weapon(String name , int durability , int attack_point){
        super (name) ;
        this.attack_point = attack_point;
        this.durability = durability;
    } 

    //---------------------methode--------------------------------
    public int get_attack_point()    {return this.attack_point;} 
    public int get_durability() { return this.durability; }

    public void set_durability(int durability){ this.durability = durability; }

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


    @Override
    public String to_string(){
      return super.to_string()+"("+this.attack_point+", "+this.durability+")";
    }

}
 
 






    