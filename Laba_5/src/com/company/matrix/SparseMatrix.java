package com.company.matrix;

import com.company.Sparse;

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
        for (int i = 0; i < this.rows; i++) {
            res.append("[ ");
            for (int j = 0; j < this.column; j++) {
                if (j == this.rows - 1)
                    res.append(this.getElement(i, j));
                else
                    res.append(this.getElement(i, j)).append(" ");
            }
            res.append("]\n");
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

    public IMatrix product(IMatrix matrix) {
        if (this.getColumn() != matrix.getRows())
            throw new RuntimeException("You can`t ");
        IMatrix temp = new SparseMatrix(this.getRows(), matrix.getColumn());
        int summa = 0;
        for (int i = 0; i < this.getRows(); i++)
            for (int j = 0; j < matrix.getColumn(); j++) {
                for (int k = 0; k < matrix.getRows(); k++)
                    summa += this.getElement(i, k) * matrix.getElement(k, j);
                this.setElement(i, j, summa);
                summa = 0;


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
}
