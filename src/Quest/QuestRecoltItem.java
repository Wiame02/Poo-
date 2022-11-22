package Quest;
import Stuff.*;
import User.*;
import Localization.*;

/**
 * QuestRecoltItem.java
 * QuestRecoltItem décrit une quête où l'on récolter un item
 * @author Monique RIMBERT
 * @author Katel HIGNARD
 */

public class QuestRecoltItem extends Quest{
    protected Item item;

    QuestRecoltItem(String title, Item reward, int bonus_exp, Item item){
        super(title, reward, bonus_exp);
        this.item = item;
    }

    @Override
    public void submit(Player p){
        int i = 0;
        Inventory inventory = p.get_Inventory();
        while(i<=inventory.get_items().size() ||inventory.get_item_at(i).is_equal(this.item)){
            i++;
        }
    };
}
