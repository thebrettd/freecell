import java.util.Stack;

public class GoalCell implements Cell {

    private Stack<Card> myCards = new Stack<Card>();

    @Override
    public void addCard(Card card) {
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
        return myCards.size() > 0 ? myCards.peek().toString() : "[GC]";
    }


}
