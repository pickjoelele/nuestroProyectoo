package logical;

public class DiscoDuro extends Componente{
	
	private String Almacenamiento;
	private String tipoConec;
	
	public DiscoDuro(String modelo, String marca, String tipo, float precio, int cantDisponible, String serie,String Almacenamiento, String tipoConec) {
		super(modelo, marca, tipo, precio, cantDisponible, serie);
		this.cantMinimal = 100;
		this.cantMax = 400;
		this.Almacenamiento = Almacenamiento;
		this.tipoConec = tipoConec;
		// TODO Auto-generated constructor stub
	}

	public String getAlmacenamiento() {
		return Almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		Almacenamiento = almacenamiento;
	}

	public String getTipoConec() {
		return tipoConec;
	}

	public void setTipoConec(String tipoConec) {
		this.tipoConec = tipoConec;
	}

}
