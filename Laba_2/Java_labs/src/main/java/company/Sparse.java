package company;

public class Sparse {
    private final int r;
    private final int c;
    private int v;

    @Override
    public String toString() {
        return "Sparse{" +
                "r=" + r +
                ", c=" + c +
                ", v=" + v +
                '}';
    }

    public Sparse(int row, int column, int val) {
        r = row;
        c = column;
        v = val;
    }

    public boolean find(int i, int j) {
        return i == r && j == c;
    }

    public int getElement() {
        return v;
    }

    public void setElement(int val) {
        v = val;
    }

    public int getRow() {
        return r;
    }

    public int getColumn() {
        return c;
    }
}
