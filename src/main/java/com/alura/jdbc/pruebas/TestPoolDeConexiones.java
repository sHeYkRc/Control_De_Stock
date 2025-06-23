package com.alura.jdbc.pruebas;

import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class TestPoolDeConexiones {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory con = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			
			con.recuperarConexion();
			System.out.println("Abriendo conexión numero: " + i);
		}
	}

}
