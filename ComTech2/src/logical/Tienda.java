package logical;

import java.util.ArrayList;

public class Tienda {
	//
	private String municipio;
	private String direccion;
	private ArrayList<Kit> kits;
	private ArrayList<Componente> componentes;
	private ArrayList<Suplidor> suplidores;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Factura> facturas;
	private ArrayList<Compra> compras;
	public Tienda(String direccion,String municipio) {
		super();
		this.municipio = municipio;
		this.setDireccion(direccion);
		this.kits = new ArrayList<Kit>();
		this.componentes = new ArrayList<Componente>();
		this.suplidores = new ArrayList<Suplidor>();
		this.vendedores = new ArrayList<Vendedor>();
		this.facturas = new ArrayList<Factura>();
		this.compras = new ArrayList<Compra>();
	

	}
	
	public String getMunicipio(){
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

	// agregar un componenente o varios componentes;
	public boolean insertarTodosComponentes(ArrayList<Componente> comps) {
		this.componentes = comps;
		return true;
	}

	public boolean insertarUnComponente(Componente comp) {
		this.componentes.add(comp);
		return true;
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
		return true;
	}

	// agregar una Compra o varias
	public boolean insertarTodasCompras(ArrayList<Compra> compras) {
		this.compras = compras;
		return true;
	}

	public boolean insertarUnaCompra(Compra compra) {
		int cant = 0;
		if (compra.getMiComp() instanceof TarjetaMadre)
			cant = cantTarjetaMadre();
		else if (compra.getMiComp() instanceof Ram)
			cant = cantRam();
		else
			cant = cantMicroprocesador();
		System.out.println(cant);
		if (cant <= compra.getMiComp().getCantMinimal()) {
			this.compras.add(compra);
			compra.getMiComp().setCantDisponible(compra.getCantidad());
			return true;
		} else {
			return false;
		}

	}

	// ahi van todos los setters
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	// ahi van todos los getters

	public ArrayList<Kit> getKits() {
		return kits;
	}

	public ArrayList<Componente> getComponentes() {
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

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	// cant de cada componente que tengo

	// cant Tarjeta madre
	public int cantTarjetaMadre() {
		int cant = 0;

		for (Componente comp : componentes) {
			if (comp instanceof TarjetaMadre) {
				cant += comp.getCantDisponible();
			}
		}
		return cant;

	}

	// cant Ram
	public int cantRam() {
		int cant = 0;

		for (Componente comp : componentes) {
			if (comp instanceof Ram) {
				cant += comp.getCantDisponible();
			}
		}
		return cant;

	}

	// cant microprocesador
	public int cantMicroprocesador() {
		int cant = 0;

		for (Componente comp : componentes) {
			if (comp instanceof Microprocesador) {
				cant += comp.getCantDisponible();
			}
		}
		return cant;

	}

}
