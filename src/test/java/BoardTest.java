import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void boardConstructorTest(){
        Board b = new Board(4,8);

        assertTrue(b.getColumns().get(0).size() == 7);
        assertTrue(b.getColumns().get(1).size() == 7);
        assertTrue(b.getColumns().get(2).size() == 7);
        assertTrue(b.getColumns().get(3).size() == 7);

        assertTrue(b.getColumns().get(4).size() == 6);
        assertTrue(b.getColumns().get(5).size() == 6);
        assertTrue(b.getColumns().get(6).size() == 6);
        assertTrue(b.getColumns().get(7).size() == 6);

        assertTrue(b.getFreeCells().size() == 4);
        assertTrue(b.getNumFreecells() == 4);

    }

    @Test
    public void boardPrintTest(){
        Board b = new Board(4,8);
        b.print();
    }

}
