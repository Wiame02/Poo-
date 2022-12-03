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
    public ArrayList<Item> getItems(){
        return this.items;
    }

    /**
     * Retourne l'item à l'indice i
     * @param i un indice
     * @return un item
     */
    public Item     getItemAt(int i)  {return this.items.get(i);}



    /**
     * Affiche l'inventaire
     */
    void displayInventory(){
        for(Item i : this.items){
            i.toString();
        }
    }

    /**
     * Cherche l'item d'entrée dans l'inventaire
     * @param e un item à trouver
     * @return l'indice dans la liste si l'item est trouvé ou -1
     */
    private int findIdItemWithName(String name){
        int id=0;
        int listLength = this.items.size();
        boolean isFound = this.getItemAt(id).getName()==name;
        while(id<=listLength && !isFound){
            id++;
            isFound = this.getItemAt(id).getName()==name;
        }
        if(id>listLength){
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
    private int findIdItem(Item e){
        int id=0;
        int listLength = this.items.size();
        boolean isFound = this.getItemAt(id).isEqual(e);
        while(id<=listLength && !isFound){
            id++;
            isFound = this.getItemAt(id).isEqual(e);
        }
        if(id>listLength){
            return -1;
        }else{
            return id;
        }
    }

    /**
     * Ajoute une item à l'inventaire
     * @param e un item
     */
    public void addItem(Item e){
        int idItem = findIdItem(e);
        if(idItem>=0){
            //this.getItemAt(id_item).quantity += e.quantity 
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
    public boolean deleteItem(String name){
        int idItem = findIdItemWithName(name);
        if(idItem>=0){
            this.items.remove(idItem);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Utilise un exemplaire d'un item donné par son nom
     * @param name nom de l'item à utiliser
     */
    public boolean useItem(String name){
        int idItem = findIdItemWithName(name);
        if(idItem>=0){
            /* TODO
            this.getItemAt(id_item).use();
            if(this.getItemAt(id_item).getQuantity()==0){
                this.items.remove(id_item);
            }*/
            return true;
        }else{
            return false;
        }
    }
}
