package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class ConexionMySQL implements IConexion {
	
	private Connection con;
	
	public ConexionMySQL(Connection connection) {
		con = connection;
	}

	public Connection getCon() {
		return con;
	}
}
