package ar.edu.unlam.pb2;

public class Indumentaria extends Producto{

	private String color;
	private String talle;
	
	public Indumentaria(Integer id, String descripcion, String talle, String marca, String color, Double precio) {
		super(id, descripcion, marca, precio);
		this.color = color;
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	
}
