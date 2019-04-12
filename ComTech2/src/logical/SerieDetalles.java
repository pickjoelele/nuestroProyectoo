package logical;

import java.io.Serializable;

public class SerieDetalles implements Serializable {
	
	private String detalles;
	private String serie;
	private float precioFinal;
	

	public SerieDetalles(String detalles, String serie,float precioFinal) {
		super();
		this.detalles = detalles;
		this.serie = serie;
		this.precioFinal = precioFinal;
	}
	public float getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	

}
