import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FreeCellTest {

    @Test
    public void testFreeCell(){

        FreeCell myFreeCell = new FreeCell();
        assertTrue(myFreeCell.toString().equals("[FC]"));

        Card aceOfHearts = new Card(Card.Suit.HEART, Card.Value.ACE);
        myFreeCell.addCard(aceOfHearts);
        assertTrue(myFreeCell.toString().equals(aceOfHearts.toString()));

    }
}
