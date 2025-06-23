package com.alura.jdbc.controller;

import java.util.List;
import com.alura.jdbc.dao.CategoriaDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDAO dao;
	
	public CategoriaController() {
		ConnectionFactory factory = new ConnectionFactory();
		this.dao = new CategoriaDAO(factory.recuperarConexion());
	}

	public List<Categoria> listar() {

		return dao.listar();
	}

    public List<Categoria> cargaReporte() {
        return dao.listarConProductos();
    }

}
