package logical;

import java.util.ArrayList;

class unKit {
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
public class Kit {
	private ArrayList<unKit> componentes;
	
	public Kit() {
		componentes = new ArrayList<unKit>();
	}
	//agregar 
	public void insertarUnComp(unKit unkit) {
		componentes.add(unkit);
	}
	public void insertarTodosComps(ArrayList<unKit>unkits) {
		this.componentes = unkits;
	}
	

	
	
}
