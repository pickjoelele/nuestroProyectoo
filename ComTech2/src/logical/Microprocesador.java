package logical;

public class Microprocesador extends Componente {
	
	private String velocidad;
	public static int cantMinimal = 150;
	public static int cantMax = 600;
	public Microprocesador(String modelo, String marca, float precio, String serie,String imagen,String velocidad) {
		super(modelo, marca, precio, serie,imagen);	
		this.nombre ="Microprocesador";
		this.velocidad = velocidad;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String getDetalles() {
		// TODO Auto-generated method stub
		String str = String.format("%s   %s   %s \n%s GHZ",nombre,modelo,marca,velocidad  );
		return str;
	}

}
