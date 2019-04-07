package logical;

import java.util.ArrayList;

public class Cliente extends Person {
	
	private ArrayList<Factura> facturas;
	private static int cantClientes;
	private Float precio;
	public Cliente(String nombre, String apellido, String iD, String direccion) {
		super(nombre, apellido, iD, direccion);
		// TODO Auto-generated constructor stub
		this.ID="Cli - "+cantClientes+1;
		facturas = new ArrayList<Factura>();
	}
	public Float getPrecio() {
		precio = 0f;
		
		for(Factura fact:facturas)
			precio+=fact.getPrecioFinal();
		
		
		return precio;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void insertarFactura(Factura factura) {
		this.facturas.add(factura);
	}

	public static int getCantClientes() {
		return cantClientes;
	}

	public static void setCantClientes(int cantClientes) {
		Cliente.cantClientes = cantClientes;
	}



}
