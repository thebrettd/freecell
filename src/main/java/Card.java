public class Card {

    public static enum Value
    { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public static enum Suit
    { SPADE, HEART, DIAMOND, CLUB }

    public static enum Color
    { BLACK, RED}

    private Suit suit;
    private Value value;
    private Color color;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
        if (this.suit == Suit.CLUB || this.suit == Suit.SPADE){
            this.color = Color.BLACK;
        }else{
            this.color = Color.RED;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public boolean equals(Card c){
        return this.suit == c.suit && this.value == c.value;

    }
}
