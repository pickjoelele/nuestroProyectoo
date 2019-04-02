package logical;

public class DiscoDuro extends Componente{
	
	private int Almacenamiento;
	private String tipoConec;
	public static int cantMinimal = 100;
	public static int cantMax = 400;
	public DiscoDuro(String modelo, String marca, float precio,String serie,int Almacenamiento, String tipoConec) {
		super(modelo, marca, precio, serie);
	
		this.Almacenamiento = Almacenamiento;
		this.tipoConec = tipoConec;
		// TODO Auto-generated constructor stub
	}
	

	public int getAlmacenamiento() {
		return Almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		Almacenamiento = almacenamiento;
	}

	public String getTipoConec() {
		return tipoConec;
	}

	public void setTipoConec(String tipoConec) {
		this.tipoConec = tipoConec;
	}

}
