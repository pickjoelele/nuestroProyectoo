package logical;

public class TarjetaMadre extends Componente{

	private String conexiones;
	private String tipoDeRam;
	
	public TarjetaMadre(String modelo, String marca, String tipo, float precio, int cantDisponible, String serie, String conexiones, String tipoDeRam) {
		super(modelo, marca, tipo, precio, cantDisponible, serie);
		// TODO Auto-generated constructor stub
		
		this.conexiones = conexiones;
		this.tipoDeRam = tipoDeRam;
		this.cantMinimal = 90;
		this.cantMax = 450;
		this.nombre = "Tarjeta Madre";
	}

	public String getConexiones() {
		return conexiones;
	}

	public void setConexiones(String conexiones) {
		this.conexiones = conexiones;
	}

	public String getTipoDeRam() {
		return tipoDeRam;
	}

	public void setTipoDeRam(String tipoDeRam) {
		this.tipoDeRam = tipoDeRam;
	}

}
