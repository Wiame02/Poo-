package Application;
import Localization.*;
import User.*;
import Entity.*;
import Entity.Species;
import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.print("Comment t'appelles-tu ? \n>> ");
        String pseudo = sc.nextLine();
        System.out.println(">>> " + pseudo);

        System.out.print("Quelle spécialité souhaitez-vous avoir ? \n 1.Informaticien \n 2.Mathématicien \n 3.Physicien \n 4.Chimiste \n 5.Biologiste \n>> ");
        String choice = sc.nextLine();
        String[] validEntry = {"1", "2", "3", "4", "5"};

        while(!(Arrays.asList(validEntry).contains(choice))){
            System.out.print("Erreur : valeur non incluse entre 1 et 5.\n Quelle spécialité souhaitez-vous avoir ? \n 1.Informaticien \n 2.Mathématicien \n 3.Physicien \n 4.Chimiste \n 5.Biologiste \n>> ");
            choice = sc.nextLine();
        }

        Player p = new Player(pseudo, correspondingOrder(Integer.parseInt(choice)), w.getAreaAt(0));
        return p;
    }

    /**
     * Execute la fontion qui a été entrée
     * @param func La fonction entrée avec son parametre sous forme de tableau
     * @param p le joueur
     * @param b le plateau
     * @throws GameException La fonction entrée soit n'est pas valide soit son paramètre ne l'est pas
     */
    public static void executeFunctionInput(ArrayList<String> func, Player p, Board b) {
        if (func.get(0).equals("displayCurrentArea")) {
            UserFonction.displayCurrentArea(p);
            
        } else if (func.get(0).equals("displayInventory")) {
            UserFonction.displayInventory(p);

        } else if (func.get(0).equals("moveTo")) {
            if (func.size()==2) {
                UserFonction.moveTo(p, func.get(1));
            } else {
                System.out.println("executeFunctionInput:UserFonction:moveTo(String) : A besoin d'un paramètre.");
            }

        } else if (func.get(0).equals("displayActions")) {
            UserFonction.displayActions(p);

        } else if (func.get(0).equals("displayDataPlayer")) {
            UserFonction.displayDataPlayer(p);

        } else if (func.get(0).equals("displayAccessibleArea")) {
            UserFonction.displayAccessibleArea(p);
        }else if(!p.getCurrentArea().getWorld().getBoss().isAlive() && func.get(0).equals("changeWorld")){ 
            UserFonction.changeWorld(b, p);
        }else if (p.getCurrentArea().getEntity().getSpecies().equals(Species.VILLAGER) && func.get(0).equals("interact")) {
            p.interact((Villager) p.getCurrentArea().getEntity());

        }  else if (!p.getCurrentArea().getEntity().getSpecies().equals(Species.VILLAGER) && func.get(0).equals("fight")) {
            if(((Monster)p.getCurrentArea().getEntity()).isBoss(p.getCurrentArea().getWorld())){
                System.out.println("Ce monstre dégage une aura particulière ! Il s'agit du boss de "+p.getCurrentArea().getWorld().getName());
            }
            if(UserFonction.fight(p)){
                System.out.println("Vous avez gagner les combat contre "+p.getCurrentArea().getEntity().getName());
            }

        }




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
    public static void doAnAction(Player player, Board board) {
        try {
            ArrayList<String> input = Console.readAction();
            executeFunctionInput(input, player,board);
        }
        catch (Exception e) {
	        System.out.println("Error in doAnAction() : " + e);
            doAnAction(player,board);
        }
    }

    /**
     * Vérifie s'il ne reste aucun boss vivant dans les mondes
     * @param board
     * @return true si tous les boss sont morts
     */
    public static boolean areAllBossesDead(Board board) {
        boolean areDead = true;
        int i = 1;
        while (i<board.getWorlds().size() && areDead) {
            areDead = !board.getWorldAt(i).getBoss().isAlive();
            i++;
        }
        return areDead;
    }

    public static void chooseWorld(Board board,Player p){
        if(p.getCurrentArea().getWorld().getBoss()==null || !p.getCurrentArea().getWorld().getBoss().isAlive()){
            System.out.print("Souvaitez vous partir du monde ? (Y/N)\n");
            Scanner sc = new Scanner(System.in);

            String rep = sc.nextLine();
            if(!rep.equals("Y") && !rep.equals("N")){
                System.out.println("Veuillez répondre avec Y ou N. Souhaitez-vous partir du monde ? ");
                rep = sc.nextLine();
            }
            if(rep.equals("Y")){
                System.out.println("Voici les mondes : \n");
                for(World w : board.getWorlds()){
                    if(w.getBoss()!=null){
                        System.out.println(w.getName());
                    }
                }
                System.out.print("\n");
                System.out.println("Dans quel monde souhaitez vous aller ? ");
                rep = sc.nextLine();
                while(!rep.equals(board.getWorldAt(1).getName()) && !rep.equals(board.getWorldAt(2).getName()) && !rep.equals(board.getWorldAt(3).getName())){
                    System.out.println("Veuillez entrez le nom d'un monde tel qu'il est écrit au dessus. Dans quel monde souhaitez vous aller ? ");
                    rep = sc.nextLine();
                }
                
                if(rep.equals(board.getWorldAt(1).getName())){
                    p.moveTo(board.getWorldAt(1).getAreaAt(0));
                }else if(rep.equals(board.getWorldAt(2).getName())){
                    p.moveTo(board.getWorldAt(2).getAreaAt(0));
                }else if(rep.equals(board.getWorldAt(3).getName())){
                    p.moveTo(board.getWorldAt(3).getAreaAt(0));
                }
                System.out.println("Bienvenue dans le monde de "+p.getCurrentArea().getWorld().getName()+"\n\n");

            }
        }
    }

    /**
     * Déroulement du jeu
     */
    public static void playGame() {
        Board   board   = generateBoard();
        Player  player  = createPlayer(board.getWorldAt(0)); 
        
        Console.beginGame(player);

        boolean areAllBossesDead = false;
    
        UserFonction.displayActions(player);

        while (!areAllBossesDead && player.isAlive()) {
            chooseWorld(board, player);
            System.out.println("displayActions()");
            doAnAction(player,board);

            areAllBossesDead = areAllBossesDead(board);
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
