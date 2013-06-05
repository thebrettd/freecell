import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FreeCellGame {

    private Board board;

    public FreeCellGame(Board board){
        this.board = board;
    }

    public static void main(String[] args){
        newGame();
    }

    private static void newGame() {
        FreeCellGame game = new FreeCellGame(new Board(4, 8));
        game.getBoard().deal();

        System.out.println(game);

        do{
            Move attemptedMove = game.readMove();
            if(isValidMove(attemptedMove)){
                game.getBoard().executeMove(attemptedMove);
                System.out.println(game);
            }
            else{
                System.out.println("Invalid move");
            }
        }
        while (!game.board.isSolved());


    }

    private static boolean isValidMove(Move attemptedMove) {
        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    public Move readMove() {
        InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;

        Move move = null;
        try{
            System.out.print("Enter old column index: ");
            int oldColumnIndex = Integer.parseInt(bufRead.readLine());
            FreeCellColumn oldColumn = this.board.getColumns().get(oldColumnIndex);

            System.out.println("\t  Enter card index: ");
            int cardIndex = Integer.parseInt(bufRead.readLine());
            Card card = oldColumn.get(cardIndex);

            System.out.println("Enter new column index: ");
            int newColumnIndex = Integer.parseInt(bufRead.readLine());

            FreeCellColumn newColumn = this.board.getColumns().get(newColumnIndex);

            List<Card> cardsToMove = new LinkedList<Card>();
            cardsToMove.add(card);
            move = new Move(cardsToMove,oldColumn,newColumn);
        }catch(IOException err) {
            System.out.println("Error reading move");
        }

        return move;
    }

    public Board getBoard(){
        return board;
    }

    @Override
    public String toString(){
        return board.toString();
    }

}
