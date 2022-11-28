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

    public static Class[] get_argument_classes (Object[] argument) {
        return Class[];
    }





    public static Object execute_function (Object obj, String method_name, Object[] arguments) throws Exception {
        try {
            Class c = obj.getClass();
            System.out.println("Classe : " + c);

            ArrayList< > args_classes = new ArrayList<Class>();

            for (Object o : arguments) {
                if (o==null) {throw new Exception("NULLL POINYER EXCEPTION");} 
                args_classes.add(o.getClass());
                System.out.println("args_classes[] : " + o);
            }

            Method m = c.getMethod(method_name, args_classes.toArray(new Class[0]));
            System.out.println("Methode : " + m);
            System.out.println("Argument : " + arguments.toString());
            Object res = m.invoke(obj, arguments);
            return res;
        }
        catch (Exception e) {
            System.out.println("Dans execute_function : " + e);
            throw e;
        }
    }

}
