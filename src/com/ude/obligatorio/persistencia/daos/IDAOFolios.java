package com.ude.obligatorio.persistencia.daos;


import java.util.List;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;
import com.ude.obligatorio.poolConexiones.interfaces.IConexion;

public interface IDAOFolios {

	public boolean member(IConexion con,String cod) throws PersistenciaException;
	public void insert(IConexion con,Folio fol)  throws PersistenciaException;
	public Folio find(IConexion con,String cod) throws PersistenciaException;
    public void delete(IConexion con,String cod) throws PersistenciaException;
    public List<VOFolio> listarFolios(IConexion con) throws PersistenciaException;
    public boolean esVacio(IConexion con) throws PersistenciaException;
    public VOFolioMaxRev folioMasRevisado(IConexion con)throws PersistenciaException;
}
