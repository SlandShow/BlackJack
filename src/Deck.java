import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Deck extends LinkedList<Card> {

    public Deck() {
        // заполнение карт
        for(Suit s: Suit.values())
            for(Value v: Value.values())
                this.add(new Card(s, v));
        // рандомно мешаем карты
        Collections.shuffle(this);
    }

}
