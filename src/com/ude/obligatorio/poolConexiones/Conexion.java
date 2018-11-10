package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class Conexion implements IConexion {
	
	private Connection con;
	
	public Conexion(Connection connection) {
		con = connection;
	}


	@Override
	public Connection getCon() {
		return con;
	}
}
