package loadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import logical.Controladora;
import logical.Tienda;

public class loadData {
	private static Controladora control;
	private static File direccion;

	public static void load() {
		control = new Controladora();
		direccion = new File("C:\\Users\\lele\\Desktop\\ISC Files program 1/Tienda.dat");
		loadTienda();
	}

	public static Controladora getControladora() {
		return control;
	}

	public static void saveTienda() {

		try {
			FileOutputStream filetienda = new FileOutputStream(direccion);

			ObjectOutputStream OBJO = new ObjectOutputStream(filetienda);
			OBJO.writeObject(control.getTienda());
			System.out.println("fue guardado con exito!");
			filetienda.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void loadTienda() {
		if (direccion.exists()) {
			FileInputStream fileTienda;
			try {
				fileTienda = new FileInputStream(direccion);
				System.out.println("fue leido con exito!");

				java.io.ObjectInputStream OBJI = new java.io.ObjectInputStream(fileTienda);
				control.setTienda((Tienda) OBJI.readObject());
				fileTienda.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();

			}
		}
	}

}
