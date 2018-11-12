package com.ude.obligatorio.persistencia.factories;

import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public interface IPersistenciaFabrica
{
	/*
	 * Crear los DAO para la persistencia.
	 */
	public IDAOFolios crearFolios();
	public IDAORevisiones crearRevisiones();
}