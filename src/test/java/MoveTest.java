import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class MoveTest {

    /***
     * Move a card from a FieldCell to a FieldCell
     * Move queen of hearts to king of spades
     * (See test board)
     */
    @Test
    public void testMoveOneCardToFieldCell(){
        Board board = Board.getMoveTestBoard();
        Move move = moveQueenToKing(board);

        System.out.println("Before:");
        System.out.println(board.toString());

        System.out.println("After:");
        //Move queen of hearts onto king of spades
        board.executeMove(move);
        System.out.println(board.toString());

        FreeCellColumn col = board.getColumns().get(0);
        assertTrue(col.size() == 2);
        assertTrue(col.get(0).equals(new Card(Card.Suit.SPADE, Card.Value.KING)));
        assertTrue(col.get(1).equals(new Card(Card.Suit.HEART, Card.Value.QUEEN)));

    }

    /***
     *
     */
    @Test
    public void testMoveTwoCardsToFieldCell(){
        Board board = Board.getMoveTestBoard();
        moveQueenToKing(board);
        moveJackToQueen(board);

        board.toString();

    }

    private Move moveJackToQueen(Board board) {
        //Jack of spades
        FreeCellColumn oldColumn = board.getColumns().get(2);

        //Queen of hearts
        FreeCellColumn newColumn = board.getColumns().get(0);

        List<Card> cardsToMove = new ArrayList<Card>();
        cardsToMove.add(oldColumn.get(0));

        return new Move(cardsToMove, oldColumn, newColumn);

    }

    private Move moveQueenToKing(Board board) {
        //Queen of hearts
        FreeCellColumn oldColumn = board.getColumns().get(1);

        //King of spades
        FreeCellColumn newColumn = board.getColumns().get(0);

        List<Card> cardsToMove = new ArrayList<Card>();
        cardsToMove.add(oldColumn.get(0));

        return new Move(cardsToMove , oldColumn, newColumn);
    }

    /***
     *  Move a card from a FieldCell to a FreeCell
     */
    @Test
    public void testMoveOneCardToFreeCell(){
        Board board = Board.getMoveTestBoard();

        Card queenOfHearts = new Card(Card.Suit.HEART, Card.Value.QUEEN);

        FreeCellColumn oldColumn = board.getColumns().get(1);

        List<Card> cellsToMove = new LinkedList<Card>();
        cellsToMove.add(board.getColumns().get(1).get(0));
        assertTrue(cellsToMove.get(0).equals(queenOfHearts));

        FreeCellColumn newColumn = board.getFreeCells().get(0);

        Move move = new Move(cellsToMove, oldColumn, newColumn);
        System.out.println("Before:");
        System.out.println(board.toString());

        System.out.println("After:");
        board.executeMove(move);
        System.out.println(board.toString());

        FreeCellColumn col = board.getColumns().get(0);
        assertTrue(col.size() == 1);
        assertTrue(col.get(0).equals(new Card(Card.Suit.SPADE, Card.Value.KING)));

        assertTrue(board.getFreeCells().get(0).size() ==1 );
        assertTrue(board.getFreeCells().get(0).get(0).equals(queenOfHearts));

    }

}
