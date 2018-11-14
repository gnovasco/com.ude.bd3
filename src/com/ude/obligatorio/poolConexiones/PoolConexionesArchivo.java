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
	private Lock mapaLock = new ReentrantLock();

	// Array asociativo de nro. de folio a candado.
	private Map<String, ReadWriteLock> lockMap = new HashMap<String, ReadWriteLock>();


	/*
	 * Metodos.
	 */
	
	/*
	 * Bloquea la estructura para pedir el candado sobre el folio.
	 */
	public IConexion obtenerConexion(boolean modifica) {
		mapaLock.lock();
		return null;
	}	// obtenerConexion
	

	/*
	 * Libera la estructura para liberar luego el candado sobre el folio.
	 */
	public void liberarConexion(IConexion icon, boolean ok) {
        mapaLock.unlock();
	}   // liberarConexion


/*	
	private ReentrantReadWriteLock con;
	
	public PoolConexionesArchivo() {
        con = new ReentrantReadWriteLock();
	}   // PoolConexionesArchivo
	
	/*
	* Solicita una conexi�n al pool. En caso de que todas est�n actualmente en
	* uso, bloquear� al usuario hasta que otro usuario libere alguna.
	*
	public IConexion obtenerConexion(boolean modifica) {
        Lock bloq = null;
        
        try {
            if (modifica) {
                bloq =  con.writeLock();
            }
            else {
                bloq =  con.readLock();
            } // if
            bloq.lock();
        }
        
        return bloq;
	}   // obtenerConexion
	
	/*
	 * Devuelve una conexi�n al pool y avisa a posibles usuarios bloqueados.
	 *  Siok vale true, har� commit al devolverla, sino har� rollback. 
	 *
	public void liberarConexion(IConexion icon, boolean ok) {
        icon.unlock();
	}   // liberarConexion
*/
	
}   // PoolConexionesArchivo
