package com.ude.obligatorio.persistencia.factories;

public class MySQLFabrica implements IPersistenciaFabrica
{
	/*
	 * Guardar en una base de datos MySQL.
	 */
	boolean guardar();
	
	/*
	 * Leer de una base de datos MySQL.
	 */
	int leer();
}