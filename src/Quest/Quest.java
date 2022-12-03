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
    protected boolean isAccomplished;
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
     * Si la quête est accomplie, change l'attribus isAccomplished en true sinon le laisse a false
     * @param p Le Joueur qui soummet sa quête 
     */
    public abstract void submit(Player p);

    /**
     * @return Formattage de la classe Quest
     */
    @Override
    public String toString(){
        String res = "Titre : "+this.title+"\n Récompense : "+this.reward+"\n Bonus d'exp : "+this.bonusExp+"\n Quête ";
        if(this.isAccomplished){
            res+="finie \n";
        } else {
            res+="en cours \n";
        }
        return res;
    }

    /**
     * Vérifie si la quete est réalisée et retourne si elle l'est ou non
     * @param p
     * @return true si la quete est accomplie, false sinon
     */
    public boolean isAccomplished(Player p){
        this.submit(p);
        return this.isAccomplished;
    }
}
