package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class CategoriaDAO {

	private Connection con;

	public CategoriaDAO(Connection con) {

		this.con = con;

	}

	public List<Categoria> listar() {

		List<Categoria> resultado = new ArrayList<>();
		try {

			final PreparedStatement ps = con.prepareStatement("SELECT ID, NOMBRE FROM CATEGORIA");
			try (ps) {
				final ResultSet rs = ps.executeQuery();

				try (rs) {
					while (rs.next()) {
						Categoria categoria = new Categoria(rs.getInt("ID"), rs.getString("NOMBRE"));
						resultado.add(categoria);
					}
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}

	public List<Categoria> listarConProductos() {
		List<Categoria> resultado = new ArrayList<>();
		try {

			final PreparedStatement ps = con.prepareStatement("SELECT C.ID, C.NOMBRE,"
					+ " P.ID, P.NOMBRE, P.CANTIDAD"
					+ " FROM CATEGORIA C INNER JOIN"
					+ " PRODUCTO P ON C.ID = P.CATEGORIA_ID");
			try (ps) {
				final ResultSet rs = ps.executeQuery();

				try (rs) {
					while (rs.next()) {
						
						Integer categoriaId = rs.getInt("C.ID");
						String categoriaNombre = rs.getString("C.NOMBRE");
						
						var categoria = resultado
								.stream()
								.filter(cat -> cat.getId().equals(categoriaId))
								.findAny().orElseGet(()->{
									Categoria cat = new Categoria(categoriaId, categoriaNombre);
									resultado.add(cat);
									return cat;
								});
						Producto p = new Producto(rs.getInt("P.ID"),
								rs.getString("P.NOMBRE"), rs.getInt("P.CANTIDAD"));
						
						categoria.agregar(p);
								
						
					}
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}

}
