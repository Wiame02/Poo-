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

    /**
     * Retourne la liste d'items soit l'inventaire
     * @return la liste d'items
     */
    public ArrayList<Item> get_items(){
        return this.items;
    }

    /**
     * 
     * @param i
     * @return
     */
    public Item     get_item_at(int i)  {return this.items.get(i);}

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
        // Determiner si l'item existe deja dans l'inventaire (WHILE)
            // Si oui ajouter e.dur au nombre d'exemplaire
            // Si non ajouter l'item et mettre le nb exemplaire à 1
    }

    /**
     * Supprime l'item selon son indice
     * @param id l'indice du l'item a supprimer
     */
    public void delete_item(int id){
        // Trouver l'item dans l'inventaire (WHILE)
        // Supprimer l'item (en ignorant le nb exemplaire)
    }

    /**
     * Utilise un exemplaire d'un item donné par son nom
     * @param name nom de l'item à utiliser
     */
    public void use_item(String name){

        // id = Trouver l'item (WHILE)
        // enlever 1 exemplaire
        // VERIF : Si 0 exemplaire -> delete_item(id)
    }

    /**
     * Affiche l'inventaire
     */
    void display_inventory(){
        for(Item i : this.items){
            i.to_string();
        }
    }
}
