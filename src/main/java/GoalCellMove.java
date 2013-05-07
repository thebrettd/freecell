import java.util.List;

public class GoalCellMove extends Move {
    GoalCellMove(List<Cell> cardsToMove, FreeCellColumn oldColumn, FreeCellColumn newColumn) {
        super(cardsToMove, oldColumn, newColumn);
    }
}
