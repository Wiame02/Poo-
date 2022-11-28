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

    public static void test_execute_instance_method () {
        try {
            Villager test_Villager = new Villager("nameForTestVillager", 8);
            Object[] args = {};
            System.out.println("execute_instance_method(test_Villager,\"get_name\", {}) >> " + ApplicationReflection.execute_instance_method(test_Villager,"get_name", args)+ "\n\n");        

            World w = new World("TestWorld", Period.FUTURE);
            Area a1 = new Area("Area1", w);
            Area a2 = new Area("Area2", w);
            Player test_player = new Player("TestPlayer", Order.CHEMIST, a1);
            Object[] args_v2 = {a2};
            System.out.println("Current area before : " + test_player.get_current_area().to_string());
            System.out.println("execute_instance_method(test_player,\"move_to\", {a2}) >> " + ApplicationReflection.execute_instance_method(test_player,"move_to", args_v2) + "\n\n");
            System.out.println("Current area after : " + test_player.get_current_area().to_string());
        }
        catch (Exception e) {
            System.out.println( "Dans test_execute_instance_method : " + e);
        }
    } 


    public static void main(String[] args) {
        //test_does_class_exist();
        //test_get_public_methods();
        test_execute_instance_method();
    }
}