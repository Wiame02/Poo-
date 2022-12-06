package Application;
import java.util.ArrayList;
import Entity.*;
import User.*;
import Localization.*;

public class UserFonction {
    /* */

    // TODO : getCurrentArea()
    // TODO : displayInventory()

    public static void displayActions(Player p){
        System.out.println("ACTIONS -----------------------");
        System.out.println("displayDataPlayer()");
        System.out.println("displayInventory()");
        System.out.println("displayCurrentArea()");
        System.out.println("moveTo()");
        
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
     * @see User.Player#moveToLinkedArea(Area)
     * @param p
     * @param idArea
     */
    public static void moveToLinkedArea(Player p, int idArea) {
        ArrayList<Area> areas =  p.getCurrentArea().getAccessAreas();
        
        if (0<=idArea && idArea<areas.size()) {
            p.moveTo(p.getCurrentArea().getAccessAreas().get(idArea));
        }
        System.out.println(p.getCurrentArea() + "\n");
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
                    p.displayPlayerData();
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
