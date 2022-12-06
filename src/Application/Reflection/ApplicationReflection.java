package Application.Reflection;
import java.lang.reflect.*;
import java.lang.reflect.Constructor;
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
     * @param classAdress
     * @return true Si la classe a été trouvée
     */
    public static boolean doesClassExist (String classAdress) {
        try {
            Class.forName(classAdress);
        }
        catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    } 

    /**
     * Vérifie si deux objets sont de la même classe
     * @param objA 
     * @param objB
     * @return Si les deux objets sont de la même classe
     */
    public static boolean areObjectsFromSameClass (Object objA, Object objB) {        
        return objA.getClass().equals(objB.getClass());
    } 


    /**
     * Donne tous les noms des méthodes public de la classe entree
     * @see https://docs.oracle.com/javase/10/docs/api/java/lang/Class.html#getMethods()
     * @param classAdress Adresse de la Classe sous la forme package.class
     * @return  Une ArrayList de tous les noms
     * @throws ClassNotFoundException La classe n'existe pas ou n'a pas été trouvée
     * @throws SecurityException On ne peut pas acceder aux methodes de la classe
     */
    public static ArrayList<String> getPublicMethodsNames (String classAdress) throws Exception {
        Method[] listOfPublicMethods = {};
        try {
            listOfPublicMethods = Class.forName(classAdress).getMethods();
        }
        catch (Exception e) {
            throw e;
        }

        // On recupere tous les noms des méthodes
        ArrayList<String> listOfPublicMethodsNames = new ArrayList<String> ();
        for (Method m : listOfPublicMethods) {
            listOfPublicMethodsNames.add(m.getName());
        }

        return listOfPublicMethodsNames;
    }

    /**
     * Récupère dans l'ordre la classe de chaque objet présents dans le tableau entrée
     * @param argsObjects Un tableau de plusieurs objets (peuvent être de sous-classe d'java.lang.Object différents)
     * @return Class[] Un tableau regroupant les classes de chaques objets
     */
    public static Class[] getArgumentClasses (Object[] argsObjects) {
        ArrayList<Class> argsClasses = new ArrayList<Class>();

        for (Object obj : argsObjects) {
            argsClasses.add(obj.getClass());
        }
        return argsClasses.toArray(new Class[0]);  //On transforme la liste en un tableau
    }

/**
 * Cette fonction execute une méthode d'instance d'objet à partir de son nom
 * @param obj   L'objet qui sur lequel on appelle la méthode
 * @param methodName Le nom de la méthode
 * @param argsObjects Les parametres d'entrées de la méthode appelée
 * @return La valeur de retour de méthode appellée
 * @throws Exception La méthode n'a pas été trouvée.
 */
    public static Object executeInstanceMethod (Object obj, String methodName, Object[] argsObjects) throws Exception {
        try {
            Object res = null;
            Class[] argsClasses = getArgumentClasses(argsObjects);
            Method methodObj = obj.getClass().getMethod(methodName, argsClasses);

            if (!methodObj.getReturnType().equals(Void.TYPE)) {
                res = methodObj.invoke(obj, argsObjects);
            } else {
                methodObj.invoke(obj, argsObjects);
            }

            return res;
        }
        catch (Exception e) {
            throw new Exception("Application.ApplicationReflection.executeInstanceMethod(...): " + e.getMessage());
        }
    }

    public static Object executeStaticFunction (String className, String methodName, Object[] argsObjects) throws Exception {
        try {
            Object res = null;
            Class[] argsClasses = getArgumentClasses(argsObjects);
            Method function = Class.forName(className).getMethod(methodName, argsClasses);

            if (!function.getReturnType().equals(Void.TYPE)) {
                System.out.println("C'est une procédure !");
                res = function.invoke(null, argsObjects);
            } else {
                System.out.println("C'est une fonction !");
                function.invoke(null, argsObjects);
            }

            return res;
        }
        catch (Exception e) {
            throw new Exception("Application.ApplicationReflection.executeStaticFunction(...): " + e.getMessage());
        }

    }
}
