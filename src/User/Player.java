package User;
import java.util.ArrayList;
import Localization.*;
import Entity.*;
import Quest.*;
import Stuff.*;

/**
 * Player.java
 * Player décrit le personnage du joueur
 * @author Katel HIGNARD
 */

public class Player{
    private String username;
    private int lvl;
    private int hp;
    private Order category;
    private Inventory inventory;
    private Armor[] armor;
    private Weapon weapon;
    private Quest current_quest;
    private Area current_area;

/**
 * Constructeur
 * @param username
 * @param category
 * @param first_area
*/
    public Player(String username, Order category, Area first_area){
        this.username = username;
        this.lvl = 0;
        this.hp = 750;
        this.category = category;
        
        this.inventory = new Inventory();

        this.armor = new Armor[4];
        this.armor[0] = new Armor("Chapeau de cuir",50,10,Type.HELMET);
        this.armor[1] = new Armor("Tunique en Lin",50,10,Type.CHESTPLATE);
        this.armor[2] = new Armor("Pantalon en Lin",50,10,Type.LEGGING);
        this.armor[3] = new Armor("Chaussure de cuir",50,10,Type.BOOT);

        this.weapon = new Weapon("Brindille",20,5);
        
        this.current_quest = null;
        this.current_area = first_area;
    }

/**
 * GETTERS 
*/
    public String   get_username()      {return this.username;}
    public int      get_lvl()           {return this.lvl;}
    public int      get_hp ()           {return this.hp;}
    public Order    get_category()      {return this.category;}
    public Armor    get_helmet()        {return this.armor[0];}
    public Armor    get_chestplate()    {return this.armor[1];}
    public Armor    get_legging()       {return this.armor[2];}
    public Armor    get_boot()          {return this.armor[3];}
    public Weapon   get_weapon()        {return this.weapon;}
    public Quest    get_current_quest() {return this.current_quest;}
    public Area     get_current_area()  {return this.current_area;}
    public Inventory get_Inventory()    {return this.inventory;}
        
/**
 * SETTERS
*/
    public void     set_lvl(int lvl)                    {this.lvl=lvl;}
    public void     set_hp(int hp)                      {this.hp=hp;}
    public void     set_category(Order category)        {this.category=category;}
    public void     set_helmet(Armor casque)            {this.armor[0]=casque;}
    public void     set_chestplaste(Armor chestplate)   {this.armor[1]=chestplate;}
    public void     set_legging(Armor legging)          {this.armor[2]=legging;}
    public void     set_boot(Armor boot)                {this.armor[3]=boot;}
    public void     set_current_quest(Quest quest)      {this.current_quest=quest;}
    public void     set_current_area(Area area)         {this.current_area=area;}

/**
 * Fonctions des convertion d'une donnée en chaîne de caractère
 */

/**
 * Affichages
 */ 
    /**
     * Affiche l'armure portée
     */
    public void display_armor(){
        for(Armor a : this.armor){
            a.to_string();
        }
    }

    /**
     * Affiche l'arme portée
     */
    public void display_weapon(){
        this.weapon.to_string();
    }

    /**
     * Affiche les informations sur le joueur tel que les points de vies et son niveau d'experience
     */
    public void display_player_data(){
        System.out.println("Informations de "+this.username+" ---");
        System.out.println("Niveau de vie : "+this.hp);
        System.out.println("Niveau d'experience : "+this.lvl);
    }

/*
 * Déplacements
 */
    /**
     * Le joueur se déplace dans une zone
     * @param destination la destination d'arrivée
     */
    public void move_to(Area destination){
        this.current_area = destination;
    }

    public void move_linked_area(Area destination) throws Exception{

        
        if(this.current_area.get_access_area(destination.get_name())==null){
            throw new Exception("La zone n'est pas accessible");
        }else{
            this.move_to(destination);
        }
    }

/*
 * Gestion des points de vie
 */
    /**
     * Augmente les points de vies d'un entier n
     * @param n
     */
    public void increase_hp(int n) throws Exception {
        if(n>0){
            this.hp+=n;
        }else{
            throw new Exception("Ne peut pas ajouter une valeur nulle ou négative");
        }
    }

    /**
     * Diminue les points de vies d'un entier n
     * @param n
     */
    public void decrease_hp(int n) throws Exception{
        if(is_alive()){
            if(n>0){
                if(this.hp<=n){
                    this.hp=0;
                }else{
                    this.hp-=n;
                }
            }else{
                throw new Exception("Ne peut pas soustraire une valeur nulle ou négative");
            }
        }else{ 
            throw new Exception("Ne peut pas soustraire : La vie du joueur est déjà à 0");
        }
    }

    /**
     * Retourne true si le personnage est vivant sinon false
     * @return bool
     */
    public boolean is_alive(){
        return (this.hp!=0);
    }

/*
 * Modification de l'equipement
 */
    /**
     * Change l'equipement du personnage par le nouveau selon sa categorie
     * @param new_armor
     */
    public void equip_armor(Armor new_armor) throws Exception{ 
        /*
        if(new_armor. == Type.HELMET){
            this.armor[0]=new_armor;
        }else if(new_armor. == Type.CHESTPLATE){
            this.armor[1]=new_armor;
        }else if(new_armor. == Type.LEGGINGS){
            this.armor[2]=new_armor;
        }else if(new_armor. == Type.BOOTS){
            this.armor[3]=new_armor;
        }else{
            throw new Exception("Armor without type");
        }
        */
    }


    /**
     * Change l'arme du personnage par la nouvelle
     * @param new_weapon
     */
    public void equip_weapon(Weapon new_weapon){
        this.weapon=new_weapon;
    }

/*
 * Actions d'un joueur
 */
    /**
     * Le personnage interagit avec une entité
     * @param e
     */
    public void interact(Villager v){
        v.talk(this.current_quest,this);
    }

    /**
     *  Attaque une entité et lui fait perdre des points de vies
     * @param entity
     */
    public void attack(Monster m){
        try{
            m.decrease_hp(this.weapon.get_attack_point());
        }
        catch(Exception e){
            System.out.println(m.get_name()+" a esquivé votre attaque");
        }
    }

}    