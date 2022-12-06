package Application.Reflection;
import java.util.ArrayList;
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
    
    protected static Villager testVillager = new Villager("nameForTestVillager", 8);
    protected static World w = new World("TestWorld", Period.FUTURE);
    public static Area a1 = new Area("Area1", w);
    protected static Area a2 = new Area("Area2", w);
    protected static Player testPlayer = new Player("TestPlayer", Order.CHEMIST, a1);

    /**
     * Test de la fontion doesClassExist(...)
     * @see Application.ApplicationReflection#doesClassExist()
     */
    private static void testDoesClassExist () {
        System.out.println("\n\n________________________testDoesClassExist()_______________________");
        System.out.println("(package different->FAUX)               <Board> existe ? " + ApplicationReflection.doesClassExist("Board"));
        System.out.println("(meme package->FAUX)                    <Console> existe ? " + ApplicationReflection.doesClassExist("Console"));
        System.out.println("(classe qui contient la fonction->FAUX) <ApplicationReflection> existe ? " + ApplicationReflection.doesClassExist("ApplicationReflection"));
        System.out.println("(classe avec addresse relative->VRAI)   <Quest.QuestKillMonster> existe ? " + ApplicationReflection.doesClassExist("Quest.QuestKillMonster"));
    }

    private static void testGetPublicMethods () {
        System.out.println("\n\n________________________testGetPublicMethods()_______________________");
        try {
            System.out.println("(classe avec addresse relative)   <User.Player>");
            ArrayList<String> listMethodsName = ApplicationReflection.getPublicMethodsNames("User.Player");
            
            for (String s : listMethodsName) {
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

    public static void testExecuteInstanceMethod () {
        try {
            Object[] args = {};
            System.out.println("executeInstanceMethod(testVillager,\"getName\", {}) >> " + ApplicationReflection.executeInstanceMethod(testVillager,"getName", args)+ "\n\n");        
            Object[] argsV2 = {a2};
            System.out.println("Current area before : " + testPlayer.getCurrentArea().toString());
            System.out.println("executeInstanceMethod(testPlayer,\"move_to\", {a2}) >> " + ApplicationReflection.executeInstanceMethod(testPlayer,"move_to", argsV2) + "\n\n");
            System.out.println("Current area after : " + testPlayer.getCurrentArea().toString());
        }
        catch (Exception e) {
            System.out.println( "Dans testExecuteInstanceMethod : " + e);
        }
    } 

    public static void testAreSameClass() {
        Villager v1 = new Villager("TestVillager1", 9);
        Villager v2 = new Villager("TestVillager2", 9);
        Monster m = new Monster("TestMonster", 100, Species.DJIN, 100);

        if (ApplicationReflection.areObjectsFromSameClass(v1, m)) {
            System.out.println(v1.getName() + " et " + m.getName() + " sont de la même classe !");
        } else {
            System.out.println(v1.getName() + " et " + m.getName() + " NE sont PAS de la même classe !");
        }

        if (ApplicationReflection.areObjectsFromSameClass(v1, v2)) {
            System.out.println(v1.getName() + " et " + v2.getName() + " sont de la même classe !");
        } else {
            System.out.println(v1.getName() + " et " + v2.getName() + " NE sont PAS de la même classe !");
        }

    }


    public static void testExecuteReadFunction () {
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
            System.out.println("Application.testExecuteReadFunction: " + e);
        }
    }





    public static void main(String[] args) {
        //testDoesClassExist();
        //testGetPublicMethods();
        //testExecuteInstanceMethod();
        //testExecuteReadFunction();
        testAreSameClass();
    }
}