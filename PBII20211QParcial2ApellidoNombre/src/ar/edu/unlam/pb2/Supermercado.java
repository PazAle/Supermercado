package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Supermercado {
	
	private String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el número de venta)
	private Integer contadorDeVentas; // Identificador del número de venta
	
	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.productosExistentes = new HashSet<>();
		this.productosDisponibles = new LinkedList<>();
		this.ventasRealizadas = new HashMap<>();
		this.contadorDeVentas = 0;
	}

	public void ingresarProducto(Producto nuevo) {
		Boolean productoExistente = productoRegistrado(nuevo);
		if(!productoExistente) {
			agregarProductoExistente(nuevo);
			agregarProductoDisponible(nuevo);
		} else {
			agregarProductoDisponible(nuevo);
		}
	}

	private void agregarProductoDisponible(Producto nuevo) {
		this.productosDisponibles.add(nuevo);
		
	}

	private void agregarProductoExistente(Producto nuevo) {
		this.productosExistentes.add(nuevo);
		
	}

	private Boolean productoRegistrado(Producto nuevo) {
		Boolean existe = false;
		if(this.productosExistentes.contains(nuevo.getId())) {
			existe = true;
		}
		return existe;
	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que se comercializan
		Set<Producto> productos = new HashSet<>();
		for(Producto producto: this.productosDisponibles) {
			productos.add(producto);
		}
		return productos;
	}
	
	public Integer getStock(Integer codigo) {
		// Devuelve la cantidad de unidades de un producto determinado
		Integer stock = 0;
		for(Producto producto: this.productosDisponibles) {
			if(producto.getId().equals(codigo)) {
				stock++;
			}
		}
		return stock;
	}
	
	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente{
		// Verifica si un producto existe
		Boolean existe = false;
		for(Producto producto: this.productosExistentes) {
			if(producto.getId().equals(codigoDeProducto)) {
				existe = true;
			}
		}
		
		if(existe == false) {
			throw new ProductoInexistente("No existe producto con el código proporcionado");
		}
		return existe;
	}
	
	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto
		Producto productoBuscado = null;
		for(Producto producto: this.productosDisponibles) {
			if(producto.getId().equals(codigoDeProducto)) {
				productoBuscado = producto;
			}
		}
		
		if(productoBuscado == null) {
			throw new ProductoSinStock("El producto buscado, no cuenta con Stock disponible");
		}
		
		return productoBuscado;
	}
	
	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(++contadorDeVentas, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}
	
	public Venta getVenta(Integer numeroDeVenta) {
		// Devuelve una venta en función de su número identificatorio
		Venta venta = null;
		venta = this.ventasRealizadas.get(numeroDeVenta);
		return venta;
	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto) throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el "numeroDeVenta", el producto identificado por el "codigoDeProducto"
		Boolean existe = productoExiste(codigoDeProducto);
		Producto producto = null;
		Venta venta = null;
		if(existe) {
			producto = getProductoPorCodigo(codigoDeProducto);
			venta = getVenta(numeroDeVenta);
			venta.agregarProducto(producto);
			this.getProductosDisponibles().remove(producto);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getProductosExistentes() {
		return productosExistentes;
	}

	public void setProductosExistentes(Set<Producto> productosExistentes) {
		this.productosExistentes = productosExistentes;
	}

	public List<Producto> getProductosDisponibles() {
		return productosDisponibles;
	}

	public void setProductosDisponibles(List<Producto> productosDisponibles) {
		this.productosDisponibles = productosDisponibles;
	}

	public Map<Integer, Venta> getVentasRealizadas() {
		return ventasRealizadas;
	}

	public void setVentasRealizadas(Map<Integer, Venta> ventasRealizadas) {
		this.ventasRealizadas = ventasRealizadas;
	}

	public Integer getContadorDeVentas() {
		return contadorDeVentas;
	}

	public void setContadorDeVentas(Integer contadorDeVentas) {
		this.contadorDeVentas = contadorDeVentas;
	}

	public Set<Producto> obtenerProductosComestibles() {
		Set<Producto> productos = new TreeSet<>();
		for(Producto producto: this.productosDisponibles) {
			if(producto instanceof Comestible) {
				productos.add(producto);
			}
		}
		return productos;
	}
	
	

}
