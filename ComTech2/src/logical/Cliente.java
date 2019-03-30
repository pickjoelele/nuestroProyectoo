package logical;

public class Cliente extends Person {
	
	private PC miPC;
	

	public Cliente(String nombre, String apellido, String iD, String direccion, PC miPC) {
		super(nombre, apellido, iD, direccion);
		// TODO Auto-generated constructor stub
		this.miPC=miPC;
	}


	public PC getMiPC() {
		return miPC;
	}


	public void setMiPC(PC miPC) {
		this.miPC = miPC;
	}

}
