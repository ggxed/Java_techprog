package com.company.matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Array_max extends ArrayList<Integer> {

    int countThreads;

    public Array_max(int size, int countThreads) {
        super(size);
        this.countThreads = countThreads;
    }

    public void setCountThreads(int countThreads) {
        this.countThreads = countThreads;
    }

    public int getCountThreads() {
        return this.countThreads;
    }

    public ArrayList<Integer> Get_Max(ArrayList<Integer> List) throws InterruptedException {
        ArrayList<Integer> result = new ArrayList<Integer>(0);
        result.add(0);
        int beginIndex = 0;
        int countsElements = (List.size()) / this.countThreads;
        Array_multiple[] threads = new Array_multiple[this.countThreads];
        for (int i = 0; i < threads.length; i++) {
            if (i == threads.length - 1) {
                countsElements = List.size() - beginIndex;
            }
            threads[i] = new Array_multiple(this, result, beginIndex, beginIndex + countsElements);
            threads[i].start();
            beginIndex = beginIndex + countsElements;
        }
        for (Array_multiple i : threads) {
            i.join();
        }

        return result;
    }

}
