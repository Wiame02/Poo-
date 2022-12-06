package Application;
import java.util.ArrayList;
import Entity.*;
import User.*;
import Localization.*;

public class UserFonction {
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
        player.setWeapon(null);

        if(fight(player)){
            System.out.println("GAGNER");
        }else{
            System.out.print("PERDU");
        }
    }
}
