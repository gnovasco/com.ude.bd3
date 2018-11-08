package com.ude.obligatorio.persistencia.factories;

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