package logical;

public class Suplidor extends Person {
	
	private String Pais;
	
	

	public Suplidor(String nombre, String apellido, String iD, String direccion, String Pais) {
		super(nombre, apellido, iD, direccion);
		// TODO Auto-generated constructor stub
		this.Pais=Pais;
	}



	public String getPais() {
		return Pais;
	}



	public void setPais(String pais) {
		Pais = pais;
	}
	
	

}
