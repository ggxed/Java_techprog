package com.company;
import java.io.IOException;
import java.net.*;

public class Receiver extends Thread {
    private DatagramSocket clientsocket;
    byte[] data = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(data, data.length);


    public Receiver( DatagramSocket clientsocket) {
        this.clientsocket = clientsocket;
    }

    public void run() {
        try {
            while(true) {
                if (isInterrupted()) {
                    throw new InterruptedException();
                }
                clientsocket.receive(receivePacket);
                String message =  new String (receivePacket.getData(), "UTF-8");
                String str = new String();
                for(int i = 0; i < message.length(); i++) {
                    if(message.charAt(i) == 0)
                        break;
                    str += message.charAt(i);
                }
                System.out.println("FROM SERVER:" + str);
            }
        }
        catch(InterruptedException e) {
            System.out.println(".");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}