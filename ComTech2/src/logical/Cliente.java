package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4233007017061617818L;
	private ArrayList<SerieDetalles> componentes;
	public static int cantClientes;
	private Float precio;
	private String telefono;
	private String direccion;
	private String nombre;
	private String ID;

	public Cliente(String nombre, String telefono, String direccion) {
		// TODO Auto-generated constructor stub
		cantClientes++;
		this.ID = String.format("%d", cantClientes);
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		componentes = new ArrayList<SerieDetalles>();
	}

	public String getID() {
		return ID;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Float getPrecio() {
		precio = 0f;

		for (SerieDetalles compo : componentes)
			precio += compo.getPrecioFinal();

		return precio;
	}

	public String getNombre() {
		return String.format("%s ", nombre);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<SerieDetalles> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<SerieDetalles> series) {
		this.componentes.addAll(componentes.size(), series);
	}

}
