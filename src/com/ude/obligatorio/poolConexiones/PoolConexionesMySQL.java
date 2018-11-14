package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

public class PoolConexionesMySQL implements IPoolConexiones {
	
	private String url;
	private String user;
	private String driver;
	private String password;
	
	private int tope;
	private int tamanio;
	private int creadas;
	private int nivelTransaccionalidad;
	
	private IConexion[] conexiones;

	private static PoolConexionesMySQL poolConexiones;
	
	/* 
	 * Constructor de la clase. Realiza la carga del driver, solicita memoria para el arreglo con tope e inicializa
	 * los distintos atributos.
	 * Es privado para que la clase sea singleton.
	 */
	private PoolConexionesMySQL(String url,String user,String password,int tamanio,String driver) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;

		this.tope = -1;
		this.tamanio = tamanio;
		this.creadas = 0;
		this.nivelTransaccionalidad = Connection.TRANSACTION_NONE;

		conexiones = new ConexionMySQL[tamanio];
	}	// PoolConexiones
	
	/*
	 * Obtener la unica instancia del pool de conexiones.
	 */
	public static PoolConexionesMySQL getPoolConexiones(String url,String user,String password,int tamanio,String driver) {
		if(poolConexiones == null){
			poolConexiones = new PoolConexionesMySQL("","","",10,"");
		}
		return poolConexiones;
	}
	
	@Override
	public IConexion obtenerConexion(boolean modifica) {


		
		IConexion conexion = null;
		if ((tope + 1) < tamanio) {
			try {
				creadas++;
				nivelTransaccionalidad = (modifica ? Connection.TRANSACTION_SERIALIZABLE : Connection.TRANSACTION_NONE);

				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url, user, password);
				conexion = new ConexionMySQL(connection);
				conexiones[++tope] = conexion;
			}
			catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		return conexion;
	}	// obtenerConexion
	
	/*
	 * Liberar una conexion del pool, no necesariamente la ultima.
	 */
	//TODO: para que esta el boolean ??
	@Override
	public void liberarConexion(IConexion icon, boolean ok) {
		try {
			int i=0, j;
			
			while (conexiones[i] != icon)
				i++;
			
			ConexionMySQL conMySQL = (ConexionMySQL)conexiones[i];
	        Connection con = conMySQL.getCon();
	        
			con.close();
			// Aca bajar las conexiones desde la siguiente hasta el tope
			// para que no quede un hueco.
			for (j = i+1; j < tope; j++)
				conexiones[j] = conexiones[j + 1]; 
			tope--;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	// liberarConexion
}	// PoolConexiones
