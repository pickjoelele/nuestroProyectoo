package logical;

public abstract class Componente {

	protected String modelo;
	protected String marca;
	protected float precio;
	protected float precioVenta;
	protected String serie;
	protected String nombre;
	protected String supliNombre;
	public Componente(String modelo, String marca,float precio, String serie) {
		super();
		this.modelo = modelo;
		this.precioVenta = (float) (precio + (0.30*precio));
		this.marca = marca;
		this.precio = precio;
		this.serie = serie;
	}



	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
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

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
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
