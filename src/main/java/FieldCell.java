public class FieldCell implements Cell {

    private Card myCard;

    @Override
    public void addCard(Card card) {
        this.myCard = card;
    }

    @Override
    public Card getCard() {
        return myCard;
    }

    @Override
    public void removeCard() {
        myCard = null;
    }

    @Override
    public String toString(){
        return myCard != null ? myCard.toString() : "";
    }

    public Card getMyCard(){
        return myCard;
    }

}
