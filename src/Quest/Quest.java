package Quest;
import Stuff.*;
import Localization.*;
import User.*;

/**
 * Quest.java
 * Quest décrit une quête que ce soit tuer un monstre ou recolter un item
 * @author Monique RIMBERT
 */

public abstract class Quest {
    protected String title;
    protected boolean is_accomplished;
    protected Item reward;
    protected int bonus_exp;

    public Quest(String title, Item reward, int bonus_exp) {
        this.title = title;
        this.is_accomplished = false;
        this.reward = reward;
        this.bonus_exp = bonus_exp;
    }

    /**
     * Marque une quete comme accomplie
     */
    public abstract void submit(Player p);
}
