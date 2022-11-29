package Application.Reflection;
import java.util.ArrayList;
import java.io.ObjectInputStream.GetField;
import java.lang.Class;
import java.lang.reflect.Field;

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
     * Variable de tests
     */
    
    protected static Villager test_Villager = new Villager("nameForTestVillager", 8);
    protected static World w = new World("TestWorld", Period.FUTURE);
    public static Area a1 = new Area("Area1", w);
    protected static Area a2 = new Area("Area2", w);
    protected static Player test_player = new Player("TestPlayer", Order.CHEMIST, a1);

    /**
     * Test de la fontion doesClassExist(...)
     * @see Application.ApplicationReflection#doesClassExist()
     */
    private static void test_does_class_exist () {
        System.out.println("\n\n________________________test_does_class_exist()_______________________");
        System.out.println("(package different->FAUX)               <Board> existe ? " + ApplicationReflection.doesClassExist("Board"));
        System.out.println("(meme package->FAUX)                    <Console> existe ? " + ApplicationReflection.doesClassExist("Console"));
        System.out.println("(classe qui contient la fonction->FAUX) <ApplicationReflection> existe ? " + ApplicationReflection.doesClassExist("ApplicationReflection"));
        System.out.println("(classe avec addresse relative->VRAI)   <Quest.QuestKillMonster> existe ? " + ApplicationReflection.doesClassExist("Quest.QuestKillMonster"));
    }

    private static void test_get_public_methods () {
        System.out.println("\n\n________________________test_get_public_methods()_______________________");
        try {
            System.out.println("(classe avec addresse relative)   <User.Player>");
            ArrayList<String> l_m_n = ApplicationReflection.getPublicMethodsNames("User.Player");
            
            for (String s : l_m_n) {
                System.out.println("    > " + s + "(...);");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println("(classe non-existante)   <Giberrish>");
            ArrayList<String> vide = ApplicationReflection.getPublicMethodsNames("Giberrish");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void test_execute_instance_method () {
        try {
            Object[] args = {};
            System.out.println("executeInstanceMethod(test_Villager,\"get_name\", {}) >> " + ApplicationReflection.executeInstanceMethod(test_Villager,"get_name", args)+ "\n\n");        
            Object[] args_v2 = {a2};
            System.out.println("Current area before : " + test_player.get_current_area().toString());
            System.out.println("executeInstanceMethod(test_player,\"move_to\", {a2}) >> " + ApplicationReflection.executeInstanceMethod(test_player,"move_to", args_v2) + "\n\n");
            System.out.println("Current area after : " + test_player.get_current_area().toString());
        }
        catch (Exception e) {
            System.out.println( "Dans test_execute_instance_method : " + e);
        }
    } 


    public static void test_execute_read_function () {
        try {
            //ArrayList<String> read_function = Console.read_action();
            Class c = new TestReflection().getClass();
            Field[] field = c.getFields();

            for (Field f : field) {
                System.out.println(f.toString());       
            }

            Object obj = field[0].get(field);
            System.out.println("Object is : " + obj.toString());
        }
        catch (Exception e) {
            System.out.println("Application.test_execute_read_function: " + e);
        }
    }





    public static void main(String[] args) {
        //test_does_class_exist();
        //test_get_public_methods();
        test_execute_instance_method();
        //test_execute_read_function();
    }
}