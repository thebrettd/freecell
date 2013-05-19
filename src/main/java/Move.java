import java.util.List;

public class Move {

    protected List<Card> cardsToMove;  //The list of cells containing the cards you want to move
    protected FreeCellColumn oldColumn;
    protected FreeCellColumn newColumn;

    Move(List<Card> cardsToMove, FreeCellColumn oldColumn, FreeCellColumn newColumn) {
        this.cardsToMove = cardsToMove;
        this.oldColumn = oldColumn;
        this.newColumn = newColumn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Moved stack starting with: ").append(cardsToMove.get(0));

        return sb.toString();
    }

    public List<Card> getCardsToMove() {
        return cardsToMove;
    }

    public FreeCellColumn getOldColumn() {
        return oldColumn;
    }

    public FreeCellColumn getNewColumn() {
        return newColumn;
    }
}





