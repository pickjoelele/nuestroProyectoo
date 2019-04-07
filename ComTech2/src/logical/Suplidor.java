package logical;

import java.io.Serializable;

public class Suplidor implements Serializable{

	private String nombre;
	private String apellido;
	private String direccion;
	private String pais;

	public Suplidor(String nombre, String apellido, String direccion, String pais) {
		// TODO Auto-generated constructor stub
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
