import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class CellTest {
    @Test
    public void testToString() throws Exception {
        Cell myFieldCell = new Cell(Cell.Type.FIELD);
        assertTrue(myFieldCell.toString().equals("[  ]"));

        Cell myFreeCell = new Cell(Cell.Type.FREECELL);
        assertTrue(myFreeCell.toString().equals("[FC]"));

        Cell myGoalCell = new Cell(Cell.Type.GOAL);
        assertTrue(myGoalCell.toString().equals("[GC]"));

        Card aceOfHearts = new Card(Card.Suit.HEART, Card.Value.ACE);
        myGoalCell.addCard(aceOfHearts);
        assertTrue(myGoalCell.toString().equals(aceOfHearts.toString()));

        Card twoOfHearts = new Card(Card.Suit.HEART, Card.Value.TWO);
        myGoalCell.addCard(twoOfHearts);
        assertTrue(myGoalCell.toString().equals(twoOfHearts.toString()));

    }
}
