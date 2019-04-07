package logical;

public class DiscoDuro extends Componente{
	
	private int Almacenamiento;
	private String tipoConec;
	public static int cantMinimal = 100;
	public static int cantMax = 400;
	public DiscoDuro(String modelo, String marca, float precio,String serie,String imagen,int Almacenamiento, String tipoConec) {
		super(modelo, marca, precio, serie, imagen);
		this.tipoConec = tipoConec;
		this.Almacenamiento = Almacenamiento;
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


	@Override
	public String getDetalles() {
		// TODO Auto-generated method stub
		String str = String.format("%s   %s   %s \n%s   %d ",nombre,modelo,marca,tipoConec,Almacenamiento );
		return str;	}

}
