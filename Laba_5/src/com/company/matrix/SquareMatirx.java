package com.company.matrix;

public class SquareMatirx extends UsualMatrix {


    public SquareMatirx(int a) {
        super(a);

    }


    public SquareMatirx sum(IMatrix a) {
        if (a.getRows() != this.getRows()) throw new RuntimeException("Error,matrix sizes do not match");
        SquareMatirx tmp = new SquareMatirx(getRows());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getRows(); j++)
                tmp.setElement(i, j, this.getElement(i, j) + a.getElement(i, j));
        }
        return tmp;
    }

}
