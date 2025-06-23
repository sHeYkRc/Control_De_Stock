package com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	
	private Integer id;
	private String nombre;
	private List<Producto> producto;
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		
		return this.nombre;
	}

	public void agregar(Producto p) {
		
		if(this.producto == null) {
			this.producto = new ArrayList<>();
			}
		producto.add(p);
	}

	public List<Producto> getProductos() {
		return this.producto;
	}

	
}
