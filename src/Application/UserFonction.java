package Application;
import Entity.*;
import User.*;

public class UserFonction {
    
    public static void fight(Player p,Monster m){
        while(p.isAlive() && m.isAlive()){
            System.out.println("Actions possibles : \n attack("+m.getName());

            if(m.isAlive()){
                m.attack(p);
            }
        }
    }
}
