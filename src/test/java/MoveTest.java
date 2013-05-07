import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MoveTest {

    @Test
    public void testFieldCellMove(){
        Board board = Board.getMoveTestBoard();

        Card queenOfHearts = new Card(Card.Suit.HEART, Card.Value.QUEEN);

        FreeCellColumn oldColumn = board.getColumns().get(1);

        List<Cell> cellsToMove = new LinkedList<Cell>();
        cellsToMove.add(board.getColumns().get(1).get(0));
        assertTrue(cellsToMove.get(0).getCard().equals(queenOfHearts));

        FreeCellColumn newColumn = board.getColumns().get(0);

        FieldCellMove move = new FieldCellMove(cellsToMove, oldColumn, newColumn);
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

    @Test
    public void testMoveFieldCellToFreeCell(){
        Board board = Board.getMoveTestBoard();

        Card queenOfHearts = new Card(Card.Suit.HEART, Card.Value.QUEEN);

        FreeCellColumn oldColumn = board.getColumns().get(1);

        List<Cell> cellsToMove = new LinkedList<Cell>();
        cellsToMove.add(board.getColumns().get(1).get(0));
        assertTrue(cellsToMove.get(0).getCard().equals(queenOfHearts));

        FreeCellColumn newColumn = board.getFreeCells().get(0);

        ToFreeCellMove move = new ToFreeCellMove(cellsToMove, oldColumn, newColumn);
        System.out.println("Before:");
        System.out.println(board.toString());

        System.out.println("After:");
        board.executeMove(move);
        System.out.println(board.toString());

        FreeCellColumn col = board.getColumns().get(0);
        assertTrue(col.size() == 1);
        assertTrue(col.get(0).getCard().equals(new Card(Card.Suit.SPADE, Card.Value.KING)));

        assertTrue(board.getFreeCells().get(0).size() ==1 );
        assertTrue(board.getFreeCells().get(0).get(0).getCard().equals(queenOfHearts));

    }

}
