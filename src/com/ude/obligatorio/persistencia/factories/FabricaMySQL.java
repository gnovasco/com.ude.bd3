package com.ude.obligatorio.persistencia.factories;

import com.ude.obligatorio.persistencia.daos.DAOFoliosMySQL;
import com.ude.obligatorio.persistencia.daos.DAORevisionesMySQL;
import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class FabricaMySQL implements IPersistenciaFabrica
{
	public IDAOFolios crearFolios() {
		return new DAOFoliosMySQL();
	}
	
	public IDAORevisiones crearRevisiones() {
		//TODO agregar el string que falta
		return new DAORevisionesMySQL("");
	}
}
