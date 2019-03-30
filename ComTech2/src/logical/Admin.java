package logical;

public class Admin extends Person {
	
	private String contrasena;
	private String fechaNacimiento;
	public Admin(String nombre, String apellido, String iD, String direccion,String contrasena,String fechaNacimiento) {
		super(nombre, apellido, iD, direccion);
		this.setContrasena(contrasena);
		this.fechaNacimiento = fechaNacimiento;
		
		
	}
	

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
