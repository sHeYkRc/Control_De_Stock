package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Producto;

public class ProductoDAO {

	final private Connection con;

	public ProductoDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Producto producto) {

		final Connection con = new ConnectionFactory().recuperarConexion();

		try (con) {
			System.out.println(con.isClosed());
			System.out.println(con);
			System.out.println("Entra a statemen");

			final PreparedStatement ps = con.prepareStatement(
					"INSERT INTO PRODUCTO" + "(nombre, descripcion, cantidad, categoria_id)" + " VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			try (ps) {
				ejecutaRegistro(producto, ps);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutaRegistro(Producto producto, PreparedStatement ps) throws SQLException {
		System.out.println("entra al ejecutar registro");

		ps.setString(1, producto.getNombre());
		ps.setString(2, producto.getDescripcion());
		ps.setInt(3, producto.getCantidad());
		ps.setInt(4, producto.getCategoria());

		ps.execute();
		System.out.println("finaliza execute");

		final ResultSet rs = ps.getGeneratedKeys();
		System.out.println("se obtubieron las keys genradas");

		try (rs) {
			System.out.println("Entra al try de resltSET");
			while (rs.next()) {
				producto.setId(rs.getInt(1));
				System.out.println(String.format("Fue insertado el producto %s", producto));

			}
		}
	}

	public List<Producto> listar(Connection con) {

		List<Producto> resultado = new ArrayList<>();

		try (con) {

			final PreparedStatement ps = con.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

			try (ps) {

				ps.execute();

				final ResultSet rs = ps.getResultSet();

				try (rs) {

					while (rs.next()) {
						Producto fila = new Producto(rs.getInt("ID"), rs.getString("NOMBRE"),
								rs.getString("DESCRIPCION"), rs.getInt("CANTIDAD"));
						resultado.add(fila);
					}
				}
				return resultado;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int modificar(Producto producto) {
		final Connection con = new ConnectionFactory().recuperarConexion();
		try (con) {

			final PreparedStatement ps = con.prepareStatement(
					"UPDATE PRODUCTO SET " + "nombre = ?" + ",descripcion = ?" + ",cantidad = ?" + " WHERE id = ?");

			try (ps) {
				ps.setString(1, producto.getNombre());
				ps.setString(2, producto.getDescripcion());
				ps.setInt(3, producto.getCantidad());
				ps.setInt(4, producto.getId());

				ps.execute();

				return ps.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminar(Producto producto) {

		final Connection con = new ConnectionFactory().recuperarConexion();

		try (con) {

			final PreparedStatement st = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID = ?");

			try (st) {

				st.setInt(1, producto.getId());
				st.execute();
				int updateCount = st.getUpdateCount();
				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public List<Producto> listar(Integer categoriaId) {

		List<Producto> resultado = new ArrayList<>();

		try  {

			final PreparedStatement ps = con.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO WHERE CATEGORIA_ID = ?");

			try (ps) {
				
				ps.setInt(1, categoriaId);
				ps.execute();

				final ResultSet rs = ps.getResultSet();

				try (rs) {

					while (rs.next()) {
						Producto fila = new Producto(rs.getInt("ID"), rs.getString("NOMBRE"),
								rs.getString("DESCRIPCION"), rs.getInt("CANTIDAD"));
						resultado.add(fila);
					}
				}
				return resultado;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
