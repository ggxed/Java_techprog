package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class UDPServer extends Thread {
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket serverSocket = null;
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];
    InetAddress IPAddress = InetAddress.getByName("localhost");
    private int port = 0;

    UDPServer(int port) throws UnknownHostException {
        System.out.print("Введите порт: ");
        Scanner scanner = new Scanner(System.in);
        port = Integer.parseInt(scanner.next());
        this.port = port;
        try {
            serverSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        System.out.println("Сервер запущен!");
        Receiver receiver = new Receiver(serverSocket);
        receiver.start();
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                String sentence = new String(receivePacket.getData());
                try {
                    sentence = inFromUser.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sendData = sentence.getBytes();
                String capitalizedSentence = sentence.toUpperCase();
                sendData = capitalizedSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                if (sentence.contains("@quit")) {
                    System.out.println("Клиент был закрыт...");
                    serverSocket.close();
                    break;
                }
                try {
                    serverSocket.send(sendPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sendData = null;
            }
    }
}
