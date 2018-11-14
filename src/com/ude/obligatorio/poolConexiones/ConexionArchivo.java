package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class ConexionArchivo implements IConexion {
	/*
	 * Atributos.
	 */
	
	// Array asociativo de nro. de folio a candado.
	private Map<String, ReadWriteLock> candadosFolios = new HashMap<String, ReadWriteLock>();


	/*
	 * Metodos.
	 */
	
	/*
	 * Bloquea la estructura para pedir el candado sobre el folio.
	 */
	public IConexion obtenerConexion(boolean modifica) {
		if (modifica) {
		}
		else {
		}	// if
		
		return ;
	}	// obtenerConexion
	

	/*
	 * Libera la estructura para liberar luego el candado sobre el folio.
	 */
	public void liberarConexion(IConexion icon, boolean ok) {
        icon.
	}   // liberarConexion

}   // ConexionArchivo
