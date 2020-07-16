package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;
    private int port;
    private String name = "Гость";

    Client() throws IOException {
        System.out.print("Введите порт: ");
        Scanner scanner = new Scanner(System.in);
        this.port = Integer.parseInt(scanner.next());
        clientSocket = new Socket("localhost", port);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        System.out.println(" Доступные команды:\n " +
                "1)Задать имя пользователя (@name Vasya)\n" +
                "2)Выход (@quit)\n");
        System.out.println("Введите свое сообщение");
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            // ReadMsg msg = new ReadMsg(clientSocket);
            String word;
            // msg.start();
            while (true) {
                try {
                    word = reader.readLine();
                    out.write(name + ": " + word + "\n");
                    out.flush();
                    if (word.contains("@name")) {
                        name = word.substring(6);
                        System.out.println("Теперь вы " + name + "!");
                    }

                    if (word.contains("@quit")) {
                        System.out.println("Клиент был закрыт...");
                        clientSocket.close();
                        in.close();
                        out.close();
                    }

                    String serverWord = in.readLine();
                    System.out.println(serverWord);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}







