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
    
    public static void fight(Player p,Monster m){
        while(p.isAlive() && m.isAlive()){
            System.out.println("Actions possibles : \n attack("+m.getName());

            if(m.isAlive()){
                m.attack(p);
            }
        }
    }
}
