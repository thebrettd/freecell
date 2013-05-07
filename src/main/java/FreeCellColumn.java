import java.util.LinkedList;

//todo: would using a linked list make moving groups of cards faster (ie only need to move the root node/card)?
public class FreeCellColumn extends LinkedList<Cell> {

    public String toString(int rowNum) {
        StringBuilder sb = new StringBuilder();

        if (this.size() == 0 && rowNum == 0)
            sb.append("[  ]");
        else if (this.size() > rowNum)
            sb.append(this.get(rowNum));

        return sb.toString();
    }

}
