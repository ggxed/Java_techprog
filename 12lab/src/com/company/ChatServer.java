package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ChatServer extends Thread {
    private static ServerSocket  server;
    private static Socket clientSocket = null;
    private static BufferedReader reader;
    private  String name = "Хост";
    private static  int port;
    private int sizeuser = 0;
    public static HashMap<String,Socket> Usermap = new LinkedHashMap<String,Socket>();

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
        System.out.println("Сервер запущен!");
        try  {
            try  {
                while (true) {
                    clientSocket = server.accept();
                        System.out.println(" Есть подключение !\n Client" + sizeuser);
                        Reader[] socketreader = new Reader[10];// запуск нового потока чтения
                        socketreader[sizeuser] = new Reader(clientSocket,Usermap);
                        socketreader[sizeuser].start();
                        sizeuser++;
                        clientSocket=null;

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
