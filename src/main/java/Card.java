import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public String toString() {
        Character value = valuePrintMap.get(this.getValue());
        Character suit = suitPrintMap.get(this.getSuit());

        return "[" + value + suit + "]";
    }

    public static Character suitToString(Card.Suit suit){
        return suitPrintMap.get(suit);
    }

    private static final Map<Value,Character> valuePrintMap;
    static {
        Map<Value,Character> m = new HashMap<Value,Character>();
        m.put(Value.ACE,'A');
        m.put(Value.TWO,'2');
        m.put(Value.THREE,'3');
        m.put(Value.FOUR,'4');
        m.put(Value.FIVE,'5');
        m.put(Value.SIX,'6');
        m.put(Value.SEVEN,'7');
        m.put(Value.EIGHT,'8');
        m.put(Value.NINE,'9');
        m.put(Value.TEN,'T');
        m.put(Value.JACK,'J');
        m.put(Value.QUEEN,'Q');
        m.put(Value.KING,'K');

        valuePrintMap = Collections.unmodifiableMap(m);
    }

    private static final Map<Suit,Character> suitPrintMap;
    static {
        Map<Suit,Character> m = new HashMap<Suit,Character>();
        m.put(Suit.SPADE,'\u2660');
        m.put(Suit.HEART,'\u2665');
        m.put(Suit.DIAMOND,'\u2666');
        m.put(Suit.CLUB,'\u2663');
        //m.put(Suit.SPADE,'S');
        //m.put(Suit.HEART,'H');
        //m.put(Suit.DIAMOND,'D');
        //m.put(Suit.CLUB,'C');

        suitPrintMap = Collections.unmodifiableMap(m);
    }


}
