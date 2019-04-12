package logical;

import java.io.Serializable;

public class UnKit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5719286779705514299L;
	private Componente comp;
	private int cantComponente;
	private int desCuento;
	private float precioCondesCuento;
	private int cantTotal;

	public UnKit(Componente comp, int cantComponente, int desCuento) {
		super();
		this.comp = comp;
		this.cantComponente = cantComponente;
		this.desCuento = desCuento;
		this.precioCondesCuento = (comp.getPrecioVenta() * ((100 - desCuento) / 100)) * cantComponente;
	}

	public UnKit() {
		// TODO Auto-generated constructor stub
	}

	public int getCantTotal() {
		return cantTotal;
	}

	public void setCantTotal(int cant) {
		this.cantTotal = cant;
	}

	public float getPrecioCondesCuento() {
		float desc = (100 - desCuento);
		desc /= 100;
		float precio = comp.getPrecioVenta() * desc * cantComponente;
		return precio;

	}

	public Componente getComp() {
		return comp;
	}

	public void setComp(Componente comp) {
		this.comp = comp;
	}

	public int getCantComponente() {
		return cantComponente;
	}

	public void setCantComponente(int cantComponente) {
		this.cantComponente = cantComponente;
	}

	public int getDesCuento() {
		return desCuento;
	}

	public void setDesCuento(int desCuento) {
		this.desCuento = desCuento;
	}

	public String getDetalles() {
		String str = String.format("%d %s \n precio sin Descuento : %.0f $ \n precio Actual : %.0f $ ", cantComponente,
				comp.getNombre(), cantComponente * comp.getPrecioVenta(), getPrecioCondesCuento());
		return str;
	}

}