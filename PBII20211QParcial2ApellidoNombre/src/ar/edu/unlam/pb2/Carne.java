package ar.edu.unlam.pb2;

public class Carne extends Comestible {

	private Double kgs;
	public Carne(Integer id, String descripcion, String feElaboracion, String feVencimiento, Double kgs, String marca,
			Double precio) {
		super(id, descripcion, feElaboracion, feVencimiento, marca, precio);
		this.kgs = kgs;
	}
	public Double getKgs() {
		return kgs;
	}
	public void setKgs(Double kgs) {
		this.kgs = kgs;
	}
	
	

}
