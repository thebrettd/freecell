public class FreeCellMove {

    private Cell oldCell;
    private FreeCellColumn newColumn;
    private Card card;

    FreeCellMove(Cell oldCell, FreeCellColumn newColumn){
        this.oldCell = oldCell;
        this.newColumn = newColumn;
        this.card = oldCell.getCard();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Moved Card: ").append(card.toString());

        return sb.toString();
    }

    public Cell getOldCell() {
        return oldCell;
    }

    public FreeCellColumn getNewColumn() {
        return newColumn;
    }
}
