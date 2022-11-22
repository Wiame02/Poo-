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

    QuestKillMonster(String title, Item reward, int bonus_exp, Monster monster){
        super(title, reward, bonus_exp);
        this.monster = monster;
    }

    @Override
    public void submit(Player p){
        int i = 0 ;
        World world = p.get_current_area().get_world();
        while(i<=world.get_areas().size() || !world.get_area_at(i).get_entity().is_equal(this.monster)){
            i++;
        }
        if(!world.get_area_at(i).get_entity().isAlive()){
            this.is_accomplished=true;
        }
    };
}
