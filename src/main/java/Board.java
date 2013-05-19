import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private Map<Integer, FreeCellColumn> columns = new HashMap<Integer, FreeCellColumn>();

    //create goal stacks
    private final GoalCell spadeGoal = new GoalCell(Card.Suit.SPADE);
    private final GoalCell heartGoal = new GoalCell(Card.Suit.HEART);
    private final GoalCell diamondGoal = new GoalCell(Card.Suit.DIAMOND);
    private final GoalCell clubGoal = new GoalCell(Card.Suit.CLUB);
    private List<GoalCell> myGoalCells = new ArrayList<GoalCell>();
    {
        myGoalCells.add(spadeGoal);
        myGoalCells.add(heartGoal);
        myGoalCells.add(diamondGoal);
        myGoalCells.add(clubGoal);
    }

    private ArrayList<FreeCellColumn> freeCellColumns = new ArrayList<FreeCellColumn>();
    private int numFreecells;

    public Board(int numFreeCells, int numColumns) {
        //Create freecells
        for (int i=0;i<numFreeCells;i++){
            FreeCellColumn freeCellColumn = new FreeCellColumn();
            freeCellColumns.add(freeCellColumn);
            this.numFreecells++;
        }

        //Create columns
        for (int i=0;i<numColumns;i++){
            FreeCellColumn col = new FreeCellColumn();
            columns.put(i,col);
        }
    }

    public void deal(){
        //Create deck
        Deck deck = new Deck(1);
        //Shuffle deck
        deck.shuffle();

        //Deal
        int i=0;
        while(deck.size() > 0){
            Card cardToPlace = deck.draw();
            FreeCellColumn columnToPlace = columns.get(i);

            FieldCell cellToPlace = new FieldCell();
            cellToPlace.addCard(cardToPlace);
            columnToPlace.add(cellToPlace.getCard());

            //Wrap around to first column
            if (i == columns.size() - 1){
                i = 0;
            }else{
                i++;
            }
        }
    }

    public void executeMove(Move move) {
        move.getOldColumn().removeAll(move.getCardsToMove());
        move.getNewColumn().addAll( move.getCardsToMove());
    }

    public Map<Integer, FreeCellColumn> getColumns(){
        return columns;
    }

    public ArrayList<FreeCellColumn> getFreeCells() {
        return this.freeCellColumns;
    }

    public int getNumFreecells(){
        return this.numFreecells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //print freecells and goal piles
        for(FreeCellColumn freeCell: freeCellColumns){
            sb.append(freeCell.toString(0));
        }

        sb.append(spadeGoal);
        sb.append(heartGoal);
        sb.append(diamondGoal);
        sb.append(clubGoal);

        sb.append("\n");

        //Print out the first row and find the longest column
        int rowNum = 0;
        int maxRowNum = 0;
        for(FreeCellColumn column : columns.values()){
            sb.append(column.toString(rowNum));
            maxRowNum = column.size() > maxRowNum ? column.size() : maxRowNum;
        }
        sb.append("\n");
        rowNum++;

        //If there is a column more than 1 card deep, keep printing
        while(rowNum < maxRowNum){
            for(FreeCellColumn column : columns.values()){
                sb.append(column.toString(rowNum));
            }
            rowNum++;
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Board getMoveTestBoard() {
        Board board = new Board(4, 8);

        FieldCell c1 = new FieldCell();
        c1.addCard(new Card(Card.Suit.SPADE,Card.Value.KING));
        board.columns.get(0).add(c1.getCard());

        FieldCell c2 = new FieldCell();
        c2.addCard(new Card(Card.Suit.HEART,Card.Value.QUEEN));
        board.columns.get(1).add(c2.getCard());

        FieldCell c3 = new FieldCell();
        c3.addCard(new Card(Card.Suit.SPADE, Card.Value.JACK));
        board.columns.get(2).add(c3.getCard());

        FieldCell c4 = new FieldCell();
        c4.addCard(new Card(Card.Suit.CLUB,Card.Value.KING));
        return board;

    }

    public boolean isSolved(){
        for(GoalCell gc : myGoalCells){
            if (gc.getCard() == null || !gc.getCard().equals(new Card(gc.getMySuit(),Card.Value.KING)))
                return false;
        }

        //All of the cards in the goal cells are Kings
        return true;

    }

}
