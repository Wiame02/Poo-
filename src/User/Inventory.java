package User;
import Stuff.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    /**
     * Constructeur d'un Inventaire
     */
    Inventory(){
        this.items = new ArrayList<Item>();
    }

/*
 * Getters 
 */
    /**
     * Retourne la liste d'items soit l'inventaire
     * @return la liste d'items
     */
    public ArrayList<Item> get_items(){
        return this.items;
    }

    /**
     * Retourne l'item à l'indice i
     * @param i un indice
     * @return un item
     */
    public Item     get_item_at(int i)  {return this.items.get(i);}



    /**
     * Affiche l'inventaire
     */
    void display_inventory(){
        for(Item i : this.items){
            i.to_string();
        }
    }

    /**
     * Cherche l'item d'entrée dans l'inventaire
     * @param e un item à trouver
     * @return l'indice dans la liste si l'item est trouvé ou -1
     */
    private int find_id_item_with_name(String name){
        int id=0;
        int list_length = this.items.size();
        boolean is_finded = this.get_item_at(id).get_name()==name;
        while(id<=list_length && !is_finded){
            id++;
            is_finded = this.get_item_at(id).get_name()==name;
        }
        if(id>list_length){
            return -1;
        }else{
            return id;
        }
    }

    /**
     * Cherche l'item d'entrée dans l'inventaire
     * @param e un item à trouver
     * @return l'indice dans la liste si l'item est trouvé ou -1
     */
    private int find_id_item(Item e){
        int id=0;
        int list_length = this.items.size();
        boolean is_finded = this.get_item_at(id).is_equal(e);
        while(id<=list_length && !is_finded){
            id++;
            is_finded = this.get_item_at(id).is_equal(e);
        }
        if(id>list_length){
            return -1;
        }else{
            return id;
        }
    }

    /**
     * Ajoute une item à l'inventaire
     * @param e un item
     */
    public void add_item(Item e){
        int id_item = find_id_item(e);
        if(id_item>=0){
            //this.get_item_at(id_item).quantity += e.quantity 
        }else{
            this.items.add(e);
        }
    }

    /**
     * Supprime l'item selon son indice
     * @param id l'indice du l'item a supprimer
     * @return  true si le suppression a été effectuée
     *          false si l'objet n'est pas dans la liste
     */
    public boolean delete_item(String name){
        int id_item = find_id_item_with_name(name);
        if(id_item>=0){
            this.items.remove(id_item);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Utilise un exemplaire d'un item donné par son nom
     * @param name nom de l'item à utiliser
     */
    public boolean use_item(String name){
        int id_item = find_id_item_with_name(name);
        if(id_item>=0){
            /* TODO
            this.get_item_at(id_item).use();
            if(this.get_item_at(id_item).get_quantity()==0){
                this.items.remove(id_item);
            }*/
            return true;
        }else{
            return false;
        }
    }
}
