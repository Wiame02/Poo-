package Application.Reflection;
import java.lang.NoSuchFieldException;

/**
 * Cette interface permet de récupérer touts les champs qui décrivent un classe particulière
 * Contrairement à {@link java.lang.Class#getFields()}, elle nous permettra de connaitre les champs qui sont privés
 * Qui plus est, on récupère immédiatement un objet au lieu d'un {@link java.lang.reflect.Field}.
 * @author Monique RIMBERT
 * @see https://www.oracle.com/technical-resources/articles/java/javareflection.html
 * @see https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getFields--
 */
public interface ClassInformation {
    /**
     * Retourne tous les objets aux champs d'une Classe, qu'elle soit privée ou public.
     * @return Un tableau d'{@link java.lang.Object} qui représente les champs d'une {@link java.lang.Class}.
     */
    public Object[] getFields();

    /**
     * Retourne l'objet au champ de la Classe selon le nom du champ.
     * @param fieldName Correspond au nom du champs que l'on appelle.
     * @return {@link java.lang.Object} correspondant à l'object enregistré à ce champ.
     * @throws NoSuchFieldException Si le nom du champ donné ne correspond à aucun des champs que la classe contient.
     */
    public Object getField (String fieldName) throws NoSuchFieldException;

    /**
     * Modifie le champs représenté avec son nom en la valeur donnée.
     * @param fieldName Le nom du champs de la classe qui doit être modifiée.
     * @param setValue  La valeur qui remplacement l'ancienne.
     * @throws NoSuchFieldException Si le nom du champ donné ne correspond à aucun des champs que la classe contient.
     */
    public void setField (String fieldName, Object setValue) throws Exception;
}