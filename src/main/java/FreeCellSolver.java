import java.util.ArrayList;
import java.util.List;

public class FreeCellSolver {

    public static void main(String[] args) {

        Board b = new Board(4, 8);
        b.deal();

        System.out.println(b.toString());

        List<Move> winningMoves = new ArrayList<Move>();
        solve(b,winningMoves);

        for(Move move: winningMoves){
            System.out.println(move.toString());
        }

    }

    private static boolean solve(Board board, List<Move> moves) {

        //winning condition
        if (board.isSolved()) {
            System.out.println("Solved!!");
            return true;
        } else {
            List<Move> allValidMoves = getAllValidMoves(board);

            for (Move move : allValidMoves) {

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

    private static List<Move> getAllValidMoves(Board b) {
        List<Move> allValidMoves = new ArrayList<Move>();


        //Loop through each column - find each possible move
        //for(ArrayList<Card> columns : b.getColumns().values()){

        //}

        return allValidMoves;

    }

}
