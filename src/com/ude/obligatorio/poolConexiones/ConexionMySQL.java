package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class ConexionMySQL implements IConexion {
	
	private Connection con;
	
	public ConexionMySQL(Connection connection) {
		con = connection;
	}


	@Override
	public Connection getCon() {
		return con;
	}
}
