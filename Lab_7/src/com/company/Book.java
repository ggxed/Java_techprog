package com.company;

public class Book {
    public String Name ;
    public Integer Year;


    public Book(String n, Integer y)
    {
        Name = n;
        Year = y;
    }

    public void set(String n, Integer y)
    {
        Name = n;
        Year = y;
    }
    public String toString() {
        StringBuilder res = new StringBuilder ();
        res.append(Name + " ").append(Year+ "\n");
        return res.toString ();
    }

}
