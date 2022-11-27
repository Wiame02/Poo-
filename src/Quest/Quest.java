package Quest;
import Stuff.*;
import User.*;

/**
 * Quest.java
 * Quest décrit une quête que ce soit tuer un monstre ou recolter un item
 * @author Monique RIMBERT
 * @author Katel HIGNARD
 */

public abstract class Quest {
    protected String title;
    protected boolean is_accomplished;
    protected Item reward;
    protected int bonus_exp;

    public Quest(String title, int bonus_exp) {
        this.title = title;
        this.is_accomplished = false;
        this.reward = null;
        this.bonus_exp = bonus_exp;
    }

    /*
     * GETTERS
     */
    public String get_title(){return this.title;}
    public boolean is_accomplished(){return this.is_accomplished;}
    public Item get_reward(){return this.reward;}
    public int get_bonus_exp(){return this.bonus_exp;}

    /*
     * SETTERS
     */
    public void set_title(String title){this.title=title;}
    public void set_reward(Item reward){this.reward=reward;}
    public void set_bonus_exp(int exp){this.bonus_exp=exp;}

    /**
     * Si la quête est accomplie, change l'attribus is_accomplished en true sinon le laisse a false
     */
    public abstract void submit(Player p);
}
