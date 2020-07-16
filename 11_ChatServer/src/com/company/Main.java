package com.company;

import com.company.*;

import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        UDPServer serverThread = new UDPServer(4004);
        serverThread.start();
    }
}
