package com.ude.obligatorio.persistencia.factories;

import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class TextoFabrica implements IPersistenciaFabrica
{

	@Override
	public IDAOFolios crearFolios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDAORevisiones crearRevisiones() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * Guardar en un archivo de texto simple.
	 */
	//boolean guardar();
	
	/*
	 * Leer de un archivo de texto simple.
	 */
	//int leer();
}