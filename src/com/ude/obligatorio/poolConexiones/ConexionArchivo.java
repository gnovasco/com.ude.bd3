package com.ude.obligatorio.poolConexiones;

import java.sql.Connection;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.sun.javafx.collections.MappingChange.Map;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public class ConexionArchivo implements IConexion {
	/*
	 * Atributos.
	 */
	
	// Array asociativo de nro. de folio a candado.
	private ReadWriteLock candado;


	/*
	 * Metodos.
	 */
	
	public ConexionArchivo() {
		candado = new ReentrantReadWriteLock();
	}
	
	public ConexionArchivo getCon() {
		return null;
	}
	
	public ReadWriteLock getCandado() {
		return candado;
	}

}   // ConexionArchivo
