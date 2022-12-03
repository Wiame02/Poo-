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

    /**
     * Constructeur de la classe QuestRecoltItem
     * @param title Titre de la quête
     * @param bonusExp Les points d'expérience bonus que l'on peut obtenir
     * @param i L'item qui est à réccuperer
     */
    public QuestRecoltItem(String title, int bonusExp, Item i){
        super(title, bonusExp);
        this.item = i;
    }

    /**
     * @return L'item qui est à réccuperer
     */
    public Item getItem() { return this.item; }

    /**
     * Fixe l'item à réccuperer avec l'Item donné
     * @param i Le nouvel item à réccuperer
     */
    public void setItem(Item i) { this.item = i; }

    /**
     * @return Formattage de la classe QuestRecoltItem
     */
    @Override
    public String toString(){
        return super.toString()+"\n Item a récolter : "+this.item.getName();
    }

    /**
     * Vérifie si la quete est réalisée et retourne si elle l'est ou non
     * @param p
     * @return true si la quete est accomplie, false sinon
     */
    @Override
    public void submit(Player p){
        //FIXME
        int i = 0;
        Inventory inventory = p.get_Inventory();
        while(i<=inventory.getItems().size() ||inventory.getItemAt(i).isEqual(this.item)){
            i++;
        }
    };
}
