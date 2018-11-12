package com.ude.obligatorio.persistencia.factories;

import com.ude.obligatorio.persistencia.daos.DAOFoliosMySQL;
import com.ude.obligatorio.persistencia.daos.DAORevisionesMySQL;
import com.ude.obligatorio.persistencia.daos.IDAOFolios;
import com.ude.obligatorio.persistencia.daos.IDAORevisiones;

public class MySQLFabrica implements IPersistenciaFabrica
{
	public IDAOFolios crearFolios() {
		return new DAOFoliosMySQL();
	}
	
	public IDAORevisiones crearRevisiones() {
		return new DAORevisionesMySQL("");
	}
}