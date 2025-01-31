package Quest;
import Entity.*;
import User.Player;
import Localization.*;

/**
 * QuestKillMonster.java
 * QuestKillMonster décrit une quête où l'on doit tuer un monstre
 * @author Monique RIMBERT
 * @author Katel HIGNARD
 */

public class QuestKillMonster extends Quest{
    private Monster monster ;

    /**
     * Contructeur de la classe QuestKillMonster
     * @param title Le titre de la quête
     * @param bonusExp Le nombre de points d'expérience bonus que l'on peut avoir
     * @param m Le monstre qui est à tuer
     */
    public QuestKillMonster(String title, int bonusExp, Monster m){
        super(title, bonusExp);
        this.monster = m;
    }

    /**
     * @return Le monstre qui est à tuer
     */
    public Monster getMonster() { return this.monster; }
    
    /**
     * Fixe le monstre qui est à tuer pour achever la quête
     * @param m
     */
    public void setMonster(Monster m) { this.monster = m; }

    /**
     * @return Formattage de la classe QuestKillMonster
     */
    @Override
    public String toString(){
        return super.toString() + "\n Monstre à abattre : " + this.monster.getName();
    }

    /**
     * Vérifie si la quete est réalisée
     * @param p Le joueur qui soummet sa quête
     */
    @Override
    public void submit(Player p){
        int i = 0 ;
        World world = p.getCurrentArea().getWorld();

        while(i<world.getAreas().size() && (world.getAreaAt(i).getEntity() == null || !world.getAreaAt(i).getEntity().isEqual(this.monster))){
            i++;
            //System.out.println("QuestKillMonster.submit(Player) : i++; i == " + i);
        }

        if(i<world.getAreas().size() && !world.getAreaAt(i).getEntity().isAlive()){
            super.isFinished = true;
        }
    }
}
