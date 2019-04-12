package logical;

public class Ram extends Componente {

	private String cantMemoria;
	private String tipoRam;
	public static int cantMinimal = 80;
	public static int cantMax = 450;

	public Ram(String modelo, String marca,float precio, String serie,String imagen,
			String cantMemoria, String tipoRam) {
		super(modelo, marca, precio, serie,imagen);
		// TODO Auto-generated constructor stub
		this.cantMemoria = cantMemoria;
		this.tipoRam = tipoRam;
		this.nombre = "Ram";
	}

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

	@Override
	public String getDetalles() {
		// TODO Auto-generated method stub
		String str = String.format("%s   %s   %s  %s  %s",nombre,modelo,marca,tipoRam,cantMemoria );
		return str;	}

}
