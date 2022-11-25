package Application;

/**
 * Classe qui gère les exceptions spécifiques au package Application
 * @author Monique RIMBERT
 */

class ApplicationException extends Exception {
    
    /**
     * Creation d'une exception de type GameException
     * @param message Message de l'erreur
     */
    public ApplicationException(String message) {
        super(message);
    }
}