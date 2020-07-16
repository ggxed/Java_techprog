package com.company;

public class Matrix {
    protected int dlina;
    protected int viisota;
    protected  int[][] mtrx;

    Matrix(int a, int b) {
        this.viisota = a;
        this.dlina = b;
        mtrx = new int[viisota][dlina];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer((this.dlina * this.viisota * 2));
        for (int i = 0; i < viisota; ++i) {
            for (int j = 0; j < dlina ; ++j) {
                sb.append(mtrx[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public  void setElement(int row, int column, int value) {
        mtrx[row][column] = value;
    }

    public int getElement(int row, int column) {
        if(row < 0 || column < 0 || row > dlina || column > viisota)
        throw new RuntimeExceptionPlus("Error, The length of one matrix does not match the other");

      return  mtrx[row][column];
    }

    public Matrix sum(Matrix a) throws RuntimeExceptionPlus{
        if(a.viisota != this.viisota || a.dlina != this.dlina)
            throw new RuntimeExceptionPlus("Error, matrix is not the same size");
        Matrix tmp = new Matrix(this.dlina,this.viisota);
        for (int i = 0; i < dlina; i++) {
            for (int j = 0; j < viisota; j++) {
                tmp.setElement(i, j, this.mtrx[i][j] + a.getElement(i,j));
            }
        }   
        return tmp;
    }


    public  Matrix product(Matrix a) throws RuntimeExceptionPlus
    {
        if( a.dlina != this.viisota )
        throw new RuntimeExceptionPlus("Error, The length of one matrix does not match the other");
        Matrix tmp = new Matrix(this.dlina,this.viisota);
            for (int i=0; i<dlina; ++i){
            for (int j=0; j<viisota; ++j){
            for (int k=0; k<dlina; ++k){
                    //tmp[i][l] += mtrx[i][j] * a[j][l];
                    tmp.setElement(i,j, tmp.getElement(i,j) + (a.getElement(i,k) * this.getElement(k,j))); //mtrx[k][j]
                }
            }
        }
        return tmp;
    }


    public boolean equals(Object obj)
    {
        if(obj.getClass() == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Matrix objk = (Matrix) obj;
        if(objk.dlina != this.dlina || objk.viisota != this.viisota) return false;
        for (int i = 0; i < dlina; i++) {
            for (int l = 0; l < viisota; l++) {
            if(this.mtrx[i][l] != objk.mtrx[i][l])
                return false;
            }
        }
        return true;
    }
}