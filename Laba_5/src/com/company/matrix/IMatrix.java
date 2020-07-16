package com.company.matrix;

public interface IMatrix {
    String toString();

    void setElement(int row, int column, int value);

    int getElement(int row, int column);

    Object sum(IMatrix matrix);

    Object product(IMatrix matrix);

    int getRows();

    int getColumn();

    boolean equals(Object obj);

}
