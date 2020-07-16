package com.company;

import com.company.matrix.*;

class Main {

    public static void main(String[] args) {

        SparseMatrix msp = new SparseMatrix(1000, 1000);
        System.out.println(msp.toString());

        SquareMatirx msq = new SquareMatirx(1000);
        System.out.println(msq.toString());


    }
}
