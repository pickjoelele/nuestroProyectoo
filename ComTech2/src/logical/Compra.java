package logical;

public class Compra {

	private String miSuplidor;
	private Componente miComp;
	private int cantidad;
	private float precio;
	private float precioTotal;
	private String fecha;

	public Compra(String miSuplidor, Componente miComp, int cantidad, String fecha) {
		super();
		this.miSuplidor = miSuplidor;
		this.miComp = miComp;
		this.cantidad = cantidad;
		this.precio = miComp.getPrecio();
		this.fecha = fecha;
		this.precioTotal = cantidad * precio;

	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getMiSuplidor() {
		return miSuplidor;
	}

	public void setMiSuplidor(String miSuplidor) {
		this.miSuplidor = miSuplidor;
	}

	public Componente getMiComp() {
		return miComp;
	}

	public void setMiComp(Componente miComp) {
		this.miComp = miComp;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
