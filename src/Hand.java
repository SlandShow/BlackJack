import java.util.LinkedList;

/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Hand extends LinkedList<Card> {

    private Rate rate;

    public void setHumanRate(Player player, int v) {
        if (player instanceof Human)
            rate = new HumanRate(v);
    }


    public void setComputerRate(Player player, int v) {
        if (player instanceof Computer)
            rate = new HalfRate(v);
    }

    public Rate getRate() {
        return rate;
    }

    public int countScore() {
        int sum = 0;
        for (Card c : this)
            sum += c.getScore();
        if (this.hasAce() && sum + 10 <= 21)
            sum += 10;
        return sum;
    }

    private boolean hasAce() {
        return this.indexOf(new Card(Suit.SPADES, Value.ACE)) >= 0;
    }

    public void clear() {
        while (this.size() > 0) this.pop();
    }
}
