package com.ude.obligatorio.poolConexiones;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

public class PoolConexionesArchivo implements IPoolConexiones {
	/*
	 * Atributos.
	 */
	
	// Bloqueo para mutua exclusion de la estructura.
	private IConexion [] conexiones;
	private int tamanio, tope;
	
	
	public PoolConexionesArchivo(int tam) {
		conexiones = new IConexion [tam];
		tope = -1;
		tamanio = tam;
	}
	
	
	public IConexion obtenerConexion(boolean modifica) {
		if ((tope + 1) < tamanio) {
			conexiones[++tope] = new ConexionArchivo();
			if (modifica) {
				((ConexionArchivo)conexiones[tope]).getCandado().writeLock().lock();
			}
			else {
				((ConexionArchivo)conexiones[tope]).getCandado().readLock().lock();
			}	// if
		}
		
		return conexiones[tope];
	}	// obtenerConexion
	
	
	public void liberarConexion(IConexion icon, boolean modifica) {
		int i = 0, j;
		
		// Buscar la conexion.
		while (conexiones[i] != icon)
			i++;
		
		if (modifica) {
			((ConexionArchivo)conexiones[i]).getCandado().writeLock().unlock();
		}
		else {
			((ConexionArchivo)conexiones[i]).getCandado().readLock().unlock();
		}	// if
		
		// Bajar las demas para que no haya huecos.
		for (j = i+1; j < tope; j++)
			conexiones[j] = conexiones[j + 1]; 
		tope -= 1;
	}	// liberarConexion
	
}   // PoolConexionesArchivo
