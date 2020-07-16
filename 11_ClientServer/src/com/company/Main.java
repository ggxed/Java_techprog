package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Client client = new Client();//4004
        UDPClient clietnThread = new UDPClient(4004);
        clietnThread.start();
    }
}
