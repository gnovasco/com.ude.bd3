package com.ude.obligatorio.persistencia.factories;

public class FabricaMySQL implements IPersistenciaFabrica
{
	public IDAOFolios crearFolios() {
		return new DAOFoliosMySQL;
	}
	
	public IDAORevisiones crearRevisiones() {
		return new DAORevisionesMySQL;
	}
}
