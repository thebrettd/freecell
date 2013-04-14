import java.util.ArrayList;

public class FreeCellColumn extends ArrayList<Card> {

    public void print(int rowNum) {
        if (this.size() == 0 && rowNum == 0)
            System.out.print("[ ]");
        else if (this.size() > rowNum)
            System.out.print("[" + this.get(rowNum).toString() + "]");
    }
}
