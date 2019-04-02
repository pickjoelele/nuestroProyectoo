package logical;

public class Microprocesador extends Componente {
	
	private String velocidad;
	public static int cantMinimal = 150;
	public static int cantMax = 600;
	public Microprocesador(String modelo, String marca, float precio, String serie,String velocidad) {
		super(modelo, marca, precio, serie);	
		this.nombre ="Microprocesador";
		this.velocidad = velocidad;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

}
