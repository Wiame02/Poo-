package User;
import java.util.ArrayList;
import Localization.*;

/**
 * Player.java
 * Player décrit le personnage du joueur
 * @author Katel HIGNARD
 */

public class Player{
/* Attribus */
    private String username;
    private int lvl;
    private int hp;
    private Order category;
    private ArrayList<Item> inventory;
    private Armor[] armor;
    private Weapon weapon;
    private Quest current_quest;
    private Area current_area;

/* Constructeur
 * @param username
 * @param category
 * @param first_area
*/
    public Player(String username, Order category, Area first_area){
        this.username = username;
        this.lvl = 0;
        this.hp = 100;
        this.category = category;
        
        Armor basic_helmet;
        Armor basic_chestplate;
        Armor basic_legging;
        Armor basic_boot;
        //TODO : Créer les pieces d'armures de debut de jeu

        Weapon basic_weapon;
        //TODO : Créer l'arme de debut de jeu

        this.armor[0] = basic_helmet;
        this.armor[1] = basic_chestplate;
        this.armor[2] = basic_legging;
        this.armor[3] = basic_boot;
        this.weapon = basic_weapon;
        this.current_quest = null;
        this.current_area = first_area;
    }

/* Méthodes */
        /* GUETTERS */
    public String get_username(){return this.username;}
    public int get_lvl(){return this.lvl;}
    public int get_hp (){return this.hp;}
    public Order get_category(){return this.category;}
    public Armor get_helmet(){return this.armor[0];}
    public Armor get_chestplate(){return this.armor[1];}
    public Armor get_legging(){return this.armor[2];}
    public Armor get_boot(){return this.armor[3];}
    public Weapon get_weapon(){return this.weapon;}
    public Quest get_current_quest(){return this.current_quest;}
    public Area get_current_area(){return this.current_area;}
        
        /* SETTERS */
    public void set_lvl(int lvl){this.lvl=lvl;}
    public void set_hp(int hp){this.hp=hp;}
    public void set_category(Order category){this.category=category;}
    public void set_helmet(Armor casque){this.armor[0]=casque;}
    public void set_chestplaste(Armor chestplate){this.chestplate=chestplate;}
    public void set_legging(Armor legging){this.legging=legging;}
    public void set_boot(Armor boot){this.boot=boot;}
    public void set_current_quest(Quest quest){this.current_quest=quest;}
    public void set_current_area(Area area){this.current_area=area;}

}