package com.ude.obligatorio.persistencia.factories;

public class TextoFabrica implements IPersistenciaFabrica
{
	/*
	 * Guardar en un archivo de texto simple.
	 */
	boolean guardar();
	
	/*
	 * Leer de un archivo de texto simple.
	 */
	int leer();
}