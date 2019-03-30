package logical;

import java.util.Date;

public class Factura {
	
	
	private Date fecha;
	private float precio;
	private int cantPC;
	
	public Factura(Date fecha, float precio, int cantPC) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.cantPC = cantPC;
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantPC() {
		return cantPC;
	}
	public void setCantPC(int cantPC) {
		this.cantPC = cantPC;
	}
	
	

}
