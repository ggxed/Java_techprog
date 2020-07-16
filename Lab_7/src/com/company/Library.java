package com.company;
import java.io.*;
import java.util.*;

public class Library {
    private HashMap<String, Book> hashMap = new HashMap<String, Book>();

    public void put(String key, Book book) {
        hashMap.put(key, book);
    }

    public static Library loadFromTextFile(String filename) throws IOException {
        Library resLibrary = new Library();
        String value =null;
        String key = null;
        String date =null;
        InputStream in = new FileInputStream(filename);
        Reader r = new BufferedReader(new InputStreamReader(in));
        Scanner sc = new Scanner(r);
        while (sc.hasNext()) {
            key = sc.next();
            value = sc.next();
            date = sc.next();
            Book book = new Book(value,Integer.parseInt(date.replaceAll("\n", "")));
            resLibrary.put(key, book);
        }
        sc.close();
        return resLibrary;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String key : hashMap.keySet()) {
            res.append(key + ' ' + hashMap.get(key) + "\r\n");
        }
        return res.toString();
    }

    public String findName(String name) {
        for (String key : hashMap.keySet()) {
            if (name.equals(hashMap.get(key).Name))
                return (key +" "+ hashMap.get(key).Name +" "+ hashMap.get(key).Year+"\n");
        }
        return ("Nothing find");
    }

    public String find_to_date_(Integer year)
    {
        StringBuilder res = new StringBuilder();
        for (String key : hashMap.keySet()) {
            if (year < hashMap.get(key).Year)
                res.append(key +" "+ hashMap.get(key).Name +" "+ hashMap.get(key).Year+"\n");
        }
        return res.toString();
    }



}
