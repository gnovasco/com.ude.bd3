package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;

import java.util.List;

public interface IDAORevisiones {

	public void insBack() throws PersistenciaException;
	public int largo() throws PersistenciaException ;
	public Revision kesimo() throws PersistenciaException ;
	public List<VORevision> listarRevisiones() throws PersistenciaException ;
	public void borrarRevisiones() throws PersistenciaException ;
}
