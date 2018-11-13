package com.ude.obligatorio.poolConexiones;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ude.obligatorio.poolConexiones.interfaces.IConexion;
import com.ude.obligatorio.poolConexiones.interfaces.IPoolConexiones;

public class PoolConexionesArchivo implements IPoolConexiones {
	
	private ReentrantReadWriteLock con;
	
	public PoolConexionesArchivo() {
        con = new ReentrantReadWriteLock();
	}   // PoolConexionesArchivo
	
	/*
	* Solicita una conexi�n al pool. En caso de que todas est�n actualmente en
	* uso, bloquear� al usuario hasta que otro usuario libere alguna.
	*/
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
	 */
	public void liberarConexion(IConexion icon, boolean ok) {
        icon.unlock();
	}   // liberarConexion
	
}   // PoolConexionesArchivo
