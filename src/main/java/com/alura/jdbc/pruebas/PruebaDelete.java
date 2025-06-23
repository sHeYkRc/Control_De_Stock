package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaDelete {
	
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexion();
		
		Statement st = con.createStatement();
		
		st.execute("DELETE FROM PRODUCTO WHERE ID = 99");
		
		System.out.println(st.getUpdateCount());
	}

}
