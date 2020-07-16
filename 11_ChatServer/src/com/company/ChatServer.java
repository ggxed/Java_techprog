package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer extends Thread {
    private static ServerSocket  server;
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static  BufferedReader in;
    private static  BufferedWriter out;
    private  String name = "Хост";
    private static  int port;

    public ChatServer() throws IOException {
        System.out.print("Введите порт: ");
        Scanner scanner = new Scanner(System.in);
        int port = Integer.parseInt(scanner.next());
        server = new ServerSocket(port);
        this.port = port;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run ()  {
        try  {
            try  {
            System.out.println("Сервер запущен!");
            clientSocket = server.accept();
            System.out.println(" Есть подключение !\n");
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                try {
                    String ClientWord;
                    String Messeg;
                    while (true) {
                        ClientWord = in.readLine();
                       // System.out.println(ClientWord);
                        if(ClientWord.contains("@quit") ) {
                            break;
                        }
                        System.out.println(ClientWord);
                       Messeg = reader.readLine();
                        out.write(name + ": " + Messeg + "\n");
                        out.flush();
                    }

        }  finally {
            clientSocket.close();
            in.close();
            out.close();
        }
    } finally {
        System.out.println("Сервер закрыт!");
        server.close();
    }
} catch (IOException e) {
        System.err.println(e);
        }
    }
}
