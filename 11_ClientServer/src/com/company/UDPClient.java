package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class UDPClient extends Thread {

    BufferedReader inFromUser =
            new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket clientSocket = new DatagramSocket();
    InetAddress IPAddress = InetAddress.getByName("localhost");
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];
    private int port = 0;
    String name = "User";

    UDPClient(int port) throws SocketException, UnknownHostException {
        System.out.print("Введите порт: ");
        Scanner scanner = new Scanner(System.in);
        port = Integer.parseInt(scanner.next());
        this.port = port;
    }

    @Override
    public void run() {
        Receiver msg = new Receiver(clientSocket);
        msg.start();
        while (true) {
            String sentence = null;
            try {
                sentence+= name + " : ";
                sentence = inFromUser.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (sentence.contains("@name")) {
                name = sentence.substring(6);
                System.out.println("Теперь вы " + name + "!");
            }else
            if (sentence.contains("@quit")) {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
            }else {
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                try {
                    clientSocket.send(sendPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
