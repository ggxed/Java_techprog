package com.company;

import com.company.*;

public final class Main {

    public static void main(String[] args) {

        Matrix m = new Matrix(3,2);
        m.mtrx[1][0] = 2;
        m.mtrx[1][1] = 3;
        m.mtrx[2][1] = 2;
        Matrix m2 = new Matrix(3,3);
        m2.mtrx[1][0] = 3;
        m2.mtrx[0][1] = 1;
        m2.mtrx[2][1] = 2;
        Matrix m3 = new Matrix(2,2);
        m3.mtrx[1][0] = 2;
        m3.mtrx[1][1] = 2;
        m3.mtrx[0][1] = 1;
        Matrix m4 = new Matrix(2,2);
        m4.mtrx[0][1] = 1;
        m4.mtrx[1][0] = 1;

       // System.out.println( m.toString());
       System.out.println( m2.toString());
        //System.out.println( m3.toString());
      System.out.println( m4.toString());
        try{
            m = m2.sum(m3);

        }catch(RuntimeExceptionPlus e){
            System.out.println (e.getMessage());
            return;
        }

        System.out.println( m.toString());


       // Matrix test = null;
       // test.equals(m);

       // OneElementMatrix m = new OneElementMatrix(5, 3, 4);

        //System.out.println(m.toString());

    }
}
