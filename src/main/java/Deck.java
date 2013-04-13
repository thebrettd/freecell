import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck {

    private  Stack<Card> cards = new Stack<Card>();
    private int shoeSize;

    public Deck(int shoeSize) {
        this.shoeSize = shoeSize;
        for (int i = 0; i < shoeSize; i++) {
            for (Card.Suit s : Card.Suit.values()) {
                for (Card.Value v : Card.Value.values()) {
                    Card c = new Card(s, v);
                    cards.push(c);
                }
            }
        }
    }

    public void shuffle() {
        List<Card> cardsToShuffle = new ArrayList<Card>();
        for (Card c : cards) {
            cardsToShuffle.add(c);
        }

        this.cards = new Stack<Card>();
        int count = cardsToShuffle.size();
        for (int i = 0; i < count; i++) {
            int randomCardNumber = (int) (Math.random() * cardsToShuffle.size());
            cards.push(cardsToShuffle.remove(randomCardNumber));
        }
    }


    public int size() {
        return cards.size();
    }

    public Card draw() {
        return cards.pop();
    }

    public void replace(Card c){
        cards.push(c);
    }


}
