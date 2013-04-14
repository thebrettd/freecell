import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Board {

    private Map<Integer, ArrayList<Card>> columns = new HashMap<Integer, ArrayList<Card>>();
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


    public Board(int numFreeCells, int numColumns){
        //Create freecells
        for (int i=0;i<numFreeCells;i++){
            this.freeCells.add(new Cell());
            this.numFreecells++;
        }

        //Create columns
        for (int i=0;i<numColumns;i++){
            ArrayList<Card> col = new ArrayList<Card>();
            columns.put(i,col);
        }

        //create discard stacks
        Stack<Card> spadeStack = new Stack<Card>();
        Stack<Card> hearteStack = new Stack<Card>();
        Stack<Card> diamondStack = new Stack<Card>();
        Stack<Card> clubStack = new Stack<Card>();

        //Create deck
        Deck deck = new Deck(1);
        //Shuffle deck
        deck.shuffle();

        //Deal
        int i=0;
        while(deck.size() > 0){
            Card cardToPlace = deck.draw();
            ArrayList<Card> columnToPlace = columns.get(i);
            columnToPlace.add(cardToPlace);

            if (i == numColumns - 1){
                i = 0;
            }else{
                i++;
            }
        }
    }

    public Map<Integer, ArrayList<Card>> getColumns(){
        return columns;
    }

    public ArrayList<Cell> getFreeCells() {
        return this.freeCells;
    }

    public int getNumFreecells(){
        return this.numFreecells;
    }
}
