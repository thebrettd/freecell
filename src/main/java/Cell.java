public interface Cell {

    @Override
    public String toString();

    public void addCard(Card card);

    public Card getCard();

    void removeCard();
}
