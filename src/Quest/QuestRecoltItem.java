package Quest;
import Stuff.*;
import User.*;

/**
 * QuestRecoltItem.java
 * QuestRecoltItem décrit une quête où l'on récolter un item
 * @author Monique RIMBERT
 * @author Katel HIGNARD
 */

public class QuestRecoltItem extends Quest{
    protected Item item;

    public QuestRecoltItem(String title, int bonus_exp, Item i){
        super(title,bonus_exp);
        this.item = i;
    }

    /*
     * GETTERS
     */
    public Item get_item(){return this.item;}

    /*
     * SETTERS
     */
    public void set_item(Item i){this.item=i;}

    @Override
    public void submit(Player p){
        int i = 0;
        Inventory inventory = p.get_Inventory();
        while(i<=inventory.get_items().size() ||inventory.get_item_at(i).is_equal(this.item)){
            i++;
        }
    };
}
