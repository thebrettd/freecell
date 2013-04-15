import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FieldCellTest {
    @Test
    public void testToString() throws Exception {

        FieldCell myFieldCell = new FieldCell();
        assertTrue(myFieldCell.toString().equals("[  ]"));

        Card aceOfHearts = new Card(Card.Suit.HEART, Card.Value.ACE);
        myFieldCell.addCard(aceOfHearts);
        assertTrue(myFieldCell.getMyCard().equals(aceOfHearts));
        assertTrue(myFieldCell.toString().equals(aceOfHearts.toString()));



    }
}
