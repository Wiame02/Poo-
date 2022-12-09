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
        this.hp = 100;
        this.category = category;
        
        this.inventory = new Inventory();

        // Création de l'armure et arme de départ d'un joueur
        this.armor = new Armor[4];
        this.armor[0] = new Armor("Chapeau de cuir",50,10,Type.HELMET);
        this.armor[1] = new Armor("Tunique en Lin",50,10,Type.CHESTPLATE);
        this.armor[2] = new Armor("Pantalon en Lin",50,10,Type.LEGGING);
        this.armor[3] = new Armor("Chaussure de cuir",50,10,Type.BOOT);

        this.weapon = new Weapon("Brindille",20,20000);
        
        this.currentQuest = null;
        this.currentArea = firstArea;
    }

/**
 * GETTERS 
*/
    public String   getUsername()      {return this.username;}
    public int      getLvl()           {return this.lvl;}
    public int      getHp ()           {return this.hp;}
    public Order    getCategory()      {return this.category;}
    public Armor    getHelmet()        {return this.armor[0];}
    public Armor    getChestplate()    {return this.armor[1];}
    public Armor    getLegging()       {return this.armor[2];}
    public Armor    getBoot()          {return this.armor[3];}
    public Weapon   getWeapon()        {return this.weapon;}
    public Quest    getCurrentQuest() {return this.currentQuest;}
    public Area     getCurrentArea()  {return this.currentArea;}
    public Inventory getInventory()    {return this.inventory;}
        
/**
 * SETTERS
*/
    private void setUsername(String name) {this.username=name;}
    public void setLvl(int lvl) {
        if(lvl>=0){
            this.lvl=lvl;
        }else{
            this.lvl=0;
        }
    }
    public void setHp(int hp){
        if(hp>=0){
            this.hp=hp;
        }else{
            this.hp = 0;
        }
    }
    public void setCategory(Order category) {this.category=category;}
    private void setInventory(Inventory i) {this.inventory=i;}
    private void setArmor(Armor[] armor) {
        if(armor[0].getType()==Type.HELMET){
            this.armor[0] = armor[0];
        }
        if(armor[1].getType()==Type.CHESTPLATE){
            this.armor[1] = armor[1];
        }
        if(armor[2].getType()==Type.LEGGING){
            this.armor[2] = armor[2];
        }
        if(armor[3].getType()==Type.BOOT){
            this.armor[3] = armor[3];
        }
    }
    public void     setWeapon(Weapon weapon)           {this.weapon=weapon;}
    public void     setCurrentQuest(Quest quest)      {this.currentQuest=quest;}
    public void     setCurrentArea(Area area)         {this.currentArea=area;}

/**
 * Affichages
 */ 
    /**
     * Affiche l'armure portée
     */
    public void displayArmor(){
        for(Armor a : this.armor){
            System.out.println(a.toString());
        }
    }

    /**
     * Affiche l'arme portée
     */
    public void displayWeapon(){
        System.out.println(this.weapon.toString());
    }

    /**
     * Affiche les informations sur le joueur tel que les points de vies et son niveau d'experience
     */
    public void displayPlayerData(){
        System.out.println("Informations de "+this.username+" ---");
        System.out.println("Points de vie : "+this.hp);
        System.out.println("Niveau d'experience : "+this.lvl);
    }

    /**
     * Affiche la quete actuelle
     */
    public void displayCurrentQuest(){
        System.out.println(this.currentQuest.toString());
    }


    /**
     * 
     */
    @Override
    public String toString(){
        String res ="";
        res+="Pseudo : "+this.username+"\n";
        res+="lvl : "+this.lvl+"\n";
        res+="HP : "+this.hp+"\n";
        res+="Classe : "+this.category.getName()+"\n";
        res+=this.inventory.toString()+"\n";
        res+="Armure : \n ";
        res+=this.armor[0].toString()+"\n";
        res+=this.armor[1].toString()+"\n";
        res+=this.armor[2].toString()+"\n";
        res+=this.armor[3].toString()+"\n";
        res+= "Quete actuelle :";
        res+=(this.currentQuest!=null)?this.currentQuest.getTitle():"";
        res+= "\nZone actuelle :"+this.currentArea.getName()+"\n";
        return res;
    }
/*
 * Déplacements
 */
    /**
     * Le joueur se déplace dans une zone
     * @param destination la destination d'arrivée
     */
    public void moveTo(Area destination){
        this.currentArea = destination;
    }

    /**
     * Déplace le joueur dans la zone d'entrée si elle est accessible à partir de la zone ou il se situe
     * @param destination une zone
     * @throws Exception si la zone n'est pas accessible
     */
    public void moveToLinkedArea(Area destination) throws Exception{
        if(this.currentArea.getAccessArea(destination.getName())==null){
            throw new Exception("La zone n'est pas accessible");
        }else{
            this.moveTo(destination);
        }
    }

/*
 * Gestion des points de vie
 */
    /**
     * Augmente les points de vies d'un entier n
     * @param n
     */
    public void increaseHp(int n) throws Exception {
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
    public void decreaseHp(int n) throws Exception{
        if(this.isAlive()){
            if(n>=0){
                if(this.hp<=n){
                    this.hp=0;
                }else{
                    this.hp-=n;
                }
            }else{
                throw new Exception("Ne peut pas soustraire une valeur négative");
            }
        }else{ 
            throw new Exception("Ne peut pas soustraire : La vie du joueur est déjà à 0");
        }
    }

    /**
     * Le joueur subit des dégats qui sont en partie absorbés par son armure
     * @param n les dégats subits
     * @return
     */
    public void decreaseHpWithArmor(int n,Entity e) throws Exception{
        int damage = n ;
        for(Armor a : this.armor){
            damage -= a.getDefensePoint()/100*n/4;
            if(a.getDefensePoint()>100){
                try{e.decreaseHp(n*(a.getDefensePoint()-100)/100);}
                catch(Exception exception){System.out.println(e.getName()+" a esquivé les dégats de retour.");}
            }
        }
        try{
            this.decreaseHp(damage);
        }
        catch(Exception exception){
            throw exception;
        }
    }

    /**
     * Retourne si le personnage est vivant ou non 
     * @return  true si les points de vie sont strictement supérieurs à 0
     *          false sinon
     */
    public boolean isAlive(){
        return (this.hp>0);
    }

/*
 * Modification de l'equipement
 */
    /**
     * Change l'equipement du personnage par le nouveau selon sa categorie
     * @param newArmor
     * @throws Exception si l'armure n'est pas typée
     */
    public void equipArmor(Armor newArmor) throws Exception{
        if(this.inventory.getItems().contains(newArmor)){
            if(newArmor.getType() == Type.HELMET){
                this.inventory.addItem(this.armor[0]);
                this.armor[0]=newArmor;
                this.inventory.deleteItem(this.armor[0].getName());
            }else if(newArmor.getType() == Type.CHESTPLATE){
                this.inventory.addItem(this.armor[1]);
                this.armor[1]=newArmor;
                this.inventory.deleteItem(this.armor[1].getName());
            }else if(newArmor.getType() == Type.LEGGING){
                this.inventory.addItem(this.armor[2]);
                this.armor[2]=newArmor;
                this.inventory.deleteItem(this.armor[2].getName());
            }else if(newArmor.getType() == Type.BOOT){
                this.inventory.addItem(this.armor[3]);
                this.armor[3]=newArmor;
                this.inventory.deleteItem(this.armor[3].getName());
            }else{
                throw new Exception("Armor without type");
            }
        }else{
            throw new Exception("Le joueur n'a pas l'armure dans son inventaire.");
        }
    }


    /**
     * Change l'arme du personnage par la nouvelle
     * @param newWeapon
     */
    public void equipWeapon(Weapon newWeapon) throws Exception{
        if(this.inventory.getItems().contains(newWeapon)){
            this.inventory.addItem(this.weapon);
            this.weapon=newWeapon;
            this.inventory.deleteItem(this.weapon.getName());
        }
    }

/*
 * Actions d'un joueur
 */
    /**
     * Le personnage interagit avec une entité
     * @param e
     */
    public void interact(Villager v){
        v.talk(this);
    }

    /**
     *  Attaque une entité et lui fait perdre des points de vies
     * @param entity
     */
    public void attack(Monster m){
        try{
            if(this.weapon==null){
                m.decreaseHp(1);
            }else{
                m.decreaseHp(this.weapon.getAttackPoints());
            }
        }
        catch(Exception e){
            System.out.println(m.getName()+" a esquivé votre attaque");
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
    public void setField (String fieldName, Object setValue) throws NoSuchFieldException, Exception{
        if(fieldName=="username"){
            if(ApplicationReflection.areObjectsFromSameClass (this.username, setValue)){
                this.setUsername((String)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "lvl"){
            if(ApplicationReflection.areObjectsFromSameClass (this.lvl, setValue)){
                this.setLvl((int)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "hp"){
            if(ApplicationReflection.areObjectsFromSameClass (this.hp, setValue)){
                this.setHp((int)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "category"){
            if(ApplicationReflection.areObjectsFromSameClass (this.category, setValue)){
                this.setCategory((Order)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "inventory"){
            if(ApplicationReflection.areObjectsFromSameClass (this.inventory, setValue)){
                this.setInventory((Inventory)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "armor"){
            if(ApplicationReflection.areObjectsFromSameClass (this.armor, setValue)){
                 this.setArmor((Armor[])setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "weapon"){
            if(ApplicationReflection.areObjectsFromSameClass (this.weapon, setValue)){
                this.setWeapon((Weapon)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "currentQuest"){
            if(ApplicationReflection.areObjectsFromSameClass (this.currentQuest, setValue)){
                this.setCurrentQuest((Quest)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else if(fieldName == "currentArea"){
            if(ApplicationReflection.areObjectsFromSameClass (this.currentArea, setValue)){
                this.setCurrentArea((Area)setValue);
            }else{
                throw new Exception("Objet d'entrée de mauvais type");
            }
        }else{
            throw new NoSuchFieldException();
        }
    }
}    