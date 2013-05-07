import java.util.List;

public class ToFreeCellMove extends Move {
    ToFreeCellMove(List<Cell> cardsToMove, FreeCellColumn oldColumn, FreeCellColumn newColumn) {
        super(cardsToMove, oldColumn, newColumn);
    }
}
