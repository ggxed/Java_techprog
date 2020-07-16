package com.company.matrix;

public class UsualMatrix implements IMatrix {

    private final int row;
    private final int column;
    private final int[][] mtrx;

    UsualMatrix(int a) {
        this.row = a;
        this.column = a;
        mtrx = new int[row][column];
    }

    @Override
    public int getRows() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder((this.row * this.column * 2));
        for (int i = 0; i < column; ++i) {
            for (int j = 0; j < row; ++j) {
                sb.append(mtrx[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }


    @Override
    public void setElement(int row, int column, int value) {
        mtrx[row][column] = value;
    }

    @Override
    public IMatrix sum(IMatrix a) {
        if (a.getColumn() != this.column || a.getRows() != this.row)
            throw new RuntimeException("Error, matrix is not the same size");
        UsualMatrix tmp = new UsualMatrix(this.row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tmp.setElement(i, j, this.mtrx[i][j] + a.getElement(i, j));
            }
        }
        return tmp;
    }

    @Override
    public int getElement(int row, int column) {
        if (row < 0 || column < 0)
            throw new RuntimeException("Error, The length of one matrix does not match the other");
        return mtrx[row][column];
    }

    @Override
    public IMatrix product(IMatrix a) {
        if (a.getRows() != this.row)
            throw new RuntimeException("Error, The length of one matrix does not match the other");
        UsualMatrix tmp = new UsualMatrix(this.row);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                for (int k = 0; k < row; ++k) {
                    tmp.setElement(i, j, tmp.getElement(i, j) + (a.getElement(i, k) * mtrx[k][j]));
                }
            }
        }
        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        UsualMatrix objk = (UsualMatrix) obj;
        if (objk.getRows() != this.row || objk.getColumn() != this.column) return false;
        for (int i = 0; i < row; i++) {
            for (int l = 0; l < column; l++) {
                if (this.mtrx[i][l] != objk.mtrx[i][l])
                    return false;
            }
        }
        return true;
    }
}
