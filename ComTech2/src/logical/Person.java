package logical;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2550803675854612336L;
	protected String Nombre;
	protected String Apellido;
	protected String ID;
	protected String Direccion;
	
	public Person(String nombre, String apellido, String iD, String direccion) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		ID = iD;
		Direccion = direccion;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	
	
	

}
