package logical;

import java.io.Serializable;

public abstract class Componente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6251705858912739731L;
	protected String modelo;
	protected String marca;
	protected float precio;
	protected float precioVenta;
	protected String serie;
	protected String nombre;
	protected String supliNombre;
	protected String imagen;
	public int cantDispo;
	public Componente(String modelo, String marca,float precio, String serie,String imagen) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.serie = serie;
		this.imagen = imagen;
	}
	public abstract String getDetalles();



	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public int getCantDispo() {
		return cantDispo;
	}






	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getSupliNombre() {
		return supliNombre;
	}

	public void setSupliNombre(String supliNombre) {
		this.supliNombre = supliNombre;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float porcentaje) {
		this.precioVenta = precio + (porcentaje/100 )*precio;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

}
