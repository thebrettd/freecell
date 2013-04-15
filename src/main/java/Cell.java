import java.util.Stack;

public class Cell {

    public static enum Type{ FIELD, FREECELL, GOAL}

    private Type myType;
    private Stack<Card> myCard = new Stack<Card>();

    public Stack<Card> getMyCard() {
        return myCard;
    }

    public void addCard(Card card){
        myCard.push(card);
    }

    public Cell(Type type){
        this.myType = type;
    }

    public Type getMyType() {
        return myType;
    }

    //Return the top card on the stack on empty symbol
    @Override
    public String toString(){
        return myCard.size() > 0 ? myCard.peek().toString() : getCellSymbol(this.myType);
    }

    private String getCellSymbol(Type myType) {
        switch(myType){
            case FIELD: return "[  ]";
            case FREECELL: return "[FC]";
            case GOAL: return "[GC]";
            default:
                throw new IllegalStateException("Unknown cell type");
        }
    }


}
