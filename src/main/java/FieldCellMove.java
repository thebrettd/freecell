import java.util.List;

public class FieldCellMove extends Move {

    FieldCellMove(List<Cell> cardsToMove, FreeCellColumn oldColumn, FreeCellColumn newColumn) {
        super(cardsToMove, oldColumn, newColumn);
    }
}
