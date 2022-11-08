package User;

/**
 * Order.java
 * Order décrit les différentes classes qu'un joueur peut choisir
 * @author Katel HIGNARD
 */

public enum Order {
/* Constantes*/
    COMPUTER_SCIENTIST(){
        
        @Override
        public void useSpecialAbility(){
            //TODO
        }
    };
/* Attribus */

/* Constructeurs */

/* Méthodes */

    /**
     * Permet d'utiliser l'abilité spécifique à une classe (Order)
     */
    public abstract void useSpecialAbility();
}
