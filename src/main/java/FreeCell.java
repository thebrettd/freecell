public class FreeCell implements Cell {

    private Card myCard;

    public void addCard(Card card){
        myCard = card;
    }

    @Override
    public Card getCard() {
        return myCard;
    }

    @Override
    public void removeCard() {
        myCard = null;
    }

    //Return the top card on the stack on empty symbol
    @Override
    public String toString(){
        return myCard != null ? myCard.toString() : "[FC]";
    }

}
