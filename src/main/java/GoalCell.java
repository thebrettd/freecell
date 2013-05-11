import java.util.Stack;

public class GoalCell implements Cell {

    private Stack<Card> myCards = new Stack<Card>();
    private Card.Suit mySuit;

    public GoalCell(Card.Suit mySuit) {
        this.mySuit = mySuit;
    }

    @Override
    public void addCard(Card card) {
        if (card.getSuit() != mySuit) throw new IllegalStateException("Card and Goal Suit do not match");
        myCards.push(card);
    }

    @Override
    public Card getCard() {
        return myCards.peek();
    }

    @Override
    public void removeCard() {
        throw new IllegalStateException("Tried to remove card from goal");
    }

    @Override
    public String toString(){
        return myCards.size() > 0 ? myCards.peek().toString() : "[GC" + Card.suitToString(mySuit) +"]";
    }


    public Card.Suit getMySuit() {
        return mySuit;
    }
}
