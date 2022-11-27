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

    QuestKillMonster(String title, int bonus_exp){
        super(title, bonus_exp);
        this.monster=null;
    }

    /*
     * GETTERS
     */
    public Monster get_monster(){return this.monster;}

    /*
     * SETTERS
     */
    public void set_monster(Monster m){this.monster=m;}

    @Override
    public void submit(Player p){
        int i = 0 ;
        World world = p.get_current_area().get_world();
        while(i<=world.get_areas().size() || !world.get_area_at(i).get_entity().is_equal(this.monster)){
            i++;
        }
        if(!world.get_area_at(i).get_entity().is_alive()){
            this.is_accomplished=true;
        }
    };
}
