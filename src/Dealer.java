/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Dealer extends Computer {

    private Deck deck;
    private String name;

    public Dealer() {
        super(new DealerIntellect());
        name = "Dealer";
        deck = new Deck(); // готовим карты: создаем их и перемешиваем
    }

    public String getName() {
        return name;
    }

    public void deal(Player player) {
        if (deck.isEmpty()) deck = new Deck();
        Card current = deck.pop();
        player.take(current);
    }
}
