import java.util.ArrayList;
import java.util.List;

public class FreeCellSolver {

    public static void main(String[] args) {

        Board b = new Board(4, 8);
        b.deal();

        System.out.println(b.toString());

        List<FreeCellMove> winningMoves = new ArrayList<FreeCellMove>();
        solve(b,winningMoves);

        for(FreeCellMove move: winningMoves){
            System.out.println(move.toString());
        }

    }

    private static boolean solve(Board board, List<FreeCellMove> moves) {

        //winning condition
        if (board.getNumFreecells() == 12) {
            System.out.println("Solved!!");
            return true;
        } else {
            List<FreeCellMove> allValidMoves = getAllValidMoves(board);

            for (FreeCellMove move : allValidMoves) {

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

    private static List<FreeCellMove> getAllValidMoves(Board b) {
        List<FreeCellMove> allValidMoves = new ArrayList<FreeCellMove>();


        //Loop through each column - find each possible move
        //for(ArrayList<Card> columns : b.getColumns().values()){

        //}

        return allValidMoves;

    }

}
