package com.ude.obligatorio.IPersistenciaFabrica;

public interface IPersistenciaFabrica
{
	/*
	 * Guardar en el mecanismo de persistencia.
	 */
	boolean guardar();
	
	/*
	 * Leer del mecanismo de persistencia.
	 */
	int leer();
}