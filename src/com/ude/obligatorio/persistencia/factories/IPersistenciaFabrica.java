package com.ude.obligatorio.persistencia.factories;

public interface IPersistenciaFabrica
{
	/*
	 * Crear los DAO para la persistencia.
	 */
	public IDAOFolios crearFolios();
	public IDAORevisiones crearRevisiones();
}