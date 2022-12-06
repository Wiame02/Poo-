package Application;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import Entity.*;
import User.*;
import Localization.*;

public class UserFonction {

    /**
     * Affiche les actions possibles du joueur
     * @param p le joueur
     */
    public static void displayActions(Player p){
        System.out.println("ACTIONS -----------------------");
        System.out.println("displayDataPlayer()");
        System.out.println("displayInventory()");
        System.out.println("displayCurrentArea()");
        System.out.println("displayAccessibleArea()");
        System.out.println("moveTo(idArea)");
        
        Entity e = p.getCurrentArea().getEntity();
        if(e!=null){
            if(e.getSpecies()!=Species.VILLAGER){
                System.out.println("fight("+e.getName()+")");
            }else{
                System.out.println("interact("+e.getName()+")");
            }
        }
        
    }

    /**
     * Affiche les données du joueur
     * @param p le joueur
     */
    public static void displayDataPlayer(Player p){
        System.out.println(p.getUsername()+" ----- "+p.getCategory().getName()+" \n PV :"+p.getHp()+"\n PA : "+((p.getWeapon()!=null)?p.getWeapon().getAttackPoints():1)+"\n NV : "+p.getLvl() );
    }

    /**
     * Affiche les zones accessibles du joueur
     * @param p le joueur
     */
    public static void displayAccessibleArea(Player p){
        ArrayList<Area> areas =  p.getCurrentArea().getAccessAreas();
        System.out.println("ZONES ACCESSIBLES -------------");
        for (int i=0; i<areas.size(); i++) {
            System.out.println(i + " - " + areas.get(i).getName());
        }
        System.out.println();
    }

    /**
     * @see User.Player#getCurrentArea()
     * @param p
     */
    public static void displayCurrentArea(Player p) {
        System.out.println("CURRENT AREA-------------------");
        System.out.println(p.getCurrentArea().toString());
    }

    /**
     * @see User.Player#getInventory()
     * @see User.Player#displayArmor()
     * @see User.Player#displayWeapon()
     * @param p
     */
    public static void displayInventory(Player p) {
        System.out.println("ARMOR--------------------------");
        p.displayArmor();
        System.out.println("WEAPON-------------------------");
        p.displayWeapon();
        System.out.println("INVENTORY----------------------");
        Inventory listItem = p.getInventory();

        for (int i=0; i<listItem.getItems().size(); i++) {
            System.out.println("- " + listItem.getItemAt(i).toString());
        }
        System.out.println();
    }
    

    /**
     * @see User.Player#moveToLinkedArea(Area)
     * @param p
     * @param idArea
     */
    public static void moveTo(Player p, String idAreaString) {
        try {
            int idAreaInt = Integer.parseInt(idAreaString);
            ArrayList<Area> accessibleAreas =  p.getCurrentArea().getAccessAreas();

            if (0<=idAreaInt && idAreaInt<accessibleAreas.size()) {
                p.moveTo(p.getCurrentArea().getAccessAreas().get(idAreaInt));
                System.out.println(p.getCurrentArea() + "\n");
            } else {
                System.out.println("UserFonction.moveTo(Player, String) : Cette zone n'est pas accessible.\n");
            }

        } catch (NumberFormatException numFormException) {
            System.out.println("executeFunctionInput(ArrayList<String>, Player):moveToLinkedArea(int):" + numFormException);
        }
    }

    /**
     * Lance un combat entre le joueur et un monstre
     * @param p le joueur
     */
    public static boolean fight(Player p){
        Monster m = (Monster)p.getCurrentArea().getEntity();
        if(p.isAlive() && !m.isAlive()){
            return true;
        }else if(!p.isAlive() && m.isAlive()){
            return false;
        }else if(p.isAlive() && m.isAlive()){
            System.out.println("Actions possibles : \n attack()\n displayDataPlayer() \n displayDataMonster()\n");
            try{
                ArrayList<String> action = Console.readAction();
                if(action.get(0).equals("attack")){
                    p.attack(m);
                    if(p.getWeapon()!=null){
                        System.out.println(m.getName()+" a perdu :" +p.getWeapon().getAttackPoints()+" points de vie \n");
                    }else{
                        System.out.println(m.getName()+" a perdu : 1 points de vie \n");
                    }
                }else if(action.get(0).equals("displayDataPlayer")){
                    displayDataPlayer(p);
                    return fight(p);
                }else if(action.get(0).equals("displayDataMonster")){
                    System.out.println(m.getName() +"----- \n HP : "+m.getHp()+"\n PA : "+m.get_attack()+"\n");
                    return fight(p);
                }else{
                    return fight(p);
                }
                if(m.isAlive()){
                    m.attack(p);
                    System.out.println(p.getUsername()+" a perdu "+m.get_attack()+" points de vie \n");
                }
                return fight(p);
            }
            catch(ApplicationException a){
                System.out.println("Erreur : Mauvaise commande entrée.");
                return fight(p);
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Board   board   = Game.generateBoard();
        Player  player  = Game.createPlayer(board.getWorldAt(1));
        displayDataPlayer(player);
        displayAccessibleArea(player);
        displayActions(player);
        /*player.setWeapon(null);

        if(fight(player)){
            System.out.println("GAGNER");
        }else{
            System.out.print("PERDU");
        }*/
    }
}   
