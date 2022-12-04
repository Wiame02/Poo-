package Application;
import Localization.*;
import User.*;
import Entity.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe qui permet le déroulement et la création du jeu
 * @author Monique RIMBERT
 * @author Katel HIGNARD
 */

public class Game {
    /**
     * Choisi aléatoirement un boss final parmi les entitées présentes dans ce monde
     * @param world Le monde entré en modification
     */
    public static void chooseBoss(World world, ArrayList<Monster> monsters){
            int i = (int) (Math.random()*(monsters.size()-1));
            world.setBoss(monsters.get(i));
    }

    /**
     * Génère un nombre aléatoire entre [0, max[
     * @param maxExcluded
     * @return un entier entre [0, max[
     */
    public static int generateRandomNumber (int maxExcluded) {
        double computedDouble = Math.random()*1000;
        int randomNumber = ((int) computedDouble)%maxExcluded;

        return randomNumber;
    }

    /**
     * Génère aléatoirement les entitées dans les zones du monde
     * @param world Le monde entré en modification
     */
    public static void generateAreas(World world, ArrayList<Entity> entities){
        for (Entity e : entities) { 
            int i = generateRandomNumber(world.getAreas().size());  //Un entier entre 0 et le nombre de zones dans le monde-1

            while (world.getAreaAt(i).getEntity()!=null) {
                i = generateRandomNumber(world.getAreas().size());
            }

            world.getAreaAt(i).setEntity(e);
        }
    }

    /**
     * Génération du plateau du jeu grâce au données obtenues
     * @return le plateau construit
     */
    public static Board generateBoard(){
        Board b = new Board();
        b.addAllWorlds(DataWorlds.DATA_WORLDS);

        for (int i=0; i<b.getWorlds().size()-1; i++) {
            generateAreas(b.getWorldAt(i+1), DataVillager.DATA_ENTITIES.get(i));
            chooseBoss(b.getWorldAt(i+1), DataMonsters.DATA_MONSTERS.get(i));
        }
        return b;
    }

    /**
     * Retourne la classe selon un entier d'entrée
     * @param i un entier entre 1 et 5
     * @return la classe choisie
     */
    private static Order correspondingOrder(int i){
        if(i==1){return Order.COMPUTER_SCIENTIST;}
        else if(i==2){return Order.MATHEMATICIAN;}
        else if(i==3){return Order.PHYSICIST;}
        else if(i==4){return Order.CHEMIST;}
        else{return Order.BIOLOGIST;}  
    }

    /**
     * Création du personnage du joueur
     * @param w Le premier monde
     * @return le personnage du joueur
     */
    public static Player createPlayer(World w){
        Scanner sc = new Scanner(System.in);

        System.out.println("Comment t'appelles-tu ? ");
        String pseudo = sc.nextLine();

        System.out.println("Quelle spécialité souhaitez-vous avoir ? \n 1.Informaticien \n 2.Mathématicien \n 3.Physicien \n 4.Chimiste \n 5.Biologiste \n");
        int choice = Integer.parseInt(sc.nextLine());

        while(choice<1 && choice>5){
            System.out.println("Erreur : valeur non incluse entre 1 et 5.\n Quelle spécialité souhaitez-vous avoir ? \n 1.Informaticien \n 2.Mathématicien \n 3.Physicien \n 4.Chimiste \n 5.Biologiste \n");
            choice = Integer.parseInt(sc.nextLine());
        }

        sc.close();

        Player p = new Player(pseudo, correspondingOrder(choice), w.getAreaAt(0));

        return p;
    }

    /**
     * Execute la fontion qui a été entrée
     * @param func La fonction entrée avec son parametre sous forme de tableau
     * @throws GameException La fonction entrée soit n'est pas valide soit son paramètre ne l'est pas
     */
    public static void executeFunctionInput(ArrayList<String> func, Player p) {






        /*
                try {
            System.out.println("executeFunctionInput()");
            ArrayList<String> args = (ArrayList<String>) func.clone();
            args.remove(0);
            for (String a : args) {
                System.out.println("element : " + a);
            }

            if (Application.Reflection.ApplicationReflection.getPublicMethodsNames("Application.Console").contains(func.get(0))) {
                System.out.println("Does the function exist ? : True");
                Object[] argsTab = {p};
                Application.Reflection.ApplicationReflection.executeStaticFunction("Application.Console", func.get(0), argsTab);
            } else {
                System.out.println("Does the function exist ? : False");
            }
            
        }
        catch (Exception e) {
            System.out.println("executeFunctionInput() :: " + e);
        }
        if (func.get(0).equals("showAvailableActions")) {
            Console.showAvailableActions(p);
        }else if (func.get(0).equals("moveLinkedArea")) {
            try {
                p.moveToLinkedarea(p.getCurrentArea().getAccessArea("Champs"));
            } catch (Exception e) {
                System.out.println(e);
            }
        }*/
    }

    /**
     * Permet l'execution d'une entree du joueur
     * @param player Le joueur
     */
    public static void doAnAction(Player player) {
        try {
            ArrayList<String> input = Console.readAction();
            System.out.println("main:doAnAction()");
            executeFunctionInput(input, player);
        }
        catch (Exception e) {
	        System.out.println("Error in playerDoAction() : " + e);
            doAnAction(player);
        }
    }

    /**
     * Vérifie s'il ne reste aucun boss vivant dans les mondes
     * @param board
     * @return true si tous les boss sont morts
     */
    public static boolean areAllBossesDead(Board board) {
        boolean are_dead = true;
        int i = 1;
        while (i<board.getWorlds().size() && are_dead) {
            are_dead = !board.getWorldAt(i).getBoss().isAlive();
            i++;
        }
        return are_dead;
    }

    /**
     * Déroulement du jeu
     */
    public static void playGame() {
        Board   board   = generateBoard();
        Player  player  = createPlayer(board.getWorldAt(1)); 

        boolean areAllBossesDead = false;
        
        Console.showAvailableActions(player);

        while (!areAllBossesDead && player.isAlive()) {
            //TODO showAvailableActions(...); Peut-être n'afficher que les actions si le joueur le demande et s'il change de zone.
            doAnAction(player);

            areAllBossesDead = areAllBossesDead(board);
            if (areAllBossesDead) {
                System.out.println("BOSS MORTS !");
            } else {
                System.out.println("Les boss ne sont pas tous mort !");
            }
        }

        if (player.isAlive()) {
            Console.gameSuccessEnding(player);
        } else {
            Console.gameOverEnding(player);
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
