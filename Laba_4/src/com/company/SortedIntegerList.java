package com.company;
import java.util.*;
import java.util.LinkedList;


public class SortedIntegerList  {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private boolean sort;

    SortedIntegerList ( boolean sort)
    {
        this.sort = sort;
    }

    public void add (int val)
    {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext())
        {
            int elem = iter.next();
            if (elem == val)
            {
                if (sort)
                {
                    iter.previous();
                    iter.add(val);
                }
                return;
            }
            if (elem > val)
            {
                iter.previous();
                iter.add(val);
                return;
            }
        }
        list.add(val);
    }


    public void remove (int val)
    {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext())
        {
            int elem = iter.next();
            if (elem == val)
            {
                iter.previous();
                iter.remove();
                return;
            }
            if (elem > val)
                return;
        }
    }

    public String toString() {
        return list.toString();
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj.getClass() == null) return false;
        if (getClass() != obj.getClass())
            return false;
        SortedIntegerList other = (SortedIntegerList) obj;
        return this.list.equals(other.list);
    }
}
