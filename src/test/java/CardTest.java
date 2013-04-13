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


}
