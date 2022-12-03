package User;
import Localization.*;
import Stuff.Armor;
import Entity.*;

/**
 * Order.java
 * Order décrit les différentes classes qu'un joueur peut choisir
 * @author Katel HIGNARD
 */

public enum Order {
/*
 * Constantes
 */
    COMPUTER_SCIENTIST(){
        
        /**
         * L'informaticien peut changer l'entité qui se trouve dans la même zone que lui aléatoirement
         * @param world
         * @param area
        */
        public void useSpecialAbility(World world, Area area){
            int idChange = (int)(Math.random() *((world.getAreas().size() + 1)));
            Entity tmp = world.getAreaAt(idChange).getEntity();
            world.getAreaAt(idChange).setEntity(area.getEntity());
            area.setEntity(tmp);
        }
    },
    MATHEMATICIAN(){

        /**
         * Le mathematicien peut transformer son armure de telle sorte qu'il encaisse tout les dégats et renvoie une partie des degats au monstre
         * En contrepartie, l'armure aura sa durabilité drastiquement réduite.
         * @param armor
         */
        public void useSpecialAbility(Armor armor){
            armor.setDurability(3);
            //TODO : armor.setDefensePoint(150);
        }
    },
    PHYSICIST(){

        /**
         * Le physicien peut se déplacer dans une zone sans contraintes
         * @param p
         * @param destination
         */
        public void useSpecialAbility(Player p,Area destination){
            p.moveTo(destination);
        }
    },
    CHEMIST(){

        /**
         * Le chimiste peut se soigner 
         * @param p
         */
        public void useSpecialAbility(Player p){
            p.setHp((int)(p.getHp()*1.75));
        }
    },
    BIOLOGIST(){

        /**
         * Le biologiste peut reduire l'attaque d'un monstre
         * @param e 
         */
        public void useSpecialAbility(Monster e){
            e.setAttack((int)(e.get_attack()*0.6));
        }
    };
}
