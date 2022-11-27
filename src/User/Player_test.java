package User;

public class Player_test{

    /**
     * Test la fonction d'augmentation et dimininution des points de vies
     * Etat : FONCTIONNELLES
     */
    public static void test_decrease_increase_hp(){
        Player p = new Player("Kateul",Order.COMPUTER_SCIENTIST,null);
        // Test d'increase_hp
        try{
                // 5 donne 105 
            p.increase_hp(5);
            System.out.print("Niveau de vie doit etre 105 : "+p.get_hp()+"\n");
                // -5 renvoie une exception
            p.increase_hp(-5);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage()+"\n");
        }
        // Test de decrease_hp
        try{
                // 100 donne 5
            p.decrease_hp(100);
            System.out.print("Niveau de vie doit etre 5 : "+p.get_hp()+"\n");
            p.decrease_hp(15);
            System.out.println("Niveau de vie doit etre 0 : "+p.get_hp()+"\n");
            p.decrease_hp(10);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage()+"\n");
        }
        try{
            p.increase_hp(10);
            p.decrease_hp(-5);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage()+"\n");
        }
        
    }

    public static void main (String[] args){
        test_decrease_increase_hp();
        Player p = new Player("Kateul",Order.COMPUTER_SCIENTIST,null);
        p.display_player_data();
    }

}