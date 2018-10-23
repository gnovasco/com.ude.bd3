package com.ude.practico.logicaPersistencia.poolConexiones;

import java.sql.Connection;

import com.ude.practico.logicaPersistencia.poolConexiones.interfaces.IConexion;

public class Conexion implements IConexion {
	
	private Connection con;
	
	public Conexion(Connection connection) {
		con = connection;
	}
	

}
