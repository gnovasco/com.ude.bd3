package com.ude.obligatorio.persistencia.factories;


import com.ude.obligatorio.persistencia.daos.DAOFoliosMySQL;
import com.ude.obligatorio.persistencia.daos.DAORevisionesMySQL;
import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class FabricaMySQL implements IPersistenciaFabrica
{

	@Override
	public IDAOFolios crearFolios() {
		return new DAOFoliosMySQL();
	}
	
	@Override
	public IDAORevisiones crearRevisiones(String codigo) {
		return new DAORevisionesMySQL(codigo);
	}

	
	
}