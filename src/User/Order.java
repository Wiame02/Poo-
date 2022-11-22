package User;
import Localization.*;
import Entity.*;

/**
 * Order.java
 * Order décrit les différentes classes qu'un joueur peut choisir
 * @author Katel HIGNARD
 */

public enum Order {
/* Constantes*/
    COMPUTER_SCIENTIST(){
        
        /**
         * L'informaticien peut changer l'entité qui se trouve dans la même zone que lui aléatoirement
         * @param e
        */
        public void useSpecialAbility(World world, Area area){
            int id_change = (int)(Math.random() *((world.get_areas().size() + 1)));
            Entity tmp = world.get_area_at(id_change).get_entity();
            world.get_area_at(id_change).set_entity(area.get_entity());
            area.set_entity(tmp);
        }
    },
    MATHEMATICIAN(){

        /**
         * Le mathematicien peut 
         */
        public void useSpecialAbility(){
            //TODO
        }
    },
    PHYSICIST(){

        /**
         * Le physicien peut se déplacer dans unz zone sans contraintes
         */
        public void useSpecialAbility(Player p,Area destination){
            p.move_to(destination);
        }
    },
    CHEMIST(){

        /**
         * Le chimiste peut
         */
        public void useSpecialAbility(){
            //TODO
        }
    },
    BIOLOGIST(){

        /**
         * Le biologist peut
         */
        public void useSpecialAbility(){
            //TODO
        }
    };
}
