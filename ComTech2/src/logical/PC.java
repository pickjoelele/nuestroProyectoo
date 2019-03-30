package logical;

public class PC {
	
	private TarjetaMadre miTarjeta;
	private Ram miRam;
	private Microprocesador miMicro;
	private DiscoDuro miDisco;
	private float PrecioTotal;
	
	public PC(TarjetaMadre miTarjeta, Ram miRam, Microprocesador miMicro, DiscoDuro miDisco, float precioTotal) {
		super();
		this.miTarjeta = miTarjeta;
		this.miRam = miRam;
		this.miMicro = miMicro;
		this.miDisco = miDisco;
		PrecioTotal = precioTotal;
	}

	public TarjetaMadre getMiTarjeta() {
		return miTarjeta;
	}

	public void setMiTarjeta(TarjetaMadre miTarjeta) {
		this.miTarjeta = miTarjeta;
	}

	public Ram getMiRam() {
		return miRam;
	}

	public void setMiRam(Ram miRam) {
		this.miRam = miRam;
	}

	public Microprocesador getMiMicro() {
		return miMicro;
	}

	public void setMiMicro(Microprocesador miMicro) {
		this.miMicro = miMicro;
	}

	public DiscoDuro getMiDisco() {
		return miDisco;
	}

	public void setMiDisco(DiscoDuro miDisco) {
		this.miDisco = miDisco;
	}

	public float getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		PrecioTotal = precioTotal;
	}
	
	
	
	

}
