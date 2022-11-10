package User;
import Entity.*;

/**
 * Order.java
 * Order décrit les différentes classes qu'un joueur peut choisir
 * @author Katel HIGNARD
 */

public enum Order {
/* Constantes*/
    COMPUTER_SCIENTIST(){
        
        @Override
        /**
         * L'informaticien peut changer l'entité qui se trouve dans la même zone que lui aléatoirement
         * @param e
        */
        public void useSpecialAbility(Entity e){
            //TODO
        }
    },
    MATHEMATICIAN(){

        @Override
        /**
         * Le mathematicien peut 
         */
        public void useSpecialAbility(Entity e){
            //TODO
        }
    },
    PHYSICIST(){

        @Override
        /**
         * Le physicien peut
         */
        public void useSpecialAbility(Entity e){
            //TODO
        }
    },
    CHEMIST(){

        @Override
        /**
         * Le chimiste peut
         */
        public void useSpecialAbility(Entity e){
            //TODO
        }
    },
    BIOLOGIST(){

        @Override
        /**
         * Le biologist peut
         */
        public void useSpecialAbility(Entity e){
            //TODO
        }
    };

/**
 * Permet d'utiliser l'abilité spécifique à une classe (Order)
 */
    public abstract void useSpecialAbility(Entity e);
}
