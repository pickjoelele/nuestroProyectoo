package logical;

import java.io.Serializable;

public class miniComponente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8385597659008102591L;
	private Componente comp;
	private int cant;

	public miniComponente(Componente comp, int cant) {
		this.comp = comp;
		this.cant = cant;
	}

	public Componente getComp() {
		return comp;
	}

	public void setComp(Componente comp) {
		this.comp = comp;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

}