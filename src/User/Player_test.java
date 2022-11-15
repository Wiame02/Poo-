package User;

public class Player_test{

    public static void main (String[] args){
        Area first_area = new Area("first_one");
        Area last_area = new Area("last_one");
        Player p = new Player("Kateul",PHYSICIST,first_area);

        p.category.useSpecialAbility(p,last_area);
        System.out.println(p.get_current_area.name);
    }

}