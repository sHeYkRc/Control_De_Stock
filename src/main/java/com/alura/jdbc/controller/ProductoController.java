package com.alura.jdbc.controller;


import java.util.List;


import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class ProductoController {
	
	private ProductoDAO dao;
	
	public ProductoController() {
		this.dao = new ProductoDAO(new ConnectionFactory().recuperarConexion());
	}

	public int modificar(Producto producto){

		return dao.modificar(producto);
		
		
	}

	public int eliminar(Producto producto ){
		
		return dao.eliminar(producto);
	}

	public List<Producto> listar(){
		
		return dao.listar(new ConnectionFactory().recuperarConexion());	
	}

	public void guardar(Producto producto, Integer categoria){
		producto.setCategoria(categoria);
		dao.guardar(producto);
	}
	
	public List<Producto> listar(Categoria categoria){
		return dao.listar(categoria.getId());
	}
	

}
