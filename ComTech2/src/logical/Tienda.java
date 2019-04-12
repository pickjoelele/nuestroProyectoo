package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -396970319363090851L;
	//
	private String municipio;
	private String direccion;
	private ArrayList<Kit> kits;
	private ArrayList<miniComponente> componentes;
	private ArrayList<Suplidor> suplidores;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Factura> facturas;
	private ArrayList<Compra> compras;
	private ArrayList<Cliente> clientes;
	private static int cantRam;
	private static int cantDisco;
	private static int cantTarjeta;
	private static int cantMicro;
	private ArrayList<CompoConDetalles> detallesComponente;

	public Tienda(String direccion, String municipio) {
		super();
		this.setdetallesComponente(new ArrayList<CompoConDetalles>());
		this.municipio = municipio;
		this.setDireccion(direccion);
		this.kits = new ArrayList<Kit>();
		this.componentes = new ArrayList<miniComponente>();
		this.suplidores = new ArrayList<Suplidor>();
		this.vendedores = new ArrayList<Vendedor>();
		this.facturas = new ArrayList<Factura>();
		this.compras = new ArrayList<Compra>();
		this.clientes = new ArrayList<Cliente>();

	}

	public void updateComponente() {
		detallesComponente.clear();
		for (miniComponente mini : componentes) {
			CompoConDetalles compo = new CompoConDetalles(mini.getComp().getDetalles(), mini.getComp().getPrecio(),
					mini.getComp().getPrecioVenta(), mini.getCant());
			compo.setImagen(mini.getComp().getImagen());
			compo.setNombre(mini.getComp().getNombre());
			detallesComponente.add(compo);
		}
		for (Kit kit : kits) {
			CompoConDetalles compo = new CompoConDetalles(kit.getDetalles(), kit.getPrecioSinDescuento(),
					kit.getPrecioFinal(), 0);
			compo.setNombre(kit.getNombre());
			compo.setImagen("");
			detallesComponente.add(compo);
		}

	}

	public boolean restarComponente(Cliente cliente, ArrayList<CompoConDetalles> productos) {

		float precio = cliente.getPrecio();
		ArrayList<SerieDetalles> series = new ArrayList<SerieDetalles>();
		for (CompoConDetalles compoDetalles : productos) {
		

			if (!compoDetalles.getNombre().equalsIgnoreCase("Kit")) {
				for (miniComponente mini : componentes) {
					if (compoDetalles.getDetalles().equalsIgnoreCase(mini.getComp().getDetalles())) {
						
						
						precio+= compoDetalles.getPrecioFinal();
						for (int x = 0; x < compoDetalles.getCantDisponibleS(); x++) {
							String str = mini.getComp().getNombre();
							String id = String.format("%s-%09d", str, miniComponente.cantComponente + 1);
							miniComponente.cantComponente++;

							SerieDetalles serie = new SerieDetalles(mini.getComp().getDetalles(), id,
									compoDetalles.getPrecioFinal());
							series.add(serie);
							System.out.println(id);
							
						}
					}
				}
			} /*
				 * else {
				 * 
				 * 
				 * for(Kit kit: kits) {
				 * if(kit.getDetalles().equalsIgnoreCase(compoDetalles.getDetalles())) {
				 * for(UnKit unkit: kit.getComponentes()) {
				 * 
				 * } } }
				 * 
				 * 
				 * 
				 * 
				 * }
				 */
		}
		cliente.setPrecio(precio);
		cliente.setComponentes(series);

		return true;

	}

	public Suplidor getSupliByNombre(String nombre) {

		for (Suplidor supli : suplidores) {

			if (supli.getNombre().equalsIgnoreCase(nombre))
				return supli;

		}

		return null;
	}

	public String getMunicipio() {
		return municipio;
	}

	// agregar un kit o varios kits
	public boolean insertarTodosKits(ArrayList<Kit> kits) {
		this.kits = kits;
		return true;
	}

	public boolean insertarUnKit(Kit kit) {

		if (kits.add(kit)) {
			return true;
		}

		return false;
	}

	public void loadCantidadComponente() {

		cantRam = cantDisco = cantMicro = cantTarjeta = 0;
		for (miniComponente compo : componentes) {

			if (compo.getComp() instanceof Ram)
				cantRam += compo.getCant();
			else if (compo.getComp() instanceof DiscoDuro)
				cantDisco += compo.getCant();
			else if (compo.getComp() instanceof TarjetaMadre)
				cantTarjeta += compo.getCant();
			else if (compo.getComp() instanceof Microprocesador)
				cantMicro += compo.getCant();

		}

	}

	public void insertarUnComponente(Componente componente, int cant) {
		miniComponente mini = new miniComponente(componente, cant);
		for (miniComponente minicomp : componentes) {
			if (minicomp.getComp().getDetalles().equalsIgnoreCase(componente.getDetalles())) {
				mini.setCant(mini.getCant() + cant);
				return;
			}
		}
		this.componentes.add(mini);
		return;
	}

	public ArrayList<CompoConDetalles> getMiniComponentesByName(String str,
			ArrayList<CompoConDetalles> principalArray) {

		ArrayList<CompoConDetalles> miniComponentes = new ArrayList<CompoConDetalles>();
		if (!str.isEmpty()) {
			for (CompoConDetalles mini : principalArray) {

				if (mini.getDetalles().toLowerCase().contains(str.toLowerCase()))
					miniComponentes.add(mini);

			}

		} else
			return principalArray;

		return miniComponentes;

	}

	public ArrayList<Compra> getMiniComprasByName(String str, ArrayList<Compra> principalArray) {

		ArrayList<Compra> compras = new ArrayList<Compra>();
		if (!str.isEmpty()) {
			for (Compra mini : principalArray) {

				if (mini.getDetalles().toLowerCase().contains(str.toLowerCase()))
					compras.add(mini);

			}

		} else
			return principalArray;

		return compras;
	}

	public ArrayList<Cliente> getClientesByname(String str, ArrayList<Cliente> principalArray) {

		ArrayList<Cliente> compras = new ArrayList<Cliente>();
		if (!str.isEmpty()) {
			for (Cliente mini : principalArray) {

				if (mini.getNombre().toLowerCase().contains(str.toLowerCase()))
					compras.add(mini);

			}

		} else
			return principalArray;

		return compras;
	}

	public boolean isThesame(Componente comp, ArrayList<miniComponente> minicomponentes) {

		for (miniComponente mini : minicomponentes) {
			Componente comp2 = mini.getComp();
			String modelo = comp.getModelo();
			String marca = comp.marca;
			float precio = comp.getPrecio();
			String nombre = comp.getNombre();
			if (comp2.getModelo().equalsIgnoreCase(modelo) && comp2.getMarca().equalsIgnoreCase(marca)
					&& comp2.getPrecio() == precio && comp2.getNombre().equalsIgnoreCase(nombre)) {

				if (comp instanceof DiscoDuro && comp2 instanceof DiscoDuro) {
					int alma = ((DiscoDuro) comp).getAlmacenamiento();
					String tipoCon = ((DiscoDuro) comp).getTipoConec();

					int alma2 = ((DiscoDuro) comp2).getAlmacenamiento();
					String tipoCon2 = ((DiscoDuro) comp2).getTipoConec();

					if (alma == alma2 && tipoCon.equalsIgnoreCase(tipoCon))
						return true;

				} else if (comp instanceof Ram && comp2 instanceof Ram) {

					String cantMemoria1 = ((Ram) comp).getCantMemoria();
					String tipoRam = ((Ram) comp).getTipoRam();

					String cantMemoria2 = ((Ram) comp2).getCantMemoria();
					String tipoRam2 = ((Ram) comp2).getTipoRam();

					if (cantMemoria1.equalsIgnoreCase(cantMemoria2) && tipoRam.equalsIgnoreCase(tipoRam2))
						return true;

				} else if (comp instanceof TarjetaMadre && comp2 instanceof TarjetaMadre) {
					String conexioens = ((TarjetaMadre) comp).getConexiones();
					String tipoDeram = ((TarjetaMadre) comp).getTipoDeRam();
					String conexioens2 = ((TarjetaMadre) comp2).getConexiones();
					String tipoDeram2 = ((TarjetaMadre) comp2).getTipoDeRam();

					if (conexioens.equalsIgnoreCase(conexioens2) && tipoDeram.equalsIgnoreCase(tipoDeram2))
						return true;

				} else if (comp instanceof Microprocesador && comp2 instanceof Microprocesador) {
					String velocidad = ((Microprocesador) comp).getVelocidad();
					String velocidad2 = ((Microprocesador) comp2).getVelocidad();
					if (velocidad.equalsIgnoreCase(velocidad2))
						return true;

				}

			}
		}

		return false;
	}

	// agregar suplidor o varios suplidores
	public boolean insertarTodosSuplidores(ArrayList<Suplidor> suplidores) {
		this.suplidores = suplidores;
		return true;
	}

	public boolean insertarUnSuplidor(Suplidor supli) {
		this.suplidores.add(supli);
		return true;
	}

	// agregar Vendedor o varios Vendedores
	public boolean insertarTodosVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
		return true;
	}

	public boolean insertarUnVendedor(Vendedor vendedor) {
		this.vendedores.add(vendedor);
		return true;
	}

	// agregar Factura o varias Facturas
	public boolean insertarTodasFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
		return true;
	}

	public boolean insertarUnaFactura(Factura factura) {
		this.facturas.add(factura);

		for (CompoConDetalles compo : factura.getProductos()) {
			for (miniComponente mini : componentes) {
				if (compo.getDetalles().equalsIgnoreCase(mini.getComp().getDetalles())) {
					mini.setCant(mini.getCant() - compo.getCantDisponibleS());
				}

			}
		}
		return true;
	}

	// agregar una Compra o varias
	public boolean insertarTodasCompras(ArrayList<Compra> compras) {
		this.compras = compras;
		return true;
	}

	public void insertarUnaCompra(Compra compra) {
		compras.add(compra);

	}

	// ahi van todos los setters
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	// ahi van todos los getters

	public ArrayList<Kit> getKits() {
		return kits;
	}

	public ArrayList<miniComponente> getComponentes() {
		return componentes;
	}

	public ArrayList<Suplidor> getSuplidores() {
		return suplidores;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public String getDireccion() {
		return direccion;
	}

	public static int getCantDisco() {
		return cantDisco;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void insertarCliente(Cliente cliente) {

		this.clientes.add(cliente);

	}

	public static int getCantTarjeta() {
		return cantTarjeta;
	}

	public static int getCantMicro() {
		return cantMicro;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public static int getCantRam() {
		return cantRam;
	}

	public static void setCantRam(int cantRam) {
		Tienda.cantRam = cantRam;
	}

	public ArrayList<CompoConDetalles> getdetallesComponente() {
		return detallesComponente;
	}

	public void setdetallesComponente(ArrayList<CompoConDetalles> detallesComponente) {
		this.detallesComponente = detallesComponente;
	}

}
