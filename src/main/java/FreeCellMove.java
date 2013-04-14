public class FreeCellMove {

    Card card;
    FreeCellColumn targetColumn;
    FreeCellColumn oldColumn;

    FreeCellMove(Card card, FreeCellColumn newColumn, FreeCellColumn oldColumn){
        this.card = card;
        this.targetColumn = newColumn;
        this.oldColumn = oldColumn;
    }

}
