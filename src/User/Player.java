package User;
import Localization.*;
import Entity.*;
import Quest.*;
import Stuff.*;
import Application.Reflection.*;

/**
 * Player.java
 * Player décrit le personnage du joueur
 * @author Katel HIGNARD
 */

public class Player implements ClassInformation{
    private String username;
    private int lvl;
    private int hp;
    private Order category;
    private Inventory inventory;
    private Armor[] armor;
    private Weapon weapon;
    private Quest currentQuest;
    private Area currentArea;

/**
 * Constructeur
 * @param username pseudo du joueur
 * @param category category choisie par le joueur
 * @param firstArea zone du spawn du joueur
*/
    public Player(String username, Order category, Area firstArea){
        this.username = username;
        this.lvl = 0;
        this.hp = 750;
        this.category = category;
        
        this.inventory = new Inventory();

        // Création de l'armure et arme de départ d'un joueur
        this.armor = new Armor[4];
        this.armor[0] = new Armor("Chapeau de cuir",50,10,Type.HELMET);
        this.armor[1] = new Armor("Tunique en Lin",50,10,Type.CHESTPLATE);
        this.armor[2] = new Armor("Pantalon en Lin",50,10,Type.LEGGING);
        this.armor[3] = new Armor("Chaussure de cuir",50,10,Type.BOOT);

        this.weapon = new Weapon("Brindille",20,5);
        
        this.currentQuest = null;
        this.currentArea = firstArea;
    }

/**
 * GETTERS 
*/
    public String   getUsername()      {return this.username;}
    public int      getLvl()           {return this.lvl;}
    public int      get_hp ()           {return this.hp;}
    public Order    get_category()      {return this.category;}
    public Armor    get_helmet()        {return this.armor[0];}
    public Armor    get_chestplate()    {return this.armor[1];}
    public Armor    get_legging()       {return this.armor[2];}
    public Armor    get_boot()          {return this.armor[3];}
    public Weapon   get_weapon()        {return this.weapon;}
    public Quest    get_current_quest() {return this.currentQuest;}
    public Area     get_current_area()  {return this.currentArea;}
    public Inventory get_Inventory()    {return this.inventory;}
        
/**
 * SETTERS
*/
    private void    set_username(String name)           {this.username=name;}
    public void     set_lvl(int lvl)                    {this.lvl=lvl;}
    public void     set_hp(int hp)                      {this.hp=hp;}
    public void     set_category(Order category)        {this.category=category;}
    private void    setInventory(Inventory i)           {this.inventory=i;}
    private void    setArmor(Armor[] armor)             {
        this.armor[0] = armor[0];
        this.armor[1] = armor[1];
        this.armor[2] = armor[2];
        this.armor[3] = armor[3];
    }
    public void     set_helmet(Armor casque)            {this.armor[0]=casque;}
    public void     set_chestplaste(Armor chestplate)   {this.armor[1]=chestplate;}
    public void     set_legging(Armor legging)          {this.armor[2]=legging;}
    public void     set_boot(Armor boot)                {this.armor[3]=boot;}
    public void     setWeapon(Weapon weapon)           {this.weapon=weapon;}
    public void     set_current_quest(Quest quest)      {this.currentQuest=quest;}
    public void     set_current_area(Area area)         {this.currentArea=area;}

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
        System.out.print(this.weapon.to_string());
    }

    /**
     * Affiche les informations sur le joueur tel que les points de vies et son niveau d'experience
     */
    public void display_player_data(){
        System.out.println("Informations de "+this.username+" ---");
        System.out.println("Niveau de vie : "+this.hp);
        System.out.println("Niveau d'experience : "+this.lvl);
    }

    /**
     * Affiche la quete actuelle
     */
    public void display_current_quest(){
        System.out.println(this.currentQuest.to_string());
    }

/*
 * Déplacements
 */
    /**
     * Le joueur se déplace dans une zone
     * @param destination la destination d'arrivée
     */
    public void move_to(Area destination){
        this.currentArea = destination;
    }

    /**
     * Déplace le joueur dans la zone d'entrée si elle est accessible à partir de la zone ou il se situe
     * @param destination une zone
     * @throws Exception si la zone n'est pas accessible
     */
    public void move_linked_area(Area destination) throws Exception{
        if(this.currentArea.getAccessArea(destination.getName())==null){
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
     * @return true ou false
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
     * @throws Exception si l'armure n'est pas typée
     */
    public void equip_armor(Armor new_armor) throws Exception{ 
        if(new_armor.get_type() == Type.HELMET){
            this.armor[0]=new_armor;
        }else if(new_armor.get_type() == Type.CHESTPLATE){
            this.armor[1]=new_armor;
        }else if(new_armor.get_type() == Type.LEGGING){
            this.armor[2]=new_armor;
        }else if(new_armor.get_type() == Type.BOOT){
            this.armor[3]=new_armor;
        }else{
            throw new Exception("Armor without type");
        }
    }


    /**
     * Change l'arme du personnage par la nouvelle
     * @param newWeapon
     */
    public void equip_weapon(Weapon newWeapon){
        this.weapon=newWeapon;
    }

/*
 * Actions d'un joueur
 */
    /**
     * Le personnage interagit avec une entité
     * @param e
     */
    public void interact(Villager v){
        v.talk(this.currentQuest,this);
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

/*
 * Implementation des procedure de ClassInformation
 */
    /**
     * Retourne tous les objets aux champs d'une Classe, qu'elle soit privée ou public.
     * @return Un tableau d'{@link java.lang.Object} qui représente les champs d'une {@link java.lang.Class}.
     */
    public Object[] getFields(){
        Object[] objects = new Object[9];

        objects[0] = this.username;
        objects[1] = this.lvl;
        objects[2] = this.hp;
        objects[3] = this.category;
        objects[4] = this.inventory;
        objects[5] = this.armor;
        objects[6] = this.weapon;
        objects[7] = this.currentQuest;
        objects[8] = this.currentArea;

        return objects;
    }

    /**
     * Retourne l'objet au champ de la Classe selon le nom du champ.
     * @param fieldName Correspond au nom du champs que l'on appelle.
     * @return {@link java.lang.Object} correspondant à l'object enregistré à ce champ.
     * @throws NoSuchFieldException Si le nom du champ donné ne correspond à aucun des champs que la classe contient.
     */
    public Object getField (String fieldName) throws NoSuchFieldException{
        if(fieldName=="username"){
            return this.username;
        }else if(fieldName == "lvl"){
            return this.lvl;
        }else if(fieldName == "hp"){
            return this.hp;
        }else if(fieldName == "category"){
            return this.category;
        }else if(fieldName == "inventory"){
            return this.inventory;
        }else if(fieldName == "armor"){
            return this.armor;
        }else if(fieldName == "weapon"){
            return this.weapon;
        }else if(fieldName == "currentQuest"){
            return this.currentQuest;
        }else if(fieldName == "currentArea"){
            return this.currentArea;
        }else{
            throw new NoSuchFieldException();
        }
    }

    /**
     * Modifie le champs représenté avec son nom en la valeur donnée.
     * @param fieldName Le nom du champs de la classe qui doit être modifiée.
     * @param setValue  La valeur qui remplacement l'ancienne.
     * @throws NoSuchFieldException Si le nom du champ donné ne correspond à aucun des champs que la classe contient.
     */
    public void setField (String fieldName, Object setValue) throws Exception{
        if(fieldName=="username"){
            this.set_username((String)setValue);
        }else if(fieldName == "lvl"){
            this.set_lvl((int)setValue);
        }else if(fieldName == "hp"){
            this.set_hp((int)setValue);
        }else if(fieldName == "category"){
            this.set_category((Order)setValue);
        }else if(fieldName == "inventory"){
            this.setInventory((Inventory)setValue);
        }else if(fieldName == "armor"){
            this.setArmor((Armor[])setValue);
        }else if(fieldName == "weapon"){
            this.setWeapon((Weapon)setValue);
        }else if(fieldName == "currentQuest"){
            this.set_current_quest((Quest)setValue);
        }else if(fieldName == "currentArea"){
            this.set_current_area((Area)setValue);
        }else{
            throw new NoSuchFieldException();
        }
    }
}    