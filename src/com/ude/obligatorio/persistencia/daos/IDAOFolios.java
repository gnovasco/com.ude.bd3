package com.ude.obligatorio.persistencia.daos;


import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;

public interface IDAOFolios {

	public boolean member(String cod) throws PersistenciaException;
	public void insert(Folio fol)  throws PersistenciaException;
	
}
