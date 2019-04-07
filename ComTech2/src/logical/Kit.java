package logical;

import java.io.Serializable;
import java.util.ArrayList;

class unKit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8413888595378447291L;
	private Componente comp;
	private int cantComponente;
	private float desCuento;

	public unKit(Componente comp, int cantComponente, float desCuento) {
		super();
		this.comp = comp;
		this.cantComponente = cantComponente;
		this.desCuento = desCuento;
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

	public float getDesCuento() {
		return desCuento;
	}

	public void setDesCuento(float desCuento) {
		this.desCuento = desCuento;
	}

}

public class Kit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3545026044559657274L;
	private ArrayList<unKit> componentes;
	private float precioFinal;

	public Kit() {
		componentes = new ArrayList<unKit>();
	}

	public ArrayList<unKit> getComponentes() {
		return componentes;
	}

	public float getPrecioFinal() {
		precioFinal =0;
		for(unKit unk : componentes) {
			precioFinal+=unk.getComp().getPrecioVenta()*unk.getCantComponente()*((100-unk.getDesCuento())/100);
		}
		return precioFinal;
	}

	// agregar
	public void insertarUnComp(unKit unkit) {
		componentes.add(unkit);
	}

	public void insertarTodosComps(ArrayList<unKit> unkits) {
		this.componentes = unkits;
	}

}
