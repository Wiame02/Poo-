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
     * Ajoute une item à l'inventaire
     * @param e un item
     */
    public void add_item(Item e){
        // Determiner si l'item existe deja dans l'inventaire (WHILE)
            // Si oui ajouter 1 au nombre d'exemplaire
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
     * Affiche l'inventaire entier
     */
    public void display_inventory(){
        for(Item item : this.items){
            // Afficher nom de l'item
        }
    }
}
