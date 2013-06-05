import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GoalCellTest {

    @Test
    public void testGoalCell(){
        Card aceOfHearts = new Card(Card.Suit.HEART, Card.Value.ACE);

        GoalCell myGoalCell = new GoalCell(Card.Suit.HEART);
        assertTrue(myGoalCell.toString().equals("[G" + '\u2665'  + "]"));

        myGoalCell.addCard(aceOfHearts);
        assertTrue(myGoalCell.toString().equals(aceOfHearts.toString()));

        Card twoOfHearts = new Card(Card.Suit.HEART, Card.Value.TWO);
        myGoalCell.addCard(twoOfHearts);
        assertTrue(myGoalCell.toString().equals(twoOfHearts.toString()));
    }



}
