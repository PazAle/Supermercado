package ar.edu.unlam.pb2;

public class Comestible extends Producto {

	private String fechaDeElaboracion;
	private String fechaDeVencimiento;
	
	
	public Comestible(Integer id, String descripcion, String feElaboracion, String feVencimiento, String marca, Double precio) {
		super(id, descripcion, marca, precio);
		this.fechaDeElaboracion = feElaboracion;
		this.fechaDeVencimiento = feVencimiento;
		
	}
	public String getFechaDeElaboracion() {
		return fechaDeElaboracion;
	}

	public void setFechaDeElaboracion(String fechaElaboracion) {
		this.fechaDeElaboracion = fechaElaboracion;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaVencimiento) {
		this.fechaDeVencimiento = fechaVencimiento;
	}

		
}
