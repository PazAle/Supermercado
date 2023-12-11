package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Venta {

	private Integer dniComprador;
	private String nombreComprador;
	private List<Producto> productos;
	
	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		this.dniComprador = dniDelComprador;
		this.nombreComprador = nombreDelComprador;
		this.productos = new ArrayList<>();
	}

	public Integer getDniComprador() {
		return dniComprador;
	}

	public void setDniComprador(Integer dniComprador) {
		this.dniComprador = dniComprador;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public Double getImporte() {
		Double importe = 0.0;
		for(Producto producto: this.productos) {
			importe += producto.getPrecio();
		}
		return importe;
	}
}
