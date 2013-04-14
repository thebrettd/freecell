import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Board {

    private Map<Integer, FreeCellColumn> columns = new HashMap<Integer, FreeCellColumn>();
    private ArrayList<Cell> freeCells = new ArrayList<Cell>();
    private int numFreecells;



    private class Cell{
        private Card myCard;

        private Card getMyCard() {
            return myCard;
        }

        private void setMyCard(Card myCard) {
            this.myCard = myCard;
        }

        private Cell(){
        }
    }


    public Board(int numFreeCells, int numColumns) {
        //Create freecells
        for (int i=0;i<numFreeCells;i++){
            this.freeCells.add(new Cell());
            this.numFreecells++;
        }

        //Create columns
        for (int i=0;i<numColumns;i++){
            FreeCellColumn col = new FreeCellColumn();
            columns.put(i,col);
        }

        //create discard stacks
        Stack<Card> spadeStack = new Stack<Card>();
        Stack<Card> hearteStack = new Stack<Card>();
        Stack<Card> diamondStack = new Stack<Card>();
        Stack<Card> clubStack = new Stack<Card>();
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
            columnToPlace.add(cardToPlace);

            if (i == columns.size() - 1){
                i = 0;
            }else{
                i++;
            }
        }
    }

    public void executeMove(FreeCellMove move) {
        move.targetColumn.add(move.card);
        move.oldColumn.remove(move.card);
    }

    public Map<Integer, FreeCellColumn> getColumns(){
        return columns;
    }

    public ArrayList<Cell> getFreeCells() {
        return this.freeCells;
    }

    public int getNumFreecells(){
        return this.numFreecells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //print freecells and discard piles

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

        board.columns.get(0).add(new Card(Card.Suit.SPADE,Card.Value.KING));
        board.columns.get(1).add(new Card(Card.Suit.HEART,Card.Value.QUEEN));
        return board;
    }

}
