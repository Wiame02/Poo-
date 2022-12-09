package Quest;
import Stuff.*;
import User.*;

/**
 * Quest.java
 * Quest décrit une quête que ce soit tuer un monstre ou recolter un item
 * @author Monique RIMBERT
 * @author Katel HIGNARD
 */

public abstract class Quest {
    protected String title;
    protected boolean isAccomplished, isAccepted;
    protected Item reward;
    protected int bonusExp;

    /**
     * Constructeur de la classe Quest
     * @param title Le titre de la quête 
     * @param bonusExp La récompense bonus en points d'expérience de la quête
     */
    public Quest(String title, int bonusExp) {
        this.title = title;
        this.isAccomplished = false;
        this.reward = null;
        this.bonusExp = bonusExp;
        this.isAccepted = false;
    }

    /**
     * @return Le titre de la quête
     */
    public String getTitle() { return this.title; }

    /**
     * @return 
     */
    public Item getReward() { return this.reward; }

    /**
     * @return La récompense bonus en points d'expérience de la quête
     */
    public int getBonusExp() { return this.bonusExp; }

    /**
     * @return Si la quête a été ouverte
     */
    public boolean isAccepted() { return this.isAccepted; }

    
    /**
     * Fixe le titre au nom donné
     * @param title
     */
    public void setTitle(String title){ this.title = title; }

    /**
     * Fixe la récompense à l'Item donné
     * @param reward
     */
    public void setReward(Item reward){ this.reward = reward; }

    /**
     * Fixe les points d'expérience bonus au nombre donné
     * @param exp
     */
    public void setBonusExp(int exp){ this.bonusExp = exp; }

    /**
     * Vérifie si la quete est réalisée
     * @param p Le joueur qui soummet sa quête
     */
    public abstract void submit(Player p);

    /**
     * Accepte une quete
     */
    public void acceptQuest() { this.isAccepted = true;}


    /**
     * @return Formattage de la classe Quest
     */


    @Override
    public String toString(){
        String res = "Titre : "+this.title+"\n Récompense : "+this.reward+"\n Bonus d'exp : "+this.bonusExp+"\n Quête ";
        if(this.isAccomplished){
            res += "finie \n";
        } else {
            res += "en cours \n";
        }
        return res;
    }

    /**
     * Vérifie si la quete est réalisée et retourne si elle l'est ou non
     * @param p
     * @return true si la quete est accomplie, false sinon
     */
    public boolean isAccomplished(Player p){
        /* Si la quête est déjà accomplie il ne faut pas le revérifier.
         * Si la quete est une QuestRecoltItem, l'objet disparait de l'inventaire au rendu donc validable une seule fois 
         */
        if(!this.isAccomplished){ 
            this.submit(p);
        }
        return this.isAccomplished;
    }
}
