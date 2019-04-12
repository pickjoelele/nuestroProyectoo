package logical;

import java.util.Date;

import Util.Utiles;

public class Vendedor extends Person {
	

	private String Contrasena;
	private String estado;
	private String fechaNacimiento;
	private String fechaEntrada;
	public  int cantVentas;
	
	public Vendedor(String nombre, String apellido, String iD, String direccion,String contrasena,String fechaNacimiento) {
		super(nombre, apellido, iD, direccion);
		this.Contrasena = contrasena;
		this.estado = "fonctionel";
		Date date = new Date();
		fechaEntrada = Utiles.convertDateToString(date);
		// TODO Auto-generated constructor stub
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setcantVentas(int x) {
		cantVentas+=x;
	}

	public  int getCantVentas() {
		return cantVentas;
	}



	
	

}
