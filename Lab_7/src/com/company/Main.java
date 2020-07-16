package com.company;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Settings sets2 = Settings.loadFromTextFile("in1.txt");
        System.out.println(sets2);
        sets2.put("qwerty", 912);
        System.out.println(sets2);
        sets2.saveToTextFile("out1.txt");
        sets2.saveToBinaryFile("out2");

        Settings sets3 = Settings.loadFromBinaryFile("out2");
        System.out.println();
        System.out.println(sets3);
        sets3.delete("qwerty");
        System.out.println(sets3);

       /*Library lib = Library.loadFromTextFile("in1.txt");
        System.out.println(lib);
        System.out.println(lib.findName("ASDw"));*/

    }
}
