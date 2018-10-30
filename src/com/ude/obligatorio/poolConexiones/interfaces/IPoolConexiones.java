package com.ude.obligatorio.poolConexiones.interfaces;

public interface IPoolConexiones {
	
	/*
	* Solicita una conexi�n al pool. En caso de que todas est�n actualmente en
	* uso, bloquear� al usuario hasta que otro usuario libere alguna.
	*/
	public IConexion obtenerConexion(boolean modifica); 
	
	/*
	 * Devuelve una conexi�n al pool y avisa a posibles usuarios bloqueados.
	 *  Siok vale true, har� commit al devolverla, sino har� rollback. 
	 */
	public void liberarConexion(IConexion icon, boolean ok);
	
}
