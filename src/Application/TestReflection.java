package Application;
import java.util.ArrayList;
import Entity.*;
import Localization.*;
import User.Order;
import User.Player;

/**
 * Test pour la reflection afin d'avoir une meilleure comprehension de cette classe
 * @author Monique RIMBERT
 */

public class TestReflection {
    /**
     * Test de la fontion does_class_exist(...)
     * @see Application.ApplicationReflection#does_class_exist(String class_adress)
     */
    private static void test_does_class_exist () {
        System.out.println("\n\n________________________test_does_class_exist()_______________________");
        System.out.println("(package different->FAUX)               <Board> existe ? " + ApplicationReflection.does_class_exist("Board"));
        System.out.println("(meme package->FAUX)                    <Console> existe ? " + ApplicationReflection.does_class_exist("Console"));
        System.out.println("(classe qui contient la fonction->FAUX) <ApplicationReflection> existe ? " + ApplicationReflection.does_class_exist("ApplicationReflection"));
        System.out.println("(classe avec addresse relative->VRAI)   <Quest.QuestKillMonster> existe ? " + ApplicationReflection.does_class_exist("Quest.QuestKillMonster"));
    }

    private static void test_get_public_methods () {
        System.out.println("\n\n________________________test_get_public_methods()_______________________");
        try {
            System.out.println("(classe avec addresse relative)   <User.Player>");
            ArrayList<String> l_m_n = ApplicationReflection.get_public_methods_names("User.Player");
            
            for (String s : l_m_n) {
                System.out.println("    > " + s + "(...);");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println("(classe non-existante)   <Giberrish>");
            ArrayList<String> vide = ApplicationReflection.get_public_methods_names("Giberrish");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void test_execute_function () {
        try {
            Villager test_Villager = new Villager("nameForTestVillager", 8);
            Area a1 = new Area("Area1", null);
            Area a2 = new Area("Area2", null);
            Player test_player = new Player("TestPlayer", Order.CHEMIST, a1);
            Object[] args = {};
            Object[] args_v2 = {a2};
            System.out.println("execute_function(test_Villager,\"get_name\", {}) >> " + ApplicationReflection.execute_function(test_Villager,"get_name", args));
            System.out.println("execute_function(test_player,\"move_to\", {a2}) >> " + ApplicationReflection.execute_function(test_player,"move_to", args_v2));
        }
        catch (Exception e) {
            System.out.println( "Dans test_execute_function : " + e);
        }
    } 


    public static void main(String[] args) {
        //test_does_class_exist();
        //test_get_public_methods();
        test_execute_function();
    }
}