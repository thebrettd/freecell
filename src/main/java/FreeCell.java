import java.util.Stack;

public class FreeCell implements Cell {

    private Stack<Card> myCard = new Stack<Card>();

    public void addCard(Card card){
        if (myCard.size() >= 1){
            throw new IllegalStateException("Cannot add another card to this FreeCell");
        }
        myCard.push(card);
    }

    @Override
    public Card getCard() {
        return myCard.peek();
    }

    @Override
    public void removeCard() {
        myCard.pop();
    }

    //Return the top card on the stack or empty symbol
    @Override
    public String toString(){
        return myCard.size() == 1 ? myCard.peek().toString() : "[FC]";
    }

}
