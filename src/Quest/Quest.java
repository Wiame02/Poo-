package Quest;
import Stuff.*;
/**
 * Quest.java
 * Quest décrit une quête que ce soit tuer un monstre ou recolter un item
 * @author Monique RIMBERT
 */

public abstract class Quest {
    private String title;
    private boolean is_accomplished;
    private Item reward;
    private int bonus_exp;

    public Quest(String title, Item reward, int bonus_exp) {
        this.title = title;
        this.is_accomplished = false;
        this.reward = reward;
        this.bonus_exp = bonus_exp;
    }

    /**
     * Marque une quete comme accomplie
     */
    public abstract void submit();
}
