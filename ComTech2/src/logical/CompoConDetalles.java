package logical;

import java.io.Serializable;

public class CompoConDetalles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3745497907194372676L;
	private String detalles;
	private float precio;
	private float precioFinal;
	private int cantDisponibleS;
	private String imagen;
	private String nombre;
	
	private int id;
	public CompoConDetalles(String detalles, float precio, float precioFinal, int cantDisponibleS) {
		super();
		this.detalles = detalles;
		this.precio = precio;
		this.precioFinal = precioFinal;
		this.cantDisponibleS = cantDisponibleS;
		
	}
	public float getTotal() {
		return precioFinal * cantDisponibleS;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDetalles() {
		
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}
	public int getCantDisponibleS() {
		return cantDisponibleS;
	}
	public void setCantDisponibleS(int cantDisponibleS) {
		this.cantDisponibleS = cantDisponibleS;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
