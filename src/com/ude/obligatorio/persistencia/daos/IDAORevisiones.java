package com.ude.obligatorio.persistencia.daos;

import com.ude.obligatorio.logica.Revision;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VORevision;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

import java.util.List;

public interface IDAORevisiones {

	public int largo(IConexion iConexion) throws PersistenciaException ;
	public List<VORevision> listarRevisiones(IConexion iConexion) throws PersistenciaException ;
	public void borrarRevisiones(IConexion iConexion) throws PersistenciaException ;
	public void insBack(IConexion iConexion,Revision rev) throws PersistenciaException;
	public Revision kesimo(IConexion iConexion,int numero) throws PersistenciaException;
}
