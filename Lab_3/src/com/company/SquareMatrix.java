package com.company;

public final class SquareMatrix extends Matrix {


    SquareMatrix(int a) {
        super(a, a);
        for (int i = 0; i < super.dlina; i++) {
            mtrx[i][i] = 1;
        }
    }

    public SquareMatrix sum(Matrix a) throws RuntimeExceptionPlus{
        if (a.dlina != this.dlina) throw new RuntimeExceptionPlus("Error,matrix sizes do not match");
        SquareMatrix tmp = new SquareMatrix(this.dlina);
            for (int i = 0; i < dlina; i++) {
                for (int j = 0; j < dlina; j++)
                    tmp.setElement(i, j, this.mtrx[i][j] + a.mtrx[i][j]);
            }

        return tmp;
    }





}
