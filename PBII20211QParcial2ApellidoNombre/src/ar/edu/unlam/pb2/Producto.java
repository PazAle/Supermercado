package ar.edu.unlam.pb2;

import java.util.Objects;

public class Producto implements Comparable<Producto>{

	private Integer id;
	private String descripcion;
	private String marca;
	private Double precio;
	
	public Producto(Integer id, String descripcion, String marca, Double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}
	
	
}
