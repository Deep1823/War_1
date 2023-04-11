
package warcardgame;
import warcardgame.Deck;
import warcardgame.Card;
import java.util.ArrayList;

public class Distributor extends Deck {

    private ArrayList<Card> compDeck=  new ArrayList<>();
    private ArrayList<Card> playerDeck = new ArrayList<>();
    private ArrayList<Card> distributor = new ArrayList<>();

    public ArrayList<Card> getCompDeck() {
        return compDeck;
    }

    public void setCompDeck(ArrayList<Card> compDeck) {
        this.compDeck = compDeck;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<Card> playerDeck) {
        this.playerDeck = playerDeck;
    }

    public ArrayList<Card> getDistributor() {
        return distributor;
    }

    public void setDistributor(ArrayList<Card> distributor) {
        this.distributor = distributor;
    }


    public Distributor(){
        distribute();
        compDeck();
        playerDeck();
    }

    public void distribute() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card card = new Card(suit, rank);
                
                distributor.add(card);
            }
        }
        super.shuffle(distributor);
    }
 
    public void compDeck(){
        for(int i = 0; i<distributor.size()/2;i++){
            compDeck.add(distributor.get(i));
        }
    }
    public void playerDeck(){
        for(int i = distributor.size()/2; i<distributor.size();i++){
            playerDeck.add(distributor.get(i));
        }
    }




}
