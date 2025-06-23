package com.alura.jdbc.modelo;

public class Producto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private Integer categoria;
	
	public Producto(String nombre, String descripcion, Integer cantidad ) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public Producto(int id, String nombre, String descripcion, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public Producto(Integer id) {
		this.id = id;
	}

	public Producto(int id, String nombre, int cantidad) {
		this.id= id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
	public Integer getCategoria() {
		return categoria;
	}
	
	@Override
	public String toString() {
		
		return String.format("{id: %s, descripción: %s, cantidad: %d}",
				this.id, this.descripcion,this.cantidad);
	}

	
	

}
