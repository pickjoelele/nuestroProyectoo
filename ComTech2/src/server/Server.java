package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import logical.Controladora;

public class Server {
	private static ServerSocket sckt;
	private static boolean running;
	private static Controladora control;

	public static void setControladora(Controladora controladora) {
		control = controladora;
	}

	public static Controladora getControladora() {
		return control;
	}

	public static void Start(int puerto) {
		puerto = puerto;
		try {
			sckt = new ServerSocket(puerto);
			running = true;
			listen();
			System.out.println("Server is running on port " + sckt.getLocalPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close() throws IOException {
		sckt.close();
		
	}

	public static void listen() throws IOException {

		while (running) {
			Socket socket = sckt.accept();
			System.out.println("quelqu'un s'est connecte");
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

			output.writeObject(control);

			try {
				control = ((Controladora) input.readObject());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
