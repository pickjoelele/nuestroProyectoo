package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -974358794226177576L;
	private Date fecha;
	private ArrayList<CompoConDetalles> productos;
	private String cliente;
	private String vendedor;
	private float precioFinal;
	private String id;
	private String detalles;
	private int cantItem;

	public Factura(String cliente, String vendedor, String id) {
		super();
		productos = new ArrayList<CompoConDetalles>();
		fecha = new Date();
		this.cliente = cliente;
		this.id = id;
		this.vendedor = vendedor;

	}

	public String getDetalles() {

		return detalles;

	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPrecioFinal() {
		precioFinal = 0;
		detalles = "";
		cantItem = 0;
		int cantMayor ;
		for (CompoConDetalles compo : productos) {
			precioFinal += compo.getTotal();
			Formatter formatter = new Formatter(); 
			
	        // comma Specifier 
	        formatter = new Formatter(); 
	        formatter.format("CANT : %-10s| %s \n",Integer.toString(compo.getCantDisponibleS()), compo.getDetalles()); 
	       detalles+=formatter;
//			detalles += String.format("CANT : %-10d| %s \n",compo.getCantDisponibleS(), compo.getDetalles());

		}

		return precioFinal;
	}

	public int getCantItem() {
		return cantItem;
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

	public ArrayList<CompoConDetalles> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<CompoConDetalles> productos) {
		this.productos = productos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
