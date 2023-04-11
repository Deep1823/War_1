package warcardgame;
import warcardgame.Card;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffle(ArrayList<Card> x) {
        Collections.shuffle(x);
    }

    public int size() {
        return cards.size();
    }

    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }
}
