package logical;

public class Ram extends Componente {
	
	private String cantMemoria;
	private String tipoRam;

	public Ram(String modelo, String marca, String tipo, float precio, int cantDisponible, String serie, String cantMemoria, String tipoRam) {
		super(modelo, marca, tipo, precio, cantDisponible, serie);
		// TODO Auto-generated constructor stub
		this.cantMemoria = cantMemoria;
		this.tipoRam = tipoRam;
		this.nombre = "Ram";
		this.cantMinimal = 80;
		this.cantMax = 450;	}

	public String getCantMemoria() {
		return cantMemoria;
	}

	public void setCantMemoria(String cantMemoria) {
		this.cantMemoria = cantMemoria;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}

}
