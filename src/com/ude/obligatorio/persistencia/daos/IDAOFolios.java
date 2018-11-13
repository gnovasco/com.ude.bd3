package com.ude.obligatorio.persistencia.daos;


import java.util.List;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public interface IDAOFolios {
	//
	//creo que solo el insert debería de lanzar un throws, el resto no me parece necesario.
	//
	
	public boolean member(IConexion iConexion,String cod) throws PersistenciaException;
	public void insert(IConexion iConexion,Folio fol)  throws PersistenciaException;
	public Folio find(IConexion iConexion,String cod) throws PersistenciaException;
    public void delete(IConexion iConexion,String cod) throws PersistenciaException;
    public List<VOFolio> listarFolios(IConexion iConexion) throws PersistenciaException;
    public boolean esVacio(IConexion iConexion) throws PersistenciaException;
    public VOFolioMaxRev folioMasRevisado(IConexion iConexion)throws PersistenciaException;
}
