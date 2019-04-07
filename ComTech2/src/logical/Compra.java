package logical;

import java.io.Serializable;
import java.util.Date;

import Util.Utiles;

public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5335676784544226857L;
	private String supliNombre;
	private String pais;
	private String nombreComponente;
	private float precio;
	private float precioTotal;
	private String fecha;
	private int cant;

	public Compra(String supliNombre, String pais, String nombreComponente, float precio,
			 int cant) {
		super();
		this.supliNombre = supliNombre;
		this.pais = pais;
		this.nombreComponente = nombreComponente;
		this.precio = precio;
		this.precioTotal = precio*cant;
		this.fecha = Utiles.convertDateToString(new Date());
		this.cant = cant;
	}

	public String getSupliNombre() {
		return supliNombre;
	}

	public void setSupliNombre(String supliNombre) {
		this.supliNombre = supliNombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombreComponente() {
		return nombreComponente;
	}

	public void setNombreComponente(String nombreComponente) {
		this.nombreComponente = nombreComponente;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

}
