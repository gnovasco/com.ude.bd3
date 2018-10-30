package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

public class PoolConexiones implements IPoolConexiones {
	
	private String url;
	private String user;
	private String driver;
	private String password;
	
	private int tope;
	private int tamanio;
	private int creadas;
	private int nivelTransaccionalidad;
	
	private IConexion[] conexiones;
	
	/* 
	 * Constructor de la clase. Realiza la carga
	 * del driver, solicita memoria para el arreglo con tope e inicializa
	 * los distintos atributos. 
	 */
	public PoolConexiones(String url,String user,String password,int tamanio,String driver) {

		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;

		this.tope = 0;
		this.tamanio = tamanio;
		this.creadas = 0;
		this.nivelTransaccionalidad = Connection.TRANSACTION_NONE;

		conexiones = new Conexion[tamanio];
	}
	@Override
	public IConexion obtenerConexion(boolean modifica) {

		IConexion conexion = null;
		if(tope+1 < tamanio) {
			try {

				tope = tope++;
				creadas = creadas++;
				nivelTransaccionalidad = modifica ? Connection.TRANSACTION_SERIALIZABLE : Connection.TRANSACTION_NONE;

				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url, user, password);
				conexion = new Conexion(connection);

				conexiones[tope] = conexion;

			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		return conexion;
	}
	
	@Override
	public void liberarConexion(IConexion icon, boolean ok) {
		try {
			Connection con = icon.getCon();
			con.close();
			tope --;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
