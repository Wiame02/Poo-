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
    COMPUTER_SCIENTIST("Informaticien.ne"){
        
        /**
         * L'informaticien peut changer l'entité qui se trouve dans la même zone que lui aléatoirement
         * @param world
         * @param area
        */
        @SuppressWarnings("unused")
        public void useSpecialAbility(World world, Area area){
            int idChange = (int)(Math.random() *((world.getAreas().size() + 1)));
            Entity tmp = world.getAreaAt(idChange).getEntity();
            world.getAreaAt(idChange).setEntity(area.getEntity());
            area.setEntity(tmp);
        }
    },
    MATHEMATICIAN("Mathematicien.ne"){

        /**
         * Le mathematicien peut transformer son armure de telle sorte qu'il encaisse tout les dégats et renvoie une partie des degats au monstre
         * En contrepartie, l'armure aura sa durabilité drastiquement réduite.
         * @param armor
         */
        @SuppressWarnings("unused")
        public void useSpecialAbility(Armor armor){
            armor.setDurability(3);
            armor.setDefensePoint(150);
        }
    },
    PHYSICIST("Physicien.ne"){

        /**
         * Le physicien peut se déplacer dans une zone sans contraintes
         * @param p
         * @param destination
         */
        @SuppressWarnings("unused")
        public void useSpecialAbility(Player p,Area destination){
            p.moveTo(destination);
        }
    },
    CHEMIST("Chimiste"){

        /**
         * Le chimiste peut se soigner 
         * @param p
         */
        @SuppressWarnings("unused")
        public void useSpecialAbility(Player p){
            p.setHp((int)(p.getHp()*1.75));
        }
    },
    BIOLOGIST("Biologiste"){

        /**
         * Le biologiste peut reduire l'attaque d'un monstre
         * @param e 
         */
        @SuppressWarnings("unused")
        public void useSpecialAbility(Monster e){
            e.setAttack((int)(e.get_attack()*0.6));
        }
    };

    private String name ;

    /**
     * Constructeur
     * @param name le nom de la classe
     */
    private Order(String name){
        this.name= name;
    }

    public String getName(){return this.name;}
}
