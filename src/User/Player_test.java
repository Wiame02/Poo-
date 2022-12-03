package User;

public class Player_test{

    /**
     * Test la fonction d'augmentation et dimininution des points de vies
     * Etat : FONCTIONNELLES
     */
    public static void testDecreaseIncreaseHp(){
        Player p = new Player("Kateul",Order.COMPUTER_SCIENTIST,null);
        // Test d'increaseHp
        try{
                // 5 donne 105 
            p.increaseHp(5);
            System.out.print("Niveau de vie doit etre 105 : "+p.getHp()+"\n");
                // -5 renvoie une exception
            p.increaseHp(-5);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage()+"\n");
        }
        // Test de decreaseHp
        try{
                // 100 donne 5
            p.decreaseHp(100);
            System.out.print("Niveau de vie doit etre 5 : "+p.getHp()+"\n");
            p.decreaseHp(15);
            System.out.println("Niveau de vie doit etre 0 : "+p.getHp()+"\n");
            p.decreaseHp(10);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage()+"\n");
        }
        try{
            p.increaseHp(10);
            p.decreaseHp(-5);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage()+"\n");
        }
        
    }

    public static void main (String[] args){
        testDecreaseIncreaseHp();
        Player p = new Player("Kateul",Order.COMPUTER_SCIENTIST,null);
        p.displayPlayerData();
    }

}