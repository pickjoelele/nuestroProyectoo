package logical;

import java.util.ArrayList;

public class Controladora {

	private static ArrayList<Admin> administradores;
	private static Person person = null;
	private Tienda tienda;

	public Controladora() {
		super();
		Controladora.administradores = new ArrayList<Admin>();
		Tienda tienda = new Tienda("Villa Olga", "Santiago");
		this.setTienda(tienda);
		DiscoDuro disco1 = new DiscoDuro("modelo", "marca", "tipo", 0, 0, "serie", "13", "dkd");
		Ram  ram = new Ram("modelo", "marca", "tipo", 0, 0, "serie", "13", "dkd");
		TarjetaMadre tj = new TarjetaMadre("modelo", "marca", "tipo", 0, 0, "serie", "13", "dkd");
		Microprocesador micro = new Microprocesador("modelo", "marca", "tipo", 0, 0, "serie", "13");
		Admin LevensonLaguerre = new Admin("Levenson", "Laguerre", "admin", "loteria,calle 3", "admin", "01/01/1997");
		Admin Evelina = new Admin("Evelina", "Villa", "admin", "loteria,calle 3", "eve", "01/01/1997");
		Admin Jhoan = new Admin("Jhoan", "Collado", "admin", "loteria,calle 3", "1234", "01/01/1997");
		administradores.add(Jhoan);
		administradores.add(Evelina);
		administradores.add(LevensonLaguerre);

	}

	public static Person getActualUser() {
		return person;
	}

	public static void setActualUser(Person person) {
		Controladora.person = person;
	}

	public Person confirmLogin(String usuario, String contrasena) {

		for (Admin adm : administradores) {
			if (adm.getID().equals(usuario) && adm.getContrasena().equals(contrasena)) {
				this.person = adm;
				return adm;
			}
		}
		return null;
	}

	// agregar un admin o varios admin
	public boolean insertarTodosAdmin(ArrayList<Admin> adminis) {
		Controladora.administradores = adminis;
		return true;
	}

	public boolean insertarUnAdmin(Admin admin) {
		Controladora.administradores.add(admin);
		return true;
	}

	// ahi van todos los gettes
	public ArrayList<Admin> getAdministradores() {
		return administradores;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}
