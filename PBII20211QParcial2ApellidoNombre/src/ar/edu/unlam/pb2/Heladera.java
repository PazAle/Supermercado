package ar.edu.unlam.pb2;

public class Heladera extends Electrodomestico {

	private Boolean noFrost;
	
	public Heladera(Integer id, String descripcion, Boolean noFrost, Integer garantia, String marca, Double precio) {
		super(id, descripcion, garantia, marca, precio);
		this.noFrost = noFrost;
	}

	public Boolean isNoFrost() {
		return noFrost;
	}

	public void setNoFrost(Boolean noFrost) {
		this.noFrost = noFrost;
	}

	
}
