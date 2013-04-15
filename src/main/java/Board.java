import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Integer, FreeCellColumn> columns = new HashMap<Integer, FreeCellColumn>();

    //create goal stacks
    private GoalCell spadeGoal = new GoalCell();
    private GoalCell heartGoal = new GoalCell();
    private GoalCell diamondGoal = new GoalCell();
    private GoalCell clubGoal = new GoalCell();

    private ArrayList<FreeCell> freeCells = new ArrayList<FreeCell>();
    private int numFreecells;

    public Board(int numFreeCells, int numColumns) {
        //Create freecells
        for (int i=0;i<numFreeCells;i++){
            freeCells.add(new FreeCell());
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
            columnToPlace.add(cellToPlace);

            //Wrap around to first column
            if (i == columns.size() - 1){
                i = 0;
            }else{
                i++;
            }
        }
    }

    public void executeMove(FreeCellMove move) {
        Cell newCell = new FieldCell();
        newCell.addCard(move.getOldCell().getCard());
        move.getNewColumn().add(newCell);
        move.getOldCell().removeCard();
    }

    public Map<Integer, FreeCellColumn> getColumns(){
        return columns;
    }

    public ArrayList<FreeCell> getFreeCells() {
        return this.freeCells;
    }

    public int getNumFreecells(){
        return this.numFreecells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //print freecells and goal piles
        for(FreeCell freeCell: freeCells){
            sb.append(freeCell);
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
        board.columns.get(0).add(c1);

        FieldCell c2 = new FieldCell();
        c2.addCard(new Card(Card.Suit.HEART,Card.Value.QUEEN));
        board.columns.get(1).add(c2);
        return board;
    }

}
