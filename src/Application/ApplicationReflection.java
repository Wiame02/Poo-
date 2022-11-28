package Application;
import java.lang.reflect.*;
import java.lang.ClassNotFoundException;
import java.util.ArrayList;

/**
 * Classe qui utilise la Reflection, elle ne comporte que des fonctions de classe
 * Seulement elle peut manipuler les classes, fonctions, méthodes etc... à partir de la librairie
 * @author Monique RIMBERT
 * @see https://www.oracle.com/technical-resources/articles/java/javareflection.html
 * @see https://www.baeldung.com/java-method-reflection#1-instance-methods
 */
public class ApplicationReflection {

    /**
     * Cherche si une classe existe en utilisant l'exception ClassNotFoundException à partir de l'adresse de la Classe
     * @see https://docs.oracle.com/javase/10/docs/api/java/lang/Class.html#forName(java.lang.String)
     * @param class_name
     * @return true Si la classe a été trouvée
     */
    public static boolean does_class_exist (String class_adress) {
        try {
            Class.forName(class_adress);
        }
        catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    } 

    /**
     * Donne tous les noms des méthodes public de la classe entree
     * @see https://docs.oracle.com/javase/10/docs/api/java/lang/Class.html#getMethods()
     * @param class_adress Adresse de la Classe sous la forme package.class
     * @return  Une ArrayList de tous les noms
     * @throws ClassNotFoundException La classe n'existe pas ou n'a pas été trouvée
     * @throws SecurityException On ne peut pas acceder aux methodes de la classe
     */
    public static ArrayList<String> get_public_methods_names (String class_adress) throws Exception {
        Method[] list_of_public_methods = {};
        try {
            list_of_public_methods = Class.forName(class_adress).getMethods();
        }
        catch (Exception e) {
            throw e;
        }

        // On recupere tous les noms
        ArrayList<String> list_of_methods_names = new ArrayList<String> ();
        for (Method m : list_of_public_methods) {
            list_of_methods_names.add(m.getName());
        }

        return list_of_methods_names;
    }

    /**
     * Récupère dans l'ordre la classe de chaque objet présents dans le tableau entrée
     * @param args_object Un tableau de plusieurs objets (peuvent être de sous-classe d'java.lang.Object différents)
     * @return Class[] Un tableau regroupant les classes de chaques objets
     */
    public static Class[] get_argument_classes (Object[] args_object) {
        ArrayList<Class> args_classes = new ArrayList<Class>();

        for (Object obj : args_object) {
            args_classes.add(obj.getClass());
        }
        return args_classes.toArray(new Class[0]);  //On transforme la liste en un tableau
    }

/**
 * Cette fonction execute une méthode d'instance d'objet à partir de son nom
 * @param obj   L'objet qui sur lequel on appelle la méthode
 * @param method_name Le nom de la méthode
 * @param args_object Les parametres d'entrées de la méthode appelée
 * @return La valeur de retour de méthode appellée
 * @throws Exception La méthode n'a pas été trouvée.
 */
    public static Object execute_instance_method (Object obj, String method_name, Object[] args_object) throws Exception {
        try {
            Class class_obj = obj.getClass();
            Class[] args_classes = get_argument_classes(args_object);
            Method method_obj = class_obj.getMethod(method_name, args_classes);
            Object res = method_obj.invoke(obj, args_object);

            return res;
        }
        catch (Exception e) {
            throw new Exception("Application.ApplicationReflection.execute_instance_method(...): " + e.getMessage());
        }
    }

}
