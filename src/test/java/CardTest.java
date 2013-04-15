import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CardTest {

    @Test
    public void testEquals() throws Exception {
        Card c1 = new Card(Card.Suit.CLUB, Card.Value.FIVE);
        Card c2 = new Card(Card.Suit.CLUB, Card.Value.FIVE);
        assertTrue(c1.equals(c2));

        Card c3 = new Card(Card.Suit.CLUB, Card.Value.SIX);
        assertFalse(c1.equals(c3));

    }

    @Test
    public void testColor(){
        Card c1 = new Card(Card.Suit.SPADE, Card.Value.ACE);
        assertTrue(c1.getColor() == Card.Color.BLACK);

        Card c2 = new Card(Card.Suit.HEART, Card.Value.ACE);
        assertTrue(c2.getColor() == Card.Color.RED);

        assertFalse(c1.getColor() == c2.getColor());
    }

    @Test
    public void testPrint(){
        Card c1 = new Card(Card.Suit.SPADE, Card.Value.ACE);
        assertTrue(c1.toString().equals("[A"+"♠"+"]"));
    }


}
