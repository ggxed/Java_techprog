package com.company;

public class Main {

    public static void main(String[] args) {

        SortedIntegerList list = new SortedIntegerList (false);

        list.add(6);
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(0);
        list.add(0);
        list.add(2);

        //System.out.println(list.toString());


        SortedIntegerList list2 = new SortedIntegerList (true);

        list2.add(6);
        list2.add(0);
        list2.add(2);
        list2.add(4);
        list2.add(1);
        list2.add(3);
        list2.add(0);
        list2.add(4);
        list2.add(4);
        list2.add(4);

        System.out.println(list2);

        System.out.println(list2.equals(list));

    }
}
