package com.ude.obligatorio.persistencia.factories;

import com.ude.obligatorio.persistencia.daos.DAORevisionesArchivo;
import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class FabricaArchivo implements IPersistenciaFabrica
{

	@Override
	public IDAOFolios crearFolios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDAORevisiones crearRevisiones(String codigo) {
		// TODO Auto-generated method stub
		return new DAORevisionesArchivo(codigo);
	}
	
}