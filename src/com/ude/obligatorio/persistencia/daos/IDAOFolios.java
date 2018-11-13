package com.ude.obligatorio.persistencia.daos;


import java.util.List;

import com.ude.obligatorio.logica.Folio;
import com.ude.obligatorio.logica.excepciones.PersistenciaException;
import com.ude.obligatorio.logica.valueObjects.VOFolio;
import com.ude.obligatorio.logica.valueObjects.VOFolioMaxRev;

public interface IDAOFolios {

	public boolean member(String cod) throws PersistenciaException;
	public void insert(Folio fol)  throws PersistenciaException;
	public Folio find(String cod) throws PersistenciaException;
    public void delete(String cod) throws PersistenciaException;
    public List<VOFolio> listarFolios() throws PersistenciaException;
    public boolean esVacio() throws PersistenciaException;
    public VOFolioMaxRev folioMasRevisado()throws PersistenciaException;
}
