package com.ude.practico.logicaPersistencia.poolConexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ude.practico.logicaPersistencia.poolConexiones.interfaces.IConexion;
import com.ude.practico.logicaPersistencia.poolConexiones.interfaces.IPoolConexiones;

public class PoolConexiones implements IPoolConexiones {
	
	private String url;
	private String user;
	private String diver;
	private String password;
	
	private int tope;
	private int tamanio;
	private int creadas;
	private int nivelTransaccionalidad;
	
	private Conexion[] conexiones;
	
	/* 
	 * Constructor de la clase. Realiza la carga
	 * del driver, solicita memoria para el arreglo con tope e inicializa
	 * los distintos atributos. 
	 */
	public PoolConexiones(String url,String user,String password,int tope) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conexiones = new Conexion[tope];
			/*for(int i = 0;i<= tope; i++) {
				//Connection connection =DriverManager.getConnection(url, user, password);
				Conexion conexion = new Conexion(connection);
				conexiones[i] = conexion;
			}*/
 
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
		
	}
	@Override
	public IConexion obtenerConexion(boolean modifica) {
		//TODO
		return null;
	}
	
	@Override
	public void liberarConexion(IConexion icon, boolean ok) {
		
	}

}
