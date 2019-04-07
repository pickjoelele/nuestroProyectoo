package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
	private static DatagramSocket sckt;
	private static boolean running;

	public static void Start(int puerto) {
		puerto = puerto;
		try {
			sckt = new DatagramSocket(puerto);
			running = true;
			System.out.println("Server is running on port " + sckt.getPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listen() {
		Thread listenThread = new Thread("Server Comtech") {

			public void run() {
				try {
					while (running) {
						byte[] data = new byte[1024];
						DatagramPacket packet = new DatagramPacket(data, data.length);
						sckt.receive(packet);

						String message = new String(data);
						message = message.substring(0, message.indexOf("\\e"));
						broadcast(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		listenThread.start();
	}

	private static void broadcast(String message) {

	}

	private static void send(String message, InetAddress address, int puerto) {
		try {
			message += "\\e";
			byte[] data = message.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, address, puerto);
			sckt.send(packet);
			System.out.println("message sent to" + address.getHostName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
