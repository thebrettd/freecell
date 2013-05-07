import java.util.ArrayList;
import java.util.List;

public class FreeCellSolver {

    public static void main(String[] args) {

        Board b = new Board(4, 8);
        b.deal();

        System.out.println(b.toString());

        List<FieldCellMove> winningMoves = new ArrayList<FieldCellMove>();
        solve(b,winningMoves);

        for(FieldCellMove move: winningMoves){
            System.out.println(move.toString());
        }

    }

    private static boolean solve(Board board, List<FieldCellMove> moves) {

        //winning condition
        if (board.getNumFreecells() == 12) {
            System.out.println("Solved!!");
            return true;
        } else {
            List<FieldCellMove> allValidMoves = getAllValidMoves(board);

            for (FieldCellMove move : allValidMoves) {

                System.out.println("Trying a move");

                moves.add(move);
                board.executeMove(move);

                //If this new configurations leads to a solution, return true, otherwise undo it
                if (solve(board, moves)) {
                    return true;
                } else {
                    moves.remove(move);
                    System.out.println("Got stuck, remove move: " + move);
                    //card.undoMove(move);
                }
            }
        }

        //No valid moves or they did not lead to a solution
        return false;
    }

    private static List<FieldCellMove> getAllValidMoves(Board b) {
        List<FieldCellMove> allValidMoves = new ArrayList<FieldCellMove>();


        //Loop through each column - find each possible move
        //for(ArrayList<Card> columns : b.getColumns().values()){

        //}

        return allValidMoves;

    }

}
