package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;

import java.util.List;

public class DAORevisionesArchivo implements IDAORevisiones{
	public int largo() {
		//TODO IMPLLEMTENAR METODO
		return -1;
	}
	
	public List<VORevision> listarRevisiones() {
		//TODO IMPLLEMTENAR METODO
		return null;
	}
	
	public void borrarRevisiones() {
		//TODO IMPLLEMTENAR METODO
	}

	@Override
	public void insBack(Revision rev) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Revision kesimo(int numero) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}
}	// DAORevisionesTexto
