package logical;

public class TarjetaMadre extends Componente {

	private String conexiones;
	private String tipoDeRam;
	public static int cantMinimal = 50;
	public static int cantMax = 300;

	public TarjetaMadre(String modelo, String marca, float precio, String serie,String imagen, String conexiones, String tipoDeRam) {
		super(modelo, marca, precio, serie,imagen);
		// TODO Auto-generated constructor stub

		this.conexiones = conexiones;
		this.tipoDeRam = tipoDeRam;

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

	@Override
	public String getDetalles() {
		// TODO Auto-generated method stub
		String str = String.format("%s   %s   %s \n  %s  %s", nombre, modelo, marca, conexiones,tipoDeRam);
		return str;
	}

}
