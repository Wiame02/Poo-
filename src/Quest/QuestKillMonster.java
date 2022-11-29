package Quest;
import Entity.*;
import Stuff.*;
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

    public QuestKillMonster(String title, int bonus_exp,Monster m){
        super(title, bonus_exp);
        this.monster=m;
    }

    /*
     * GETTERS
     */
    public Monster get_monster(){return this.monster;}

    /*
     * SETTERS
     */
    public void set_monster(Monster m){this.monster=m;}

    /**
     * Fonction qui retourne les données d'une QuestKillMonster sous forme de chaine de caractere
     * @return
     */
    @Override
    public String to_string(){
        return super.to_string()+"\n Monstre a abattre : "+this.monster.get_name();
    }

    /**
     * Vérifie si la quete est réalisée et retourne si elle l'est ou non
     * @param p
     * @return true si la quete est accomplie, false sinon
     */
    @Override
    public void submit(Player p){
        int i = 0 ;
        World world = p.get_current_area().getWorld();
        while(i<=world.get_areas().size() || !world.get_area_at(i).getEntity().is_equal(this.monster)){
            i++;
        }
        if(!world.get_area_at(i).getEntity().is_alive()){
            this.is_accomplished=true;
        }
    };
}
