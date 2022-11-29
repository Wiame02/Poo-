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

    /**
     * Fonction qui retourne les données d'une QuestRecoltItem sous forme de chaine de caractere
     * @return
     */
    @Override
    public String to_string(){
        return super.to_string()+"\n Item a récolter : "+this.item.get_name();
    }

    /**
     * Vérifie si la quete est réalisée et retourne si elle l'est ou non
     * @param p
     * @return true si la quete est accomplie, false sinon
     */
    @Override
    public void submit(Player p){
        int i = 0;
        Inventory inventory = p.get_Inventory();
        while(i<=inventory.getItems().size() ||inventory.getItemAt(i).is_equal(this.item)){
            i++;
        }
    };
}
