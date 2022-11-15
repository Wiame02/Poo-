package User;

public class Player_test{

    /**
     * Test la fonction d'augmentation et dimininution des points de vies
     */
    public static void test_decrease_increase_hp(){
        Player p = new Player("Kateul",null,null);

        // Tests - 5 donne 105; -5 renvoie une exception
        p.increase_hp(5);
        System.out.print("Niveau de vie doit etre 105"+p.get_hp());
    }


    public static void main (String[] args){
        test_decrease_increase_hp();
    }

}