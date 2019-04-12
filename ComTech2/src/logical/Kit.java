package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Kit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3545026044559657274L;
	private ArrayList<UnKit> componentes;
	private float precioFinal;
	private float precioSinDescuento;
	private String nombre;
	public static int cantKit;
	private int id;
	public Kit() {
		this.nombre="Kit";
		componentes = new ArrayList<UnKit>();
		cantKit++;
		this.setId(cantKit);
	}
	public String getNombre() {
		return nombre;
	}

	public ArrayList<UnKit> getComponentes() {
		return componentes;
	}

	public float getPrecioFinal() {
		precioFinal = 0;
		precioSinDescuento =0;
		for (UnKit unk : componentes) {
			precioFinal += unk.getPrecioCondesCuento();
			precioSinDescuento+=unk.getCantComponente()*unk.getComp().getPrecioVenta();
		}
		return precioFinal;
	}

	// agregar
	public void insertarUnComp(UnKit unkit) {
		componentes.add(unkit);
	}

	public void insertarTodosComps(ArrayList<UnKit> unkits) {
		this.componentes = unkits;
	}

	public String getDetalles() {

		String str = "";
		for (UnKit kit : componentes) {
			str += String.format("%d %s \n", kit.getCantComponente(), kit.getComp().getDetalles());

		}

		return str;
	}

	public float getPrecioSinDescuento() {
		return precioSinDescuento;
	}

	public void setPrecioSinDescuento(float precioSinDescuento) {
		this.precioSinDescuento = precioSinDescuento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
