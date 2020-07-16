package com.company;
import java.io.IOException;
import java.net.*;

public class Receiver extends Thread {
	private DatagramSocket serverSocket;
	byte[] data = new byte[1024];
	//DatagramPacket packet = new DatagramPacket(data, data.length);
	DatagramPacket packet = new DatagramPacket(data, data.length);
	String str = new String();

	public Receiver( DatagramSocket serverSocket) {
		this.serverSocket = serverSocket;
	}


	public void run() {
		try {
			while(true) {
				if (isInterrupted()) {
					throw new InterruptedException();
				}
				serverSocket.receive(packet);
            	String message =  new String (packet.getData(), "UTF-8");
				String str = new String();
				for(int i = 0; i < message.length(); i++) {
					if(message.charAt(i) == 0)
						break;
					str += message.charAt(i);
				}
				System.out.println( str);
				if (message.contains("@quit")) {
					System.out.println("Клиент был закрыт...");
					serverSocket.close();
					break;
				}
				data = null;
				str = "";
				message = "";
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