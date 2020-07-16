package com.company.matrix;

import java.lang.Thread;
import java.util.ArrayList;


public class Array_multiple extends Thread {

    ArrayList<Integer> List;
    ArrayList<Integer> result;
    int beginIndex;
    int endIndex;

    public Array_multiple(ArrayList<Integer> List, ArrayList<Integer> result, int beginIndex, int endIndex) {
        this.List = List;
        this.result = result;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = beginIndex; i < endIndex; i++) {
            if (result.get(result.size() - 1) < List.get(i)) {
                result.add(List.get(i));

            }
        }
    }

}

