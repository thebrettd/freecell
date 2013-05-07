import java.util.List;

public abstract class Move {

    protected List<Cell> cardsToMove;
    protected FreeCellColumn oldColumn;
    protected FreeCellColumn newColumn;

    Move(List<Cell> cardsToMove, FreeCellColumn oldColumn, FreeCellColumn newColumn) {
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

    public List<Cell> getCardsToMove() {
        return cardsToMove;
    }

    public FreeCellColumn getOldColumn() {
        return oldColumn;
    }

    public FreeCellColumn getNewColumn() {
        return newColumn;
    }
}





