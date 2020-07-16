package company.matrix;

import company.Sparse;

import java.util.LinkedList;
import java.util.ListIterator;


public class SparseMatrix implements IMatrix {


    private final LinkedList<Sparse> matrix;
    private final int rows;
    private final int column;


    public SparseMatrix(int row, int column) {
        this.rows = row;
        this.column = column;
        matrix = new LinkedList<>();

    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumn() {
        return column;
    }


    @Override
    public void setElement(int row, int column, int value) {
        if (row >= this.rows || column >= this.column || row < 0 || column < 0)
            throw new RuntimeException("Incorrect input");

        if (matrix.size() == 0)
            this.matrix.addFirst(new Sparse(row, column, value));
        ListIterator<Sparse> iter = matrix.listIterator();
        Sparse temp;
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.find(row, column)) {
                if (value == 0) {
                    iter.remove();
                    return;
                }
                temp.setElement(value);
            }
            if ((temp.getRow() == row && temp.getColumn() > column) || temp.getRow() > row) {
                iter.add(new Sparse(row, column, value));
                return;
            }
        }
        this.matrix.addLast(new Sparse(row, column, value));
    }


    @Override
    public int getElement(int row, int column) {
        if (row >= this.rows || column >= this.column || row < 0 || column < 0)
            throw new RuntimeException("Incorrect input");
        for (Sparse temp : matrix) {
            if (temp.find(row, column)) return temp.getElement();
        }
        return 0;
    }

    public String toString() {
        StringBuilder res = new StringBuilder(this.column * this.rows);
        for (int i = 0; i < this.rows; ++i) {

            for (int j = 0; j < this.column; ++j) {

                    res.append(this.getElement(i, j)).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }



    public IMatrix sum(IMatrix matrix) {
        if (this.getRows() != matrix.getRows() || this.getColumn() != matrix.getColumn()) {
            throw new RuntimeException("Matrices have different sizes");
        }
        IMatrix temp = new SparseMatrix(this.getRows(), matrix.getColumn());
        int res = 0;
        for (int i = 0; i < this.getRows(); i++)
            for (int j = 0; j < this.getColumn(); j++) {
                res += matrix.getElement(i, j) + this.getElement(i, j);
                temp.setElement(i, j, res);
                res = 0;
            }
        return temp;
    }

    public IMatrix product(IMatrix matrix){
        if(this.getColumn() != matrix.getRows())
            throw new RuntimeException("You can`t ");
        IMatrix temp = new SparseMatrix(this.getRows(),matrix.getColumn());

        for(int i = 0; i< this.getRows(); i++)
            for(int j = 0; j < matrix.getColumn(); j++) {
                for (int k = 0; k < matrix.getRows(); k++) {
                    temp.setElement(i,j, temp.getElement(i,j) + (matrix.getElement(i,k) * this.getElement(k,j))); //mtrx[k][j]


                }
            }
        return temp;
    }


    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof IMatrix) {
            IMatrix sm = (IMatrix) obj;
            if (this.getColumn() != sm.getColumn() || this.getRows() != sm.getRows()) return false;
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getColumn(); j++) {
                    if (sm.getElement(i, j) != this.getElement(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void fulling_matrix (IMatrix a, IMatrix b)
    {
        a.setElement(0,0,1);
        a.setElement(0,1,2);
        a.setElement(0,2,3);
        a.setElement(1,0,1);
        a.setElement(1,1,2);
        a.setElement(1,2,1);
        a.setElement(2,0,2);
        a.setElement(2,1,1);
        a.setElement(2,2,2);

        b.setElement(0,0,1);
        b.setElement(0,1,1);
        b.setElement(0,2,1);
        b.setElement(1,0,1);
        b.setElement(1,1,1);
        b.setElement(1,2,1);
        b.setElement(2,0,1);
        b.setElement(2,1,1);
        b.setElement(2,2,1);

    }

    public IMatrix fulling_second_matrix ()
    {
        SparseMatrix msq2 = new SparseMatrix(this.getRows(), this.getColumn());
        msq2.fulling_matrix(this,msq2);
        return msq2;
    }

}
