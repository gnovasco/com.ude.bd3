package com.ude.practico.logicaPersistencia.poolConexiones.interfaces;

public interface IPoolConexiones {
	
	/*
	* Solicita una conexión al pool. En caso de que todas estén actualmente en
	* uso, bloqueará al usuario hasta que otro usuario libere alguna.
	*/
	public IConexion obtenerConexion(boolean modifica); 
	
	/*
	 * Devuelve una conexión al pool y avisa a posibles usuarios bloqueados.
	 *  Siok vale true, hará commit al devolverla, sino hará rollback. 
	 */
	public void liberarConexion(IConexion icon, boolean ok);
	
}
