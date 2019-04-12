package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import logical.Controladora;

public class Client {

	private static Socket socket = null;
	private static ObjectInputStream input = null;
	private static ObjectOutputStream output = null;
	private static Controladora control;
	private static boolean running;

	public static Controladora getControladora() {
		return control;
	}

	public static void start(int puerto) {

		try {
			
			socket = new Socket("127.0.0.01", puerto);
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
			running = true;
			listen();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void listen() {
		Thread thread = new Thread() {
			int cant = 0;

			public void run() {
				try {
					while (running) {
						
						  try { control = (Controladora) input.readObject(); } catch
						  (ClassNotFoundException e) { // TODO Auto-generated catch block
						  e.printStackTrace(); }
						  
						  
						
					}
					

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		thread.start();
	}
	
	public static void main(String args[]) {
		Client.start(5000);
	}

}
