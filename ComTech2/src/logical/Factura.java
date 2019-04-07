package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -974358794226177576L;
	private Date fecha;
	private ArrayList<Kit> kits;
	private ArrayList<miniComponente> componentes;
	private String cliente;
	private String vendedor;
	private float precioFinal;

	public Factura(String cliente, String vendedor) {
		super();
		fecha = new Date();
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.componentes = new ArrayList<miniComponente>();
		this.kits = new ArrayList<Kit>();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Kit> getKits() {
		return kits;
	}

	public float getPrecioFinal() {
		precioFinal = 0;
		for (miniComponente mini : componentes) {
			precioFinal += mini.getComp().getPrecioVenta() * mini.getCant();
		}
		for (Kit kit : kits) {
			precioFinal += kit.getPrecioFinal();
		}

		return precioFinal;
	}

	public void setKits(ArrayList<Kit> kits) {
		this.kits = kits;
	}

	public ArrayList<miniComponente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<miniComponente> componentes) {
		this.componentes = componentes;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

}
