import java.util.Scanner;

/**
 * Created by falyanguzov on 09.11.2016.
 */
public abstract class Player {


    private long money;
    private String name;
    Hand hand;
    private Intellect intellect;
    public PlayerState state;

    public Player(Intellect intellect, String name) {
        hand = new Hand();
        this.intellect = intellect;
        this.name = name;
    }


    public void setMoney(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        return intellect.decideWithOverdraft(hand.countScore());
    }
}
