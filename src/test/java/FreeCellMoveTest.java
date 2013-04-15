import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FreeCellMoveTest {

    @Test
    public void testMove(){
        Board board = Board.getMoveTestBoard();

        Card queenOfHearts = new Card(Card.Suit.HEART, Card.Value.QUEEN);

        FreeCellColumn oldColumn = board.getColumns().get(1);
        Cell oldCell = oldColumn.get(0);
        Card cardToMove = board.getColumns().get(1).get(0).getCard();
        assertTrue(cardToMove.equals(queenOfHearts));

        FreeCellColumn newColumn = board.getColumns().get(0);

        FreeCellMove move = new FreeCellMove(oldCell,newColumn);
        System.out.println("Before:");
        System.out.println(board.toString());

        System.out.println("After:");
        board.executeMove(move);
        System.out.println(board.toString());

        FreeCellColumn col = board.getColumns().get(0);
        assertTrue(col.size() == 2);
        assertTrue(col.get(0).getCard().equals(new Card(Card.Suit.SPADE, Card.Value.KING)));
        assertTrue(col.get(1).getCard().equals(queenOfHearts));

    }

}
