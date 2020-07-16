package com.company;

import java.util.ArrayList;
import java.util.Random;

import com.company.matrix.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ParallelMatrixProduct firstMatrix = new ParallelMatrixProduct(800, 900, 1);
        ParallelMatrixProduct secondMatrix = new ParallelMatrixProduct(900, 800, 1);

          getRandMatrix(firstMatrix, 10);
          getRandMatrix(secondMatrix, 10);

        System.out.println("Without threads: ");
        product_process ( secondMatrix,  firstMatrix);
        System.out.println("With threads: ");
         firstMatrix.setCountThreads(7);
         product_process ( secondMatrix,  firstMatrix);

       /* Array_max List = new Array_max(0, 1);
        getRandList(List, 10);
        System.out.println(List);
        System.out.println("Without threads: ");
        long start = System.nanoTime();
        List.Get_Max(List);
        long finish = System.nanoTime();
        System.out.println("Time: " + (finish - start));

        List.setCountThreads(7);
        System.out.println("With threads: ");
        long start1 = System.nanoTime();
        List.Get_Max(List);
        long finish1 = System.nanoTime();
        System.out.println("Time: " + (finish1 - start1));*/

    }

    public static void getRandMatrix(UsualMatrix matrix, int module) {
        Random rand = new Random();
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.setElement(i, j, rand.nextInt() % module);
            }
        }
    }

    public static void getRandList(ArrayList<Integer> List, int module) {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            List.add(rand.nextInt() % module);
        }
    }

    public static void product_process(ParallelMatrixProduct secondMatrix, ParallelMatrixProduct firstMatrix) {
        long start = System.nanoTime();
        try {
            firstMatrix.productParallel(secondMatrix);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finish = System.nanoTime();
        System.out.println("Time: " + (finish - start));
    }

}